#coding:utf-8

class StudyClass(object):

    def __init__(self,a):
        self.name=a

    def dog(self):
        print("小狗的名字是："+self.name)

#父类定义
class people():
    #定义基本属性
    name = ''
    age = 0
    #定义私有属性,私有属性在类外部无法直接进行访问(两个下划线开头)
    __weight = 0
    #定义构造方法
    def __init__(self,n,a,w):
        self.name = n
        self.age = a
        self.__weight = w
    def speak(self):
        print("%s 说：我 %d 岁。"%(self.name,self.age))

    def speak_two(self):
        print("%s 说：我体重有 %d 斤。"%(self.name,self.__weight))

    #定义私有方法（两个下划线开头，声明该方法为私有方法，只能在类的内部调用 ，不能在类地外部调用）
    def __private_weight(self):
        return self.__weight*2

#父类定义2
class speaker():

    name = ''
    topic = ''

    def __init__(self,n,t):
        self.name = n
        self.topic = t

    def speak_three(self):
        print("我叫 %s，我是一个演说家，我演讲的主题是 %s"%(self.name,self.topic))

#多重继承示例
class student(people,speaker):

    grade = ''
    def __init__(self,n,a,w,g,t):
        #调用父类的构造函数
        people.__init__(self,n,a,w)
        speaker.__init__(self,n,t)
        self.grade = g
    #覆盖父类的方法
    def speak(self):
        print("%s 说：我 %d 岁了，我在读 %d 年级"%(self.name,self.age,self.grade))

if __name__ == "__main__":
    s = StudyClass("tommy")
    s.dog()
    print(s.name)

    x = student('ken',10,60,4,"如何学习python的对象与类")
    #子类调用重写方法
    x.speak()
    #子类调用父类方法
    x.speak_two()
    x.speak_three()
    #子类调用父类已被覆盖的方法
    super(student,x).speak()
    #子类访问父类私有方法---报错
    print(x.__private_weight)
