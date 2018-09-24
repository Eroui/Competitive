import java.util.*;

public class test {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            deque.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if(deque.size() == m) {
                ans = Math.max(ans, map.keySet().size());
                
                int first = deque.getFirst();
                deque.removeFirst();
                
                map.put(first, map.get(first) - 1);
                if(map.get(first) == 0) {
                    map.remove(first);
                }
            }
           
        }
        
        System.out.println(ans);
    }
} 