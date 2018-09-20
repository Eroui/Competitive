import java.util.Calendar;
// Solution Start
import java.util.Calendar;
import java.util.Date;

public class Main {
    
    private static String[] days = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
    
    private static String getDay(String day, String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    // Solution End

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        System.out.println(getDay(day, month, year));
    }
}