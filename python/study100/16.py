# -*- coding:utf-8 -*-

import datetime,time

fmt='%Y-%m-%d %a %A %H:%M:%S %j %p %W %w'

print(u'获取当前的时间1：',datetime.datetime.today().strftime(fmt))
print(u'获取当前的时间2：',datetime.date.today().strftime(fmt))

time_tup = time.localtime(time.time())
print(u'获取当前的时间3：',time.strftime(fmt,time_tup))
