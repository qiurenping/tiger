# -*- coding:UTF-8 -*-

a = []
for i in range(0,3):
    l = int(raw_input("Please input inger:\n"))
    a.append(l)
a.sort()
print a

a = [9,99,20,33,6,2,7,11,50]

for i in range(len(a)):
	m = a[i]
	for j in range(i+1,len(a)):
		n = a[j]
		if n < m:
			a[i],a[j]=n,m
			m = a[i]
print a
