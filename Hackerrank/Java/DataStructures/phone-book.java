import java.util.*;
import java.io.*;

class Solution{
    
    private static final Scanner in = new Scanner(System.in);
	public static void main(String []argh) {
        int n = Integer.parseInt(in.nextLine());
        HashMap<String, String> phoneNumbers = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            String name = in.nextLine();
            String phoneNumber = in.nextLine();
            
            phoneNumbers.put(name, phoneNumber);
        }
        
        while(in.hasNext()) {
            String name = in.nextLine();
            String phoneNumber = null;
            if((phoneNumber = phoneNumbers.get(name)) != null) {
                System.out.printf("%s=%s\n", name, phoneNumber);
            } else {
                System.out.println("Not found");
            }
        }
        
	}
}