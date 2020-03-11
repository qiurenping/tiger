import unittest
import os
from HTMLTestRunner import HTMLTestRunner

s = unittest.TestSuite()
loader = unittest.TestLoader()
s.addTests(loader.discover(os.getcwd()))

fp = open(os.getcwd() +"/test_report.html","wb")

runner = HTMLTestRunner(stream=fp,title="Class测试",description="类的学习")
runner.run(s)
