import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */
public class DayoftheProgrammer {

  static String solve(int year) {

    int dayOfSum = 0;
    int month = 0;
    int day = 0;
    int[] months = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

    for (int i = 0; i < months.length; i++) {
      int daysOfMonth = dayOfMonth(year, months[i]);
      dayOfSum += daysOfMonth;
      if (dayOfSum > 256) {
        dayOfSum -= daysOfMonth;
        day = 256 - dayOfSum;
        month = months[i];
        break;
      }
    }

    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    Calendar cal = Calendar.getInstance();
    cal.set(year, month, day);
    return format.format(cal.getTime());
  }

  static int dayOfMonth(int year, int month) {
    if (year == 1918 && month == 1) {
      return 15;
    }
    if (month == 1) {
      if (year >= 1700 && year <= 1917 && year % 4 == 0) {
        return 29;
      } else if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
        return 29;
      }
    }
    Calendar cal = Calendar.getInstance();
    cal.set(year, month, 1);
    return cal.getActualMaximum(Calendar.DATE);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int year = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    String result = solve(year);
    System.out.println(result);
    scanner.close();
  }
}
