import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string/problem
 */
public class BeautifulBinaryString {

  static int beautifulBinaryString(String b) {
    int idx = 0;
    int count = 0;
    while ((idx = b.indexOf("010", idx)) != -1) {
      count++;
      idx += 3;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String b = in.next();
    int result = beautifulBinaryString(b);
    System.out.println(result);
    in.close();
  }
}
