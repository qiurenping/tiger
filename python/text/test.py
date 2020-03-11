
import re

class TestRe:

    methods = []

    def set_name(self,name="hello 123 world 456"):
        self.inputStr = name
        return "Add name Sucess"

    def get_name(self):
        return self.inputStr

    def _add111(self,matched):
        intStr = matched.group("number")
        intValue = int(intStr)
        addedValue = intValue + 111
        addedValueStr = str(addedValue)
        return addedValueStr

    def check_add(self):
        replacedStr = re.sub("(?P<number>\d+)", self._add111, self.inputStr)
        return "replacedStr="+replacedStr

    def check_w(self):
        emphasis_pattern = r'(\w+)'
        res = re.sub(emphasis_pattern, r'<em>\1</em>', 'TThis is a test')
        return res

    def check_all(self):
        emphasis_pattern = r'(.+)'
        res2 = re.sub(emphasis_pattern, r'<em>\1</em>', '* This * is * it * !')
        return res2

    def check_group(self):
        inputStr2="hello python,ni hao c,zai jian python"
        replaceStr=re.sub(r"hello (?P<word1>\w+),ni hao (?P<word2>\w+),zai jian \1","\g<word2>",inputStr2)
        return replaceStr

    def check_find(self):
        a = re.findall("(?P<number>\d+)",self.inputStr)
        return a

    def check_format(self):
        a = '<em>{}</em>'.format("test")
        return a

    def check_http(self):
        r1 = r'(http://[\.a-zA-Z/]+)'
        blcok = 'What is SPAM? (http://wwspam.fu/whatisspam)'
        return re.sub(r1,r'<em>\1</em>',blcok)

    def condition(self,block):
        return not '\n' in block and len(block) <= 70 and not block[-1] == ':'

    def add_func(self,obj):
        method = getattr(self, obj, None)
        if callable(method):
            return self.methods.append(method)


class Test(TestRe):

    def __init__(self):
        self.add_func("set_name")
        self.add_func("get_name")
        self.add_func("check_add")

handler = Test()
for i in handler.methods:
    print(i())



