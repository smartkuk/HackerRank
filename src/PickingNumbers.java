import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 */
public class PickingNumbers {

  // Complete the pickingNumbers function below.
  static int pickingNumbers(int[] a) {

    List<List<Integer>> results = new ArrayList<List<Integer>>();

    for (int cursor = 0; cursor < a.length; cursor++) {
      List<List<Integer>> newLlist = new ArrayList<List<Integer>>();
      int fixedValue = a[cursor];
      for (int i = 0; i < a.length; i++) {
        if (cursor != i) {

          int distance = Math.abs(fixedValue - a[i]);
          if (distance <= 1) {

            for (List<Integer> caseList : newLlist) {
              if (containElement(caseList, a[i])) {
                caseList.add(a[i]);
              }
            }

            List<Integer> toBeAdd = new ArrayList<Integer>();
            toBeAdd.add(fixedValue);
            toBeAdd.add(a[i]);
            newLlist.add(toBeAdd);
          }
        }
      }

      newLlist.forEach((values) -> {
        results.add(values);
      });
    }

    return results.stream().max((lvalues, rvalues) -> {
      return Integer.compare(lvalues.size(), rvalues.size());
    }).orElse(new ArrayList<Integer>()).size();
  }

  static boolean containElement(List<Integer> elements, int value) {
    boolean right = true;
    for (int element : elements) {
      if (Math.abs(element - value) > 1) {
        right = false;
        break;
      }
    }
    return right;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    int[] a = new int[n];
    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }
    int result = pickingNumbers(a);
    System.out.println(result);
    scanner.close();
  }
}
