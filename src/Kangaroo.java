import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem
 *
 * You are choreograhing a circus show with various animals. For one act, you are given two
 * kangaroos on a number line ready to jump in the positive direction (i.e, toward positive
 * infinity).
 *
 * The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
 * The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
 * You have to figure out a way to get both kangaroos at the same location as part of the show.
 *
 * Complete the function kangaroo which takes starting location and speed of both kangaroos as
 * input, and return YES or NO appropriately. Can you determine if the kangaroos will ever land at
 * the same location at the same time? The two kangaroos must land at the same location after making
 * the same number of jumps.
 *
 */
public class Kangaroo {

  static String kangaroo(int x1, int v1, int x2, int v2) {

    if (!validatedLocation(x1, v1, x2, v2)) {
      return "NO";
    }

    if (x1 > x2 && (x1 - x2) % (v2 - v1) == 0) {
      return "YES";
    }

    if (x1 < x2 && (x2 - x1) % (v1 - v2) == 0) {
      return "YES";
    }

    return "NO";
  }

  /**
   * 위치와 속도를 기준으로 영원히 따라 잡을수 없으면 false 리턴
   */
  static boolean validatedLocation(int x1, int v1, int x2, int v2) {
    if (x1 > x2 && v1 >= v2) {
      return false;
    }
    if (x1 < x2 && v1 <= v2) {
      return false;
    }
    if (x1 == x2 && v1 != v2) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x1 = in.nextInt();
    int v1 = in.nextInt();
    int x2 = in.nextInt();
    int v2 = in.nextInt();
    String result = kangaroo(x1, v1, x2, v2);
    System.out.println(result);
  }
}
