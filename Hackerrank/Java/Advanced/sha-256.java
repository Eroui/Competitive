import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.MessageDigest;

public class Solution {

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        MessageDigest md5 = MessageDigest.getInstance("SHA-256");
        md5.update(line.getBytes());
        byte hash[] = md5.digest();
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
     
        System.out.println(sb.toString());
        
    }
}