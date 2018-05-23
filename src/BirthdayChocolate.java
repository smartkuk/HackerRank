import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class BirthdayChocolate {

  // Complete the solve function below.
  static int solve(int n, int[] s, int d, int m) {

    int from = 0;
    int to = from + m;
    int way = 0;

    do {
      if (rangeSum(s, from, to) == d) {
        way++;
      }
      from++;
      to = from + m;
    } while (s.length >= to);
    return way;
  }

  static int rangeSum(int[] s, int from, int to) {
    int sum = 0;
    for (int i = from; i < to; i++) {
      sum += s[i];
    }
    return sum;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] s = new int[n];

    String[] sItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int sItem = Integer.parseInt(sItems[i]);
      s[i] = sItem;
    }

    String[] dm = scanner.nextLine().split(" ");

    int d = Integer.parseInt(dm[0]);

    int m = Integer.parseInt(dm[1]);

    int result = solve(n, s, d, m);

    System.out.println(result);

    scanner.close();
  }
}
