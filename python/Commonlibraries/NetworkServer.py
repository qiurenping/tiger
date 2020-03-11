# -*- coding:UTF-8 -*-

import socket
import re
from urllib.request import urlopen

def testsocker():
    s = socket.socket()
    host ='127.0.0.1'
    port = 2345
    s.bind((host,port))
    s.listen(5)

    while True:
        c,addr = s.accept()
        print('Get connection from',addr)
        c.send('Thank you for connecting')
        c.close()

def testurllib():

    webpage = urlopen('https://www.baidu.com/')
    print(webpage.read())


testurllib()