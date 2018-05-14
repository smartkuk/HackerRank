import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 */
public class MigratoryBirds {

  // Complete the migratoryBirds function below.
  static int migratoryBirds(int n, int[] ar) {
    int[] counter = new int[] { 0, 0, 0, 0, 0 };
    for (int type : ar) {
      counter[type - 1]++;
    }
    return maxIndex(counter);
  }

  static int maxIndex(int[] counters) {
    int max = 0;
    int maxType = -1;
    for (int i = 0; i < counters.length; i++) {
      if (max < counters[i]) {
        max = counters[i];
        maxType = i;
      }
    }
    return maxType + 1;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int arCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[arCount];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int arItr = 0; arItr < arCount; arItr++) {
      int arItem = Integer.parseInt(arItems[arItr]);
      ar[arItr] = arItem;
    }

    int result = migratoryBirds(arCount, ar);

    scanner.close();

    System.out.println(result);
  }
}
