package DB;

import java.io.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

/**
 * Created by sarleon on 16-5-6.
 */
public class DBTest {
    public static void main(String[] args) {
        User user=new User();
        user.setUsername("asd");
        user.setPassword("12345");
      //  System.out.println(UserDAO.login(user));
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String  time=df.format(new Date());
        System.out.println(findCopyAddress("test2","asd"));
    }
    public static void mkdir(String string){
        Runtime runtime=Runtime.getRuntime();
        String out="";
        Process process=null;
        try {
           process=runtime.exec("mkdir Code/"+string);

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((out=bufferedReader.readLine())!=null){
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean findAddress(String string){
        Runtime runtime=Runtime.getRuntime();
        String out="";
        boolean result=false;
        Process process=null;
        try {
            process=runtime.exec("ls Code/");

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((out=bufferedReader.readLine())!=null){
                if(string.trim().equals(out.trim())){
                    result=true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }


    public static boolean findCopyAddress(String filename,String username){
        Runtime runtime=Runtime.getRuntime();
        String out="";
        boolean result=false;
        Process process=null;
        try {
            process=runtime.exec("ls Code/"+username);

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((out=bufferedReader.readLine())!=null){
                if(("_"+filename).trim().equals(out.trim())){
                    result=true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }

    public static void makeCopeDir(String filename,String username){
        Runtime runtime=Runtime.getRuntime();
        try {
            Process process=runtime.exec("mkdir Code/"+username+"/_"+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String[] getFileList(String username){
        Runtime runtime=Runtime.getRuntime();
        ArrayList<String> stringArrayList=new ArrayList<String>();
        String temp="";
        Process process=null;
        try {
            process=runtime.exec("ls Code/"+username+"/");

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((temp=bufferedReader.readLine())!=null){
                if(temp.charAt(0)!='_')
                    stringArrayList.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] result=new String[stringArrayList.size()];
        for (int i = 0; i < stringArrayList.size(); i++) {
            result[i]=stringArrayList.get(i);
        }
        return  result;

    }

    public static String[] getFileCopyList(String username,String fileName){
        Runtime runtime=Runtime.getRuntime();
        ArrayList<String> stringArrayList=new ArrayList<String>();
        String temp="";
        Process process=null;
        try {
            process=runtime.exec("ls Code/"+username+"/_"+fileName);

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((temp=bufferedReader.readLine())!=null){

                    stringArrayList.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] result=new String[stringArrayList.size()];
        for (int i = 0; i < stringArrayList.size(); i++) {
            result[i]=stringArrayList.get(i);
        }
        return  result;

    }


}
