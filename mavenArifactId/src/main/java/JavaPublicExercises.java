import net.sf.json.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.nio.channels.Channel;
import java.util.*;

class FreshJuice {
    //定义枚举enum
    enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }
    FreshJuiceSize size;
}

class Test100{

    //一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数
    public void sumOfFactors() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            int sn = 0;
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sn = sn + j;
                    list.add(j);
                }
            }
            if (sn == i) {
                System.out.println(i);
                System.out.println(list);
            }
        }
    }

    /*
    一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
     */
    public void theBallDropped() {
        float height = 100;
        float sum = 200;
        float k = 0;
        for (int i = 3; i <= 10; i++) {
            float j = height / 2;
            height = j;
            //System.out.println(j);
            sum = sum + j;
            k = j / 4;
        }
        System.out.println(sum);
        System.out.println(k);
    }

    /*
    猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     */
    public void monkeyStealingPeach() {
        int i = 1, j = 1;
        System.out.println(j);
        while (i < 10) {
            j = (j + 1) * 2;
            i++;
            System.out.println(j);
        }
        System.out.println("第一天摘的苹果数："+j);
    }
}

class NetworkInstance{

    /*
    获取本机ip地址及主机名
     */
    public void getLocalIPAddressAndHostName() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Local HostAddress:" + addr.getHostAddress());
            String hostname = addr.getHostName();
            System.out.println("Local host name: " + hostname);
        }catch (UnknownHostException e){
            System.out.println(e);
        }
    }
    /*
    使用 Socket 连接到指定主机
     */
    public void socketConnetHost(){
        try{
            Socket sock = new Socket("www.runoob.com", 80);
            InetAddress addr = sock.getInetAddress();
            System.out.println("连接到 " + addr);
            sock.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    网页抓取
     */
    public void webScraping(){
        try{
            URL url = new URL("http://www.runoob.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    URL GET
     */
    public void doGet(String httpurl) {
        StringBuffer result = new StringBuffer();
        BufferedReader br = null;
        InputStream is = null;
        HttpURLConnection connection = null;
        try{
            URL url = new URL(httpurl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.connect();

            if(connection.getResponseCode() == 200){
                is = connection.getInputStream();
                if(is != null){
                    br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String temp = null;
                    while ((temp=br.readLine())!=null){
                        result.append(temp);
                    }
                }
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            connection.disconnect();
        }
        System.out.println(result.toString());
    }
    /*
    POST请求，获取token
     */
    public void doPost(){
        Map tokenbody = new HashMap<String,Map>();
        Map auth = new HashMap();
        Map identity = new HashMap<String,Map>();
        Map scope = new HashMap<String,Map>();
        Map project = new HashMap();
        Map password = new HashMap();
        List methods = new ArrayList<String>();
        Map user = new HashMap();
        Map domain = new HashMap<String,String>();
        scope.put("project",project);
        project.put("id","51024fab74044d18aa978d3b2390568c");
        methods.add("password");
        user.put("name","qiurping");
        user.put("password","5612jjmuut");
        domain.put("name","qiurping");
        user.put("domain",domain);
        password.put("user",user);
        identity.put("password",password);
        identity.put("methods",methods);
        auth.put("identity",identity);
        auth.put("scope",scope);
        tokenbody.put("auth",auth);
        JSONObject json = JSONObject.fromObject(tokenbody);
        System.out.println(json);  //打印请求的body

        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod("https://iam.cn-north-1.myhwclouds.com/v3/auth/tokens");
        String body = json.toString();
        postMethod.setRequestBody(body);
        try {
            httpClient.executeMethod(postMethod);
            byte[] info = postMethod.getResponseBody();  //获取响应的body
            String res = new String(info);
            System.out.println(res);
            Header[] headres = postMethod.getResponseHeaders();   //获取响应的消息头
            for(Header header:headres){
                if(header.getName().equals("X-Subject-Token")) {
                    System.out.println(header.getValue());   //打印token值
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

class MultiThreadedProgramming extends Thread{

    private Thread t;
    private String threadName;

    MultiThreadedProgramming( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start();
        }
    }

}

class PrintGraphics{

    /*
    打印菱形
     */
    public void printDiamond(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(i+j<4 ||j-i>4 ||i-j>4 || i+j>12){
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    /*
    打印九九乘法表
     */
    public void printNinetyninemultiplicationtable(){

        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+i*j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class StringFuction{

    String str1 = "Hello a Hello b Hello c java d java";

    public void compareString(){
        String str1 = "Hello World!";
        String str2 = "Hello World!";
        String str3 = "Hellwed";
        String str4 = "Hello";
        String str5 = "hello world!";

        int result1 = str1.compareTo(str2);
        System.out.println(result1);
        int result2 = str1.compareTo(str3);
        System.out.println(result2);
        int result3 = str1.compareTo(str4);
        System.out.println(result3);
        int result4 = str1.compareToIgnoreCase(str5);
        System.out.println(result4);
    }

    public void indexString(){
        String str1 = "Hello a Hello b Hello c java d java";
        System.out.println(str1+" LENGTH IS:"+str1.length());
        int lastindexjava = str1.lastIndexOf("java");
        System.out.println("java lastindex of:"+lastindexjava);
        int indexjava = str1.indexOf("java");
        System.out.println("java index of:"+indexjava);

    }

    public void subString(){
        System.out.println(str1.substring(2,10));
        System.out.println(str1.replace('l','t'));
        String str3 = new StringBuffer(str1).reverse().toString();
        System.out.println(str3);
        String[] str4 = str1.split("l");
        for(String t:str4){
            System.out.println(t);
        }
    }

    public void StringComparePerformance(){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            String s1 = "hello";
            String s2 = "hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("通过 String 关键词创建字符串"
                + " : "+ (endTime - startTime)
                + " 毫秒" );
        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            String s3 = new String("hello");
            String s4 = new String("hello");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("通过 String 对象创建字符串"
                + " : " + (endTime1 - startTime1)
                + " 毫秒");
    }

    public void StringOptimization(){
        String variables[] = new String[50000];
        for( int i=0;i <50000;i++){
            variables[i] = "s"+i;
        }
        long startTime0 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            variables[i] = "hello";
        }
        long endTime0 = System.currentTimeMillis();
        System.out.println("直接使用字符串： "+ (endTime0 - startTime0)  + " ms" );
        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            variables[i] = new String("hello");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用 new 关键字：" + (endTime1 - startTime1) + " ms");
        long startTime2 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            variables[i] = new String("hello");
            variables[i] = variables[i].intern();
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("使用字符串对象的 intern() 方法: "
                + (endTime2 - startTime2)
                + " ms");
    }

}

class ArrayFunctions{

    public void insertElementToArray(){
        int[] array1 = {-9,2,-1,5,1,9,7,8};
        Arrays.sort(array1);
        for(int j:array1){
            System.out.println(j);
        }
        int index = Arrays.binarySearch(array1, 5);
        System.out.println("5 index is: "+index);

        int length = array1.length;
        int[] distination = new int[length+1];
        System.arraycopy(array1,0,distination,0,index);
        distination[index] = 6;
        System.arraycopy(array1,index,distination,index+1,length-index);
        for (int m:distination){
            System.out.println(m);
        }
    }
}

public class JavaPublicExercises {
    public static void main(String[] args) {

        /*
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;

        Test100 test100 = new Test100();
        test100.theBallDropped();
        test100.monkeyStealingPeach();
        */
        //NetworkInstance nett = new NetworkInstance();
        //nett.getLocalIPAddressAndHostName();
        //nett.socketConnetHost();
        //nett.webScraping();
        //nett.doGet("https://www.baidu.com/");
        //nett.doPost();
        /*
        for(int i=1;i<=200;i++){
            String name = "Thread"+i;
            MultiThreadedProgramming T1 = new MultiThreadedProgramming(name);
            T1.start();
            System.out.println(System.currentTimeMillis());
        }
         */
        PrintGraphics prit = new PrintGraphics();
        prit.printDiamond();
        prit.printNinetyninemultiplicationtable();

        StringFuction strt = new StringFuction();
        strt.compareString();
        strt.indexString();
        strt.subString();
        strt.StringComparePerformance();
        strt.StringOptimization();

        ArrayFunctions arrayl = new ArrayFunctions();
        arrayl.insertElementToArray();

    }
}
