import re

class Handler:
    """
    对Parser发起的方法调用进行处理的对象

    Parser将对每个文本块调用方法start()和end()，并将合适
    的文本块名称作为参数。方法sub()将用于正则表达式替换，
    使用诸如'emphasis'等名称调用时，这个方法将返回相应的
    替换函数
    """
    def callback(self, prefix, name,args=None):
        method = getattr(self, prefix + name,None)
        if callable(method):
            return method(args)

    def start(self, name):
        self.callback('start_', name)

    def end(self, name):
        self.callback('end_', name)

    def sub(self, name):
        def substitution(match):
            result = self.callback('sub_', name,match)
            if result is None:
                result = match.group(0)
            return result

        return substitution

class HTMLRenderer(Handler):
    """
    用于渲染HTML的具体处理程序
    HTMLRenderer的方法可通过超类Handler的方法
    start()、end()和sub()来访问。这些方法实现了
    HTML文档使用的基本标记
    """

    def start_document(self,match):
        print('<html><head><title>...</title></head><body>')

    def end_document(self,match):
        print('</body></html>')

    def start_paragraph(self,match):
        print('<p>')

    def end_paragraph(self,match):
        print('</p>')

    def start_heading(self,match):
        print('<h2>')

    def end_heading(self,match):
        print('</h2>')

    def start_list(self,match):
        print('<ul>')

    def end_list(self,match):
        print('</ul>')

    def start_listitem(self,match):
        print('<li>')

    def end_listitem(self,match):
        print('</li>')

    def start_title(self,match):
        print('<h1>')

    def end_title(self,match):
        print('</h1>')

    def sub_emphasis(self, match):
        return '<em>{}</em>'.format(match.group(1))

    def sub_url(self, match):
        return '<a href="{}">{}</a>'.format(match.group(1), match.group(1))

    def sub_mail(self, match):
        return '<a href="mailto:{}">{}</a>'.format(match.group(1), match.group(1))

    def feed(self, data):
        print(data)
