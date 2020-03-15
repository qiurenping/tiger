package com.xmind;

import org.xmind.core.CoreException;

import java.io.IOException;
import java.util.*;

public class main{

    public static void main(String[] args) throws IOException, CoreException {

        XmindRead xmind = new XmindRead();

        String rootPath = System.getProperty("user.dir");
        String xmindPath = rootPath + "\\file\\test.xmind";
        System.out.println(xmindPath);
        List<String> lists = xmind.xmindToList(xmindPath);
        for (String l:lists){
            System.out.println(l);
        }

        main.writeexcel();
        main.writeread();
    }

    public static void writeexcel() {

        String fileDir = System.getProperty("user.dir")+"\\file\\workbook.xlsx";
        ExcelCreate ec = new ExcelCreate();
        ExcelWriter ew = new ExcelWriter();

        List<String> sheetName = new ArrayList();

        sheetName.add("A");
        sheetName.add("B");
        sheetName.add("C");

        System.out.println(sheetName);

        String[] title = {"id","name","password"};
        ec.createExcelXlsx(fileDir, sheetName, title);

        List<Map<String,String>> userList1 = new ArrayList<Map<String,String>>();
        Map<String,String> map=new HashMap<String,String>();
        map.put("id", "111");
        map.put("name", "张三");
        map.put("password", "111！@#");

        Map<String,String> map2=new HashMap<String,String>();
        map2.put("id", "222");
        map2.put("name", "李四");
        map2.put("password", "222！@#");

        Map<String,String> map3=new HashMap<String,String>();
        map3.put("id", "33");
        map3.put("name", "王五");
        map3.put("password", "333！@#");
        userList1.add(map);
        userList1.add(map2);
        userList1.add(map3);

        Map<String, List<Map<String, String>>> users = new HashMap();

        users.put("A", userList1);

        List<Map<String,String>> userList2 = new ArrayList<Map<String,String>>();
        Map<String,String> map4=new HashMap<String,String>();
        map4.put("id", "111");
        map4.put("name", "张三");
        map4.put("password", "111！@#");

        Map<String,String> map5=new HashMap<String,String>();
        map5.put("id", "222");
        map5.put("name", "李四");
        map5.put("password", "222！@#");

        Map<String,String> map6=new HashMap<String,String>();
        map6.put("id", "33");
        map6.put("name", "王五");
        map6.put("password", "333！@#");
        userList2.add(map4);
        userList2.add(map5);
        userList2.add(map6);

        users.put("B", userList2);

        List<Map<String,String>> userList3 = new ArrayList<Map<String,String>>();

        users.put("C", userList3);

        System.out.println(sheetName.size());

        //删除List 集合中特定的元素
        for(Iterator<String> sheeNameIterator = sheetName.iterator(); sheeNameIterator.hasNext();){
            String sheet = sheeNameIterator.next();
            if ( users.get(sheet).size() == 0) {
                sheeNameIterator.remove();
            }
        }

        System.out.println(sheetName.size());
        ec.createExcelXlsx(fileDir, sheetName, title);
        for (int j = 0; j < sheetName.size(); j++) {
            try {
                ew.writeToExcelXlsx(fileDir, sheetName.get(j), users.get(sheetName.get(j)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeread() throws IOException {
        ExcelReader e = new ExcelReader();
        System.out.println(System.getProperty("user.dir"));
        String filepath = System.getProperty("user.dir")+"\\file\\test.xlsx";
        List<String> al = e.ExcelReader(filepath);
        for(String a:al){
            System.out.println(a);
        }
    }
}
