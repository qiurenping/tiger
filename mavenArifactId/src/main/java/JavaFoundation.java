import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EmployeeTest {
    String name;
    int age;
    String designation;
    double salary;
    // Employee 类的构造器
    public EmployeeTest(String name){
        this.name = name;
    }
    // 设置age的值
    public void empAge(int empAge){
        age =  empAge;
    }
    /* 设置designation的值*/
    public void empDesignation(String empDesig){
        designation = empDesig;
    }
    /* 设置salary的值*/
    public void empSalary(double empSalary){
        salary = empSalary;
    }
    /* 打印信息 */
    public void printEmployee(){
        System.out.println("名字:"+ name );
        System.out.println("年龄:" + age );
        System.out.println("职位:" + designation );
        System.out.println("薪水:" + salary);
    }
}

class Varaibles {
    static boolean bool;
    static byte by;
    static char ch;
    static double d;
    static float f;
    static int i;
    static long l;
    static short sh;
    static String str;


}

class Instanceariable{
    // 这个实例变量对子类可见
    public String name;
    // 私有变量，仅在该类可见
    private double salary;
    //在构造器中对name赋值
    public Instanceariable(String empName){
        name = empName;
    }
    //设定salary的值
    public void setSalary(double empSal){
        salary = empSal;
    }
    // 打印信息
    public void printEmp(){
        System.out.println("名字 : " + name );
        System.out.println("薪水 : " + salary);
    }
}

class BasicLearning{

    /*
Java 对象与类
 */
    public void testEmployeeTest(){
        /* 使用构造器创建两个对象 */
        EmployeeTest empOne = new EmployeeTest("RUNOOB1");
        EmployeeTest empTwo = new EmployeeTest("RUNOOB2");

        // 调用这两个对象的成员方法
        empOne.empAge(26);
        empOne.empDesignation("高级程序员");
        empOne.empSalary(1000);
        empOne.printEmployee();

        empTwo.empAge(21);
        empTwo.empDesignation("菜鸟程序员");
        empTwo.empSalary(500);
        empTwo.printEmployee();
    }

    /*
    Java 基本数据类型
     */
    public void testVariable(){
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE=" + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE=" + (int) Character.MAX_VALUE);
    }

    /*
    变量默认值
     */
    public void testDefaultVariable() {
        Varaibles v = new Varaibles();
        System.out.println("Bool :" + v.bool);
        System.out.println("Byte :" + v.by);
        System.out.println("Character:" + v.ch);
        System.out.println("Double :" + v.d);
        System.out.println("Float :" + v.f);
        System.out.println("Integer :" + v.i);
        System.out.println("Long :" + v.l);
        System.out.println("Short :" + v.sh);
        System.out.println("String :" + v.str);
    }

    /*
    自动类型转换与强制类型转换
     */
    public void automaticTypeConversion(){
        char c1='a';//定义一个char类型
        int i1 = c1;//char自动类型转换为int
        System.out.println("char自动类型转换为int后的值等于"+i1);
        char c2 = 'A';//定义一个char类型
        int i2 = c2+1;//char 类型和 int 类型计算
        System.out.println("char类型和int计算后的值等于"+i2);
        int i3 = 123;
        byte b = (byte)i3;//强制类型转换为byte
        System.out.println("int强制类型转换为byte后的值等于"+b);
    }

    /*
    测试实例变量
     */
    public void testInstanceVariable(){
        Instanceariable empOne = new Instanceariable("RUNOOB");
        empOne.setSalary(1000.0);
        empOne.printEmp();
        System.out.println(empOne.name);
    }

    /*
    Java数组变量
     */
    void testArraryList(){

        List<Double> arrylist = new ArrayList<Double>();
        arrylist.add(1.1);
        arrylist.add(2.2);
        arrylist.add(2,3.3);
        arrylist.add(3,4.4);
        for(double x:arrylist){
            System.out.println(x);
        }

        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        for(String l:list){
            System.out.println(l);
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //迭代器循环
        Iterator<String> ite=list.iterator();
        while(ite.hasNext())//判断下一个元素之后有值
        {
            System.out.println(ite.next());
        }

        //数组定义并初始化
        int[] alist = {1,25,3,47,5,11};
        //for普通循环找出最大值
        int max = alist[0];
        for(int i=0;i<alist.length;i++){
            System.out.println(alist[i]);
            if(alist[i]>max){
                max = alist[i];
            }
        }
        System.out.println("数组alist的最大值为："+max);

        //数组定义确定类型和长度
        double[] dlist = new double[10];
        dlist[0] = 1.1;
        dlist[1] = 2.2;
        //for增强型循环
        for(double d:dlist){
            System.out.println(d);
        }

        //定义字符串数组
        String[] myList = new String[10];
        myList[0] = "a";
        myList[1] = "b";
    }

    /*
    Java Map映射
     */
    void testHashMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("a","a1");
        map.put("b","b1");
        map.put("c","c1");

        //循环 key
        for(String key:map.keySet()){
            String value = map.get(key);
            System.out.println("key:"+key+" value:"+value);
        }
        //循环 value
        for(String value:map.values()){
            System.out.println("value:"+value);
        }

        //同时循环 key 和 value
        for(Map.Entry<String, String> entry:map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }

    /*
    Java字符串，固定不允许修改类String
     */
    void testStrings(){

        //字符串初始化与定义
        String astring = "Java学习字符串";
        String bstring = new String("abcdefg");
        String cstring = new String();
        char[] ac = {'a','b','c','d'};
        String dstring = new String(ac);    //char数组转化成字符串
        System.out.println(dstring);
        int[] aint = new int[3];
        aint[0] = 45;
        aint[1] = 98;
        aint[2] = 872;
        String estring = new String(String.valueOf(aint));    //int数组转换成字符串
        System.out.println(estring);

        //字符串格式化
        float floatVar = 1;
        int intVar = 2;
        String stringVar = "abcd";
        System.out.printf("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", floatVar, intVar, stringVar);

        String fs = String.format("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                " %s", floatVar, intVar, stringVar);
        System.out.println(fs);

    }

    /*
    Java字符串，可修改字符串长度
     */
    void testStringBuffer(){

        StringBuffer astring = new StringBuffer("Java学习StringBuffer ");
        astring.append("add1");
        System.out.println(astring);
        System.out.println(astring.reverse());  //反序输出
        System.out.println(astring.delete(0,5)); //删除前面五位
        System.out.println(astring.length()); //获取长度
        System.out.println(astring.insert(0,'A'));//在第一位插入A
        System.out.println(astring.replace(1,4,"Test"));//第1到第4位替换成Test
        System.out.println(astring.substring(1,4));//获取第1到第3位的字符
    }

    /*
    Java Character对象
     */
    void testCharacter(){
        char ch = 'a';
        Character dh = 'd';
        char[] chlist = {'a','b','c','d'};
        System.out.println(chlist.length);
        Character ac = new Character(ch);
        if(Character.isLetter(ch)){
            System.out.println(ch + " is a letter");
        }else if (Character.isDigit(ch)){
            System.out.println(ch+" is a Digit");
        }
    }

    /*
    Java Number类与Math类
     */
    void testNumberAndMath(){
        Integer a1 = 5;
        byte b1 = a1.byteValue();    //int类型转换成byte类型
        double b2 = a1.doubleValue();     //int类型转换成double
        String b3 = a1.toString();     //int类型转换成String
        int c1 = b1 + 5;
        System.out.println(c1);
        System.out.println(b3.equals(5));     //判断是否跟5相等
        System.out.println(a1.equals(5));     //判断是否跟5相等
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));
        System.out.println(Math.PI);

        double[] nums = { 1.4, 1.5, 1.6, -1.4, -1.5, -1.6 };
        for (double num : nums) {
            System.out.println("Math.floor(" + num + ")=" + Math.floor(num));
            System.out.println("Math.round(" + num + ")=" + Math.round(num));
            System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num));
        }
    }

    /*
    Java 测试从控制台输入输出
     */
    void testBufferedReader() throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');

        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));

    }

    /*
    文件写入数据与读取数据
     */
    void testFileStream(){
        //创建文件，并写入
        try{
            byte[] write = {'a','b','c','d','e','f'};
            FileOutputStream file = new FileOutputStream("file1.txt");
            for(byte wr:write){
                file.write(wr);
            }
            file.write(write);
            file.close();
            FileInputStream fileout = new FileInputStream("file1.txt");
            int size = fileout.available();
            for(int i=0;i<size;i++){
                System.out.print((char) fileout.read() + "  ");
            }
            fileout.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    /*
    文件的读取与创建
     */
    void testFile() {
        File f = new File("file2.txt");
        //写入数据
        try {
            FileOutputStream af = new FileOutputStream(f);
            OutputStreamWriter bf = new OutputStreamWriter(af,"UTF-8");
            bf.append("中文输入");
            bf.append("\r\n");
            bf.append("English");
            bf.close();
            af.close();
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取数据
        try {
            FileInputStream ef = new FileInputStream(f);
            InputStreamReader gf = new InputStreamReader(ef,"UTF-8");
            StringBuffer as = new StringBuffer();
            while (gf.ready()){
                as.append((char) gf.read());
            }
            //System.out.println(as.toString());
            gf.close();
            ef.close();
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //写数据
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("file3.txt"));
            out.write("Test FileWriter input text to file.");
            out.close();
            System.out.println("文件创建并写入成功");
        } catch (IOException e){
            e.printStackTrace();
        }
        //读数据
        try {
            BufferedReader in = new BufferedReader(new FileReader("file3.txt"));
            System.out.println(in.readLine());
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        //删除文件
        File file = new File("file3.txt");
        if(file.delete()){
            System.out.println(file.getName()+" 文件已被删除");
        }
        else {
            System.out.println(file.getName()+" 文件删除失败");
        }
    }

    /*
    文件判断
     */
    void testQueryFile(String filepath){
        File af = new File(filepath);
        if(af.isDirectory()){
            String[] afl = af.list();
            for(int i=0;i<afl.length;i++){
                String newfile = afl[i];
                String newfilepath = filepath +"\\"+newfile;
                File af2 = new File(newfilepath);
                if(af2.isDirectory()){
                    testQueryFile(newfilepath);             //循环调用
                    System.out.println(newfilepath+" 是一个目录");
                }else {
                    System.out.println(newfilepath+" 是一个文件");
                }
            }
        }
    }

    /*
    java创建目录
     */
    void testMakeFile(String file){
        File f = new File(file);
        f.mkdirs();
    }

    /*
    Java 日期与时间
     */
    void testDate() {
        //日期初始化
        long start = System.currentTimeMillis();
        Date at = new Date();
        System.out.println(at);  //打印当前时间
        System.out.println(at.getTime());  //打印当前时间戳
        long bt = at.getTime();
        Date ct = new Date(bt);  //时间戳转化成日期
        System.out.println(ct);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Difference is : " + diff);

        //日期比较
        try {
            Thread.sleep(1000 * 1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Date at1 = new Date();
        System.out.println(at.before(at1));   //at时间比 at1时间早
        System.out.println(at.after(at1));   //at时间比 at1时间早
        System.out.println(at.compareTo(at1));  //比较时间，早返回 -1 ，迟返回 1，相等返回 0
        System.out.println(at1.compareTo(at));
        System.out.println(at1.compareTo(at1));

        //日期格式化
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间为: " + ft.format(dNow));

        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",dNow);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",dNow);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",dNow);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",dNow);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",dNow);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",dNow);
    }

    /*
    Java 日期对象
     */
    void testCalendar(){
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));  //获取年
        c.set(1996,10,8);     //设置年月日
        System.out.println(c.get(Calendar.MONTH));
        c.add(Calendar.DATE,1);      //日期加一天
        System.out.println(c.get(Calendar.DATE));
        c.add(Calendar.MINUTE,-10);    //当前时间减10分钟
        System.out.println(c.get(Calendar.MINUTE));
    }

    /*
    测试Scanner类
     */
    public void testScanner(){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            System.out.println("next() 接收："+sc.next());
        }
        if(sc.hasNextLine()){
            System.out.println("nextLine() 接收:"+sc.nextLine());
        }
        if(sc.hasNextInt()){
            System.out.println("nextInt() 获取整数:"+sc.nextInt());
        }
        if(sc.hasNextFloat()){
            System.out.println("nextFloat() 获取浮点数："+sc.nextFloat());
        }
        sc.close();
    }

    /*
    Java 测试正则表达式
     */
    public void testRegex(){
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);  // 创建 Pattern 对象
        Matcher m = r.matcher(line);  //创建 matcher 对象
        if(m.find()){
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        }else {
            System.out.println("NO MATCH");
        }
    }

    /*
    Java 方法
     */
    public void testFunction(double... numbers){
        if(numbers.length == 0){
            System.out.println("Please input a number.");
            return;
        }
        double k = numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>k){
                k = numbers[i];
            }
        }
        System.out.println("The Max number is:"+k);
    }
}

public class JavaFoundation {
    public static void main(String[] args) throws IOException {
        BasicLearning e = new BasicLearning();
        //e.testEmployeeTest();
        //e.testVariable();
        //e.testDefaultVariable();
        //e.automaticTypeConversion();
        //e.testInstanceVariable();
        //e.testArraryList();
        //e.testHashMap();
        //e.testStrings();
        //e.testStringBuffer();
        //e.testCharacter();
        //e.testNumberAndMath();
        //e.testBufferedReader();
        //e.testFileStream();
        e.testFile();
        //e.testQueryFile("D:\\测试文档\\Java1");
        //e.testMakeFile("D:\\测试文档\\Java2");
        //e.testDate();
        //e.testCalendar();
        //e.testScanner();
        //e.testRegex();
        //e.testFunction(12,45.6,67,12,123,33,999.3,34);
        //e.testFunction(new double[]{1,42,45.4,22});
    }
}
