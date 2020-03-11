import math
import os
import sys
import re
import requests
import selenium
import logging
import paramiko
import time
import robot
import json
import xml.sax
import pymysql
import random
import unittest
import cx_Oracle

class PythonCommonLibrary:

  def testPymysql(self):
    db = pymysql.connect(host='192.168.77.129',port=3306,user="test", password="Huawei@123", database="test", charset='utf8')
    cursor = db.cursor()
    sql = '''SELECT id, name FROM test.`table`;'''
    cu = cursor.execute(sql)
    print(cursor.fetchall())
    cursor.close()
    db.close()

  def testParamiko(self):
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    ssh.connect(hostname='192.168.77.128',port=22,username='root',password='RfvTgb19@')
    stdin, stdout, stderr = ssh.exec_command('df')
    result = stdout.read()
    print(result)
    ssh.close()

  def testRequests(self):
    data={
    "auth": {
      "identity": {
        "methods": [
          "password"
        ],
        "password": {
          "user": {
            "name": "qiurping",
            "password": "5612jjmuut",
            "domain": {
              "name": "qiurping"
            }
          }
        }
      },
      "scope": {
        "project": {
          "id": "51024fab74044d18aa978d3b2390568c"
        }
      }
    }
  }
    j = json.dumps(data)
    url = "https://iam.cn-north-1.myhwclouds.com/v3/auth/tokens"
    r = requests.post(url=url,data=j,verify=False)
    print(r.json())
    print(r.status_code)
    print(r.headers)

if __name__ == "__main__":
  a = PythonCommonLibrary()
  a.testRequests()

