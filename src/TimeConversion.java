import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 *
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
 * 제공되는 12시간대 AM/PM 포맷 시간에 대해 24시간대의 시간으로 변환해라
 *
 * Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock.
 * 자정은 12시간대에서는 12:00:00AM 이다. 그리고 24시간대에서는 00:00:00 이다.
 *
 * Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
 * 정오는 12시간대에서 12:00:00PM 이다. 그리고 24시간대에서는 12:00:00 이다.
 *
 * Input Format
 * A single string containing a time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM),
 * where 01 <= hh <= 12 and 00 <= mm, ss <= 59.
 * 1개의 문자열은 12시간대 포맷(예: hh:mm:ssAM 또는 hh:mm:ssPM)에서 시간을 포함하고 시간은 01 이상 12 이하,
 * 분과 초는 00 이상 59 이하이다.
 *
 * Output Format
 * Convert and print the given time in 24-hour format, where 00 <= hh <= 23.
 * 제공된 24시간대 포맷의 시간을 변환하고 출력해라
 *
 * Sample Input
 * 07:05:45PM
 *
 * Sample Output
 * 19:05:45
 *
 * @author pipe0502
 *
 */
public class TimeConversion {

  static String timeConversion(String s) {
    String[] tokenized = tokenize(removeWord(s));
    tokenized[0] = convert24Hour(isNoon(s), tokenized[0]);
    return merge(tokenized);
  }

  /**
   * 배열을 받아서 시간 문자열로 변환
   *
   * @param times 길이 3 문자열 배열
   * @return hh24:mm:ss 형태의 문자열
   */
  static String merge(String[] times) {
    if (times == null || times.length != 3) {
      return "";
    }
    return times[0] + ":" + times[1] + ":" + times[2];
  }

  /**
   * 정오 구분과 시간을 통해서 24시간대 문자열로 변환
   *
   * @param isNoon 정오를 나타내는 값 true 이면 정오이다.
   * @param h 시간 문자열
   * @return 24시간대 보정이 처리된 문자열
   */
  static String convert24Hour(boolean isNoon, String h) {
    int hour = Integer.parseInt(h) % 12 + (isNoon ? 12 : 0);
    String temp = String.valueOf(hour);
    return temp.length() == 1 ? "0" + temp : temp;
  }

  /**
   * 시간대 문자열을 받아서 각각의 시,분,초 문자열을 : 단위로 분할하여 배열로 리턴
   *
   * @param input 시간대 문자열
   * @return 시,분,초 순서의 배열 문자열
   */
  static String[] tokenize(String input) {
    return input.split(":");
  }

  /**
   * 시간대 문자열에서 AM 또는 PM 문자열을 제거하고 리
   *
   * @param input 시간대 문자열
   * @return AM PM 형태의 문자열이 제거된 문자열
   */
  static String removeWord(String input) {
    return input.replaceAll("[AM|PM]", "");
  }

  /**
   * 시간대 문자열에서 AM/PM 문자열을 기준으로 정오인지 판단
   *
   * @param input 시간형태의 문자열
   * @return PM 문자열이 있는 true
   */
  static boolean isNoon(String input) {
    return input.contains("PM");
  }

  private static final Scanner scan = new Scanner(System.in);

  /**
   * 01:45:00AM
   * 12:45:54AM
   * 01:45:00PM
   * 12:45:54PM
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    String s = scan.nextLine();
    String result = timeConversion(s);
    System.out.println("결과:" + result);
  }
}
