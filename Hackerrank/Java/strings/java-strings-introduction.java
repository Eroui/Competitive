import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        
        System.out.println(A.length()+B.length());
        System.out.println(A.compareTo(B) >= 1 ? "Yes": "No");
        
        char[] arr = A.toCharArray();
        if(arr[0] >= 'a' && arr[0] <= 'z') arr[0] = (char) ('A'+arr[0]-'a');
        System.out.print(new String(arr)+" ");
        
        arr = B.toCharArray();
        if(arr[0] >= 'a' && arr[0] <= 'z') arr[0] = (char) ('A'+arr[0]-'a');
        System.out.println(new String(arr));
        
    }
}
