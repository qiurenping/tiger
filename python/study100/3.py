# -*- coding:UTF-8 -*-

for i in range(1,85):
    if 168 % i == 0:
        j = 168 / i
        if i % 2 ==0 and j % 2 ==0 and i > j:
            m = (i + j) / 2
            n = (i - j) / 2
            x = n * n - 100
            print(x)