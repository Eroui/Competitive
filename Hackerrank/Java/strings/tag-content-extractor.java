import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int ttt = Integer.parseInt(in.nextLine());
        Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
        
		while(ttt-->0){
			String line = in.nextLine();
			Matcher m = r.matcher(line);
            
            boolean hasFoundMatch = false;
            while(m.find()) {
                System.out.println(m.group(2));
                hasFoundMatch = true;
            }
          	
			if(!hasFoundMatch)
                System.out.println("None");
		}
	}
}