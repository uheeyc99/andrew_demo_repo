#! python
# -*- coding:UTF-8 -*-

from socket import *
from time import ctime

HOST = ""
PORT = 65535
BUFSIZE = 10240

ADDR = ("",PORT)

udpSerSock = socket(AF_INET, SOCK_DGRAM)
udpSerSock.bind(ADDR)
fileHandle = open ( 'log.txt', 'a' )
print 'listening on port : %s'%(PORT)
while True:
    #print 'wating for message.......'
    data, addr = udpSerSock.recvfrom(BUFSIZE)
    
    fileHandle.write(ctime()+': '+ '{' + data + '}' + '\n')
    #fileHandle.close()
    #udpSerSock.sendto('[%s] %s'%(ctime(),data),addr)
    #udpSerSock.sendto(data,addr)
    #print '...received from and retuned to:',addr
    print ctime(),':','{',data,'}'
udpSerSock.close()
