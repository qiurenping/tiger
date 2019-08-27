# -*- coding:UTF-8 -*-

for i in range(100,999):
	j = i/100
	m = i%100/10
	n = i%100%10
	if j**3 + m**3 + n**3 == i:
		print i