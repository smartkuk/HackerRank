import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 */
public class CountingValleys {

  // Complete the countingValleys function below.
  static int countingValleys(int n, String s) {

    int valleyCount = 0;
    int summary = 0;

    char[] steps = s.toCharArray();

    for (int i = 0; i < steps.length; i++) {
      summary += (steps[i] == 'U' ? 1 : -1);
      if (steps[i] == 'U' && summary == 0) {
        valleyCount++;
      }
    }

    return valleyCount;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String s = scanner.nextLine();

    int result = countingValleys(n, s);
    System.out.println(result);

    scanner.close();
  }
}
