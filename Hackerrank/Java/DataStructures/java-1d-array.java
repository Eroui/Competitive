import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        int n = game.length;
        boolean[] vis = new boolean[game.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        while(!stk.isEmpty()) {
            int i = stk.pop();
            if(i >= n-1) return true;
            if(vis[i])
                continue;
            vis[i] = true;
            
            if(i + leap >= n) return true;
            if(i + 1 < n && game[i + 1] == 0)
                stk.push(i + 1);
            if(game[i + leap] == 0)
                stk.push(i + leap);
            if(i - 1 >= 0 && game[i - 1] == 0) {
                stk.push(i - 1);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}