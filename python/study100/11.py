# -*- coding:UTF-8 -*-

def fib(n):
    if n==1 or n==2:
        return 1
    return fib(n-1)+fib(n-2)


for i in range(1,33):
    print '%12ld' % fib(i),
    if (i%4==0):
        print ''
