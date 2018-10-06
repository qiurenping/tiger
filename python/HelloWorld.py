
import keyword

class HelloWorld(object):

    a_class = "abcdefg"

    def printHellWorld(self):
        print("Hello World")
        print(keyword.kwlist)
        print(self.a_class[2:5])
        print(len(self.a_class))
        print(self.a_class.replace("a","A"))
        print(self.a_class.startswith("a"))

if __name__ == "__main__":
    HelloWorld().printHellWorld()