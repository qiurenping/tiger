


public class HelloWorld {

    static String a_class = "abcdefg";

    public static void main(String []args){
        System.out.println("Hello World");
        System.out.println(a_class.length());
        System.out.println(a_class.substring(2,5));
        System.out.println(a_class.replace("a","A"));
        System.out.println(a_class.startsWith("a"));
    }
}
