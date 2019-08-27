# -*- coding:UTF-8 -*-

year = int(raw_input('year:\n'))
month = int(raw_input('month:\n'))
day = int(raw_input('day:\n'))

days = [0,31,59,90,120,151,181,212,243,274,304,334]
all_days = 0
if 0 < month <=12:
    all_days =  days[month-1]
    all_days += day
else:
    all_days = day

if ((year % 4 == 0 and year % 100 ==0) or (year % 400 == 0))and month >=3:
    all_days += 1

print all_days


