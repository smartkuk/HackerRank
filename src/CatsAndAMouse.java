import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 */
public class CatsAndAMouse {

  // Complete the catAndMouse function below.
  static String catAndMouse(int x, int y, int z) {

    int distanceFromA = Math.abs(z - x);
    int distanceFromB = Math.abs(z - y);

    if (distanceFromA == distanceFromB) {
      return "Mouse C";
    } else if (distanceFromA < distanceFromB) {
      return "Cat A";
    } else {
      return "Cat B";
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String[] xyz = scanner.nextLine().split(" ");

      int x = Integer.parseInt(xyz[0]);

      int y = Integer.parseInt(xyz[1]);

      int z = Integer.parseInt(xyz[2]);

      String result = catAndMouse(x, y, z);
      System.out.println(result);
    }

    scanner.close();
  }
}
