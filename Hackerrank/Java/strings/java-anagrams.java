import java.util.Scanner;

public class Solution {

    // Solution Start
    static boolean isAnagram(String a, String b) {
        
        char[] arr = a.toLowerCase().toCharArray();
        char[] brr = b.toLowerCase().toCharArray();
        
        Arrays.sort(arr); 
        Arrays.sort(brr);

        retrn (new String(arr)).equals(new String(brr));
    }
    // Solution End

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}