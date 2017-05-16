package online.edu.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {

    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }
    public static String md5(String str){
        return new Md5Hash(str).toString();
    }
    public static void main(String[] args){
        System.out.println("hello world!!"+md5("123","遇见小星"));
            int f1 = 1;
            int f2 = 2;
            int f3 = 4;
            int result = 0;
            for(int i = 4;i<=15;i++){
                result = f1+f2+f3;
                f1 = f2;
                f2 = f3;
                f3 = result;
            }
            System.out.println(result);

    }
}
