from asyncore import dispatcher
from asynchat  import async_chat
import socket, asyncore

PORT=5005

class ChatServer(dispatcher):

    def __init__(self,PORT):
        dispatcher.__init__(self)
        self.create_socket(socket.AF_INET,socket.SOCK_STREAM)
        self.set_reuse_addr()
        self.bind(('',PORT))
        self.listen(5)
        self.sessions=[]

    def handle_accept(self):
        conn, addr = self.accept()
        print(addr)
        print(conn)
        print('Connection attempt from', addr[0])
        self.sessions.append(ChatSession(conn))

class ChatSession(async_chat):

    def __init__(self,socket):
        async_chat.__init__(self,socket)
        self.set_terminator = "\r\n"
        self.data = []

    def collect_incoming_data(self,data):
        self.data.append(data)

    def found_terminator(self):
        line = ''.join(self.data)
        self.data=[]
        print(line)

if __name__ == "__main__":
    s = ChatServer(PORT)
    try:
        asyncore.loop()
    except KeyboardInterrupt:
        print()
