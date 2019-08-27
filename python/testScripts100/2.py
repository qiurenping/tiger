# -*- coding:utf-8 -*-

imput_arrs = raw_input()
arrs = [1000000,600000,400000,200000,100000,0]
rat = [0.01,0.015,0.03,0.05,0.075,0.1]

flag = 0
for i in range(0,6):
	if int(imput_arrs) >= arrs[i]:
		if flag == 0:
			count_arrs = (int(imput_arrs)-arrs[i])*rat[i]
			flag = 1
		elif flag == 1:
			count_arrs += (arrs[i-1]-arrs[i])*rat[i]
print count_arrs