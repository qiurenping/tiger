# -*- coding:UTF-8 -*-

for i in range(101,200):
	leap = 1
	for k in range(2,i-1):
		if i%k == 0:
			leap = 0
			break
	if leap == 1:
		print i