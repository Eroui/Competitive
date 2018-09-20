import java.util.Scanner;

public class Solution {
    public static String s = "               ";
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                
                System.out.print(s1);
                System.out.print(s.substring(s1.length()));
                
                
                if(x < 10) System.out.println("00"+x);
                else if(x < 100) System.out.println("0"+x);
                else System.out.println(x);
            }
            System.out.println("================================");

    }
}
