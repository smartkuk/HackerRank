import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-hurdle-race/problem
 */
public class TheHurdleRace {

  // Complete the hurdleRace function below.
  static int hurdleRace(int k, int[] height) {

    List<Integer> greaters = new ArrayList<Integer>();
    for (int i = 0; i < height.length; i++) {
      if (height[i] > k) {
        greaters.add(height[i]);
      }
    }

    if (greaters.isEmpty() || greaters.size() < 1) {
      return 0;
    }

    int max = greaters.stream().max((lvalue, rvalue) -> {
      return Integer.compare(lvalue, rvalue);
    }).orElse(0);

    if (max <= 0) {
      return 0;
    }

    return max - k;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    String[] nk = scanner.nextLine().split(" ");
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);
    int[] height = new int[n];
    String[] heightItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int i = 0; i < n; i++) {
      int heightItem = Integer.parseInt(heightItems[i]);
      height[i] = heightItem;
    }
    int result = hurdleRace(k, height);
    System.out.println(result);
    scanner.close();
  }
}
