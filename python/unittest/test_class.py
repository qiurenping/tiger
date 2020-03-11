import unittest
from ClassStudy import Person,MemberCounter
from ClassStudy import *

class Test(unittest.TestCase,Person):

    def setUp(self):
        print("begin========")

    def tearDown(self):
        print("end========")

    def test_class_get_name(self):
        self.set_name("abc")
        self.set_name("def")
        bo = self.get_name2()
        ba = self.get_name2()
        self.assertEqual(bo,ba)

    def test_get_class_attribute(self):
        self.assertTrue(getattr(Person,"aa"))
        self.assertFalse(getattr(Person,"bb"))

    def test_get_class_attribute1(self):
        self.assertFalse(getattr(Person,"__get_name"))

    def test_set_class_function(self):
        self.set_name("who")
        tt = self.greet
        self.assertEqual(tt(),"Hello, world! I'm who.")

    def test_set_class_function1(self):
        self.greet = function
        self.assertEqual(self.greet(),"Hello,world! I'm a function2ssssqq")

    def test_set_class_menbers_counter(self):
        m1 = MemberCounter()
        m2 = MemberCounter()
        self.assertEqual(m1.members,m2.members,str(m1.members)+"="+str(m2.members))

    def test_arraylist(self):

        alist = [1,34,5,8,9]
        print(max(alist))

