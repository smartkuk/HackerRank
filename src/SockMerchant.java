import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SockMerchant {

  // Complete the sockMerchant function below.
  static int sockMerchant(int n, int[] ar) {
    Map<String, Integer> saleMap = new HashMap<String, Integer>();
    for (Integer sock : ar) {
      if (saleMap.containsKey(sock.toString())) {
        saleMap.put(sock.toString(), saleMap.get(sock.toString()) + 1);
      } else {
        saleMap.put(sock.toString(), 1);
      }
    }
    int saleCount = 0;
    Iterator<Integer> temps = saleMap.values().iterator();
    while (temps.hasNext()) {
      saleCount += temps.next() / 2;
    }
    return saleCount;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[n];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arItem = Integer.parseInt(arItems[i]);
      ar[i] = arItem;
    }

    int result = sockMerchant(n, ar);
    System.out.println(result);

    scanner.close();
  }
}
