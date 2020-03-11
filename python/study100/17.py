#-*- coding:utf-8 -*-

c = input('Please input a string:\n')
i = 0
letters = 0
spaces = 0
digits = 0
others = 0

while i < len(c):
	k = c[i]
	i += 1
	if k.isalpha():
		letters += 1
	elif k.isspace():
		spaces += 1
	elif k.isdigit():
		digits += 1
	else:
		others += 1
print('char = %d,space = %d,digit = %d,others = %d' % (letters,spaces,digits,others))