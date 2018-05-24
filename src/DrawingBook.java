import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/drawing-book/problem
 */
public class DrawingBook {

  static int pageCount(int n, int p) {

    int maxTurn = (n / 2);
    int leftDirection = 0;
    int rightDirection = 0;

    for (int i = 0; i <= maxTurn; i++, rightDirection++) {
      if (i * 2 == p || i * 2 + 1 == p) {
        break;
      }
    }

    for (int i = maxTurn; i >= 0; i--, leftDirection++) {
      if (i * 2 == p || i * 2 + 1 == p) {
        break;
      }
    }
    return Math.min(rightDirection, leftDirection);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
    int p = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
    int result = pageCount(n, p);
    System.out.println(result);
    scanner.close();
  }
}
