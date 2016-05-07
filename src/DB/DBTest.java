package DB;

import java.io.*;
import java.sql.Connection;

/**
 * Created by sarleon on 16-5-6.
 */
public class DBTest {
    public static void main(String[] args) {
        User user=new User();
        user.setUsername("asd");
        user.setPassword("12345");
        System.out.println(UserDAO.login(user));
        mkdir("asd");
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
}
