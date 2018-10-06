import java.io.*;

public class StudyClass {

    //成员变量
    String breed;
    int age;
    String color;

    StudyClass(String name){
        //这个构造器仅有一个参数：name
        System.out.println("小狗的名字是："+name);
    }
    public void setBreed(String b){
        breed = b;
    }
    public void setAge(int a){
        age = a;
    }
    public void setColor(String c){
        color = c;
    }

    public int getAge(){
        System.out.println("小狗的年龄是："+age);
        return age;
    }

    public static void main(String []args){
        // 下面的语句将创建一个StudyClass对象
        StudyClass dog = new StudyClass("tommy");
        dog.setAge(10);
        dog.setBreed("breed");
        dog.setColor("green");
        dog.getAge();
    }
}
