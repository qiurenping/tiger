from flask import Flask
from flask import request
from functools import wraps
import re
from datetime import datetime
from datetime import timedelta
from apig_sdk import signer

app = Flask(__name__)


def requires_apigateway_signature():
    def wrapper(f):

        secrets = {
            "071fe245-9cf6-4d75-822d-c29945a1e06a": "c6e52419-2270-4cb8-8bd4-ae7fdd01dcd5"
        }
        authorizationPattern = re.compile(
            r'SDK-HMAC-SHA256\s+Access=([^,]+),\s?SignedHeaders=([^,]+),\s?Signature=(\w+)')
        BasicDateFormat = "%Y%m%dT%H%M%SZ"

        @wraps(f)
        def wrapped(*args, **kwargs):
            if "authorization" not in request.headers:
                return 'Authorization not found.', 401
            authorization = request.headers['authorization']
            m = authorizationPattern.match(authorization)
            if m is None:
                return 'Authorization format incorrect.', 401
            signingKey = m.group(1)
            if signingKey not in secrets:
                return 'Signing key not found.', 401
            signingSecret = secrets[signingKey]
            signedHeaders = m.group(2).split(";")
            r = signer.HttpRequest()
            r.method = request.method
            r.uri = request.path
            r.query = {}
            for k in request.query_string.decode('utf-8').split('&'):
                spl = k.split("=", 1)
                if len(spl) < 2:
                    r.query[spl[0]] = ""
                else:
                    r.query[spl[0]] = spl[1]

            r.headers = {}
            needbody = True
            dateHeader = None
            for k in signedHeaders:
                if k not in request.headers:
                    return 'Signed header ' + k + ' not found', 401
                v = request.headers[k]
                if k.lower() == 'x-sdk-content-sha256' and v == 'UNSIGNED-PAYLOAD':
                    needbody = False
                if k.lower() == 'x-sdk-date':
                    dateHeader = v
                r.headers[k] = v
            if needbody:
                r.body = request.get_data()

            if dateHeader is None:
                return 'Header x-sdk-date not found.', 401
            t = datetime.strptime(dateHeader, BasicDateFormat)
            if abs(t - datetime.utcnow()) > timedelta(minutes=15):
                return 'Signature expired.', 401

            sig = signer.Signer()
            sig.Key = signingKey
            sig.Secret = signingSecret
            if not sig.Verify(r, m.group(3)):
                return 'Verify authroization failed.', 401
            return f(*args, **kwargs)

        return wrapped

    return wrapper


@app.route("/<id>", methods=['GET', 'POST', 'PUT', 'DELETE'])
@requires_apigateway_signature()
def hello(id):
    return "Hello World!"

if __name__ == '__main__':
    app.run('127.0.0.1', 8088)
