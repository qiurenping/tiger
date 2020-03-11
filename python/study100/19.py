# -*- coding:utf-8 -*-

n = int(input("Please input a number:"))

for m in range(1,n):
    k = 0
    j = []
    for i in range(1,m):
        if m % i == 0:
            j.append(i)
            k = k + i

    if k == m:
        print(str(m)+"="+str(j))