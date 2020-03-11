#!/usr/bin/python
# -*- coding: UTF-8 -*-
import time
for i in range(20):
	print time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
	time.sleep(1)