#-*- coding:utf-8 -*-

import re

a = "hello world!"
print(a.find("l"))
print(a.rfind("l"))
print([m.start() for m in re.finditer('l',a)])
print(a.index("l"))

for m in re.finditer('[l|o]',a):
    print(m.group(0))