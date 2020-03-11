
class Person:

    #print("Begin Class Person")

    aa = "a"

    def set_name(self, name):
         self.__name = name

    def __get_name(self):
         return self.__name

    def get_name2(self):
        return self.__get_name()

    def get_class(self):
        return self.__class__()

    def greet(self):
        return "Hello, world! I'm {}.".format(self.__name)


def function():
    return "Hello,world! I'm a function"

class MemberCounter:
    members = 0
    def __init__(self):
        MemberCounter.members += 1



