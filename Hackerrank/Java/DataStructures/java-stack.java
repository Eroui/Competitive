import java.util.*;

class Solution {
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            Stack<Character> stk = new Stack<>();
            char[] arr = input.toCharArray();
            
            boolean ans = true;
            for(char c : arr) {
                if(isOpening(c)) {
                    stk.push(c);
                } else {
                    if(stk.isEmpty()) {
                        ans = false;
                        break;
                    } else {
                        char cc = stk.pop();
                        if(cc != getOpening(c)) {
                            ans = false;
                            break;
                        }
                    }
                }
            }
            
            System.out.println(stk.isEmpty() && ans);
        }
        
        sc.close();
	}
    
    
    private static boolean isOpening(char c) {
        switch(c) {
            case '{': 
            case '(':
            case '[': return true;
            default: return false;
        }
    }
    
    
    private static char getOpening(char c) {
                switch(c) {
            case '}': return '{'; 
            case ')': return '(';
            case ']': return '[';
            default: return '#'; // should not reach this
        }
    }
}