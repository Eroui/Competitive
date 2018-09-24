import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        
        sc.close();
          
        // Solution Start
        String[] arr = new String[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = s[i];
        }
  
        Arrays.sort(arr, (n1, n2) -> {
                int diff = (new BigDecimal(n2)).compareTo(new BigDecimal(n1));
                return diff;
            });
  
        for(int i = 0; i < n; ++i) {
            s[i] = arr[i];
        }
        // Solution End
        
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}