import socket

s = socket.socket()
host ='127.0.0.1'
port = 2345
s.connect((host,port))
print(s.recv(1024))