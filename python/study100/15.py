# -*- coding:utf-8 -*-

grade = int(input(u'Please input a number:\n'))

if grade >= 90:
	level = 'A'
elif grade >= 60:
	level = 'B'
else:
	level = 'C'

print(u'%d 属于 %s' % (grade,level))