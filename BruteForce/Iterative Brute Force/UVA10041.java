import java.util.*;

public class UVA10041 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < n; ++i) {
                arr[i] = in.nextInt();
            } Arrays.sort(arr);

            int house = arr[n >> 1];
            int ans = 0;
            for(int i = 0; i < n; ++i) {
                ans += Math.abs(arr[i] - house);
            } 

            System.out.println(ans);
        }
    }
}