import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
    
            int sum = a;
            int pow = 1;
            for(int j = 0; j < n; j++) {
                sum += pow * b;
                pow <<= 1;
                System.out.print(sum);
                if(j < n - 1) System.out.print(" ");
            }System.out.println();
        }
        in.close();
    }
}
