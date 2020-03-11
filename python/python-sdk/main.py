# coding=utf-8
import requests
from apig_sdk import signer

if __name__ == '__main__':
    sig = signer.Signer()
    sig.Key = "071fe245-9cf6-4d75-822d-c29945a1e06a"
    sig.Secret = "c6e52419-2270-4cb8-8bd4-ae7fdd01dcd5"

    r = signer.HttpRequest("POST",
                           "http://127.0.0.1:8088/test",
                           {'abc':'abc'},
                           'body')
    sig.Sign(r)
    print(r.headers["X-Sdk-Date"])
    print(r.headers["Authorization"])
    resp = requests.request(r.method, r.scheme + "://" + r.host + r.uri, headers=r.headers,data=r.body,verify=False)
    print(resp.status_code, resp.reason)
    print(resp.content)
