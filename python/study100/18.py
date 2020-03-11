# -*- coding: UTF-8 -*-
import sys

input = sys.argv
a = int(input[1])
n = int(input[2])
an,count = 0,0
for i in range(n):
    an = an + a*(10**i)
    print(an)
    count = count + an

print(count)
