import java.util.Scanner;

public class Solution {

    // Solution Start

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
         for(int i = 1; i <= s.length() - k ; ++i) {
             String tmp = s.substring(i, i + k);
             if(tmp.compareTo(largest) >= 1) largest = tmp;
             if(tmp.compareTo(smallest) <= -1) smallest = tmp;
         }
         
         
         return smallest + "\n" + largest;
     }

     // Solution End
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}