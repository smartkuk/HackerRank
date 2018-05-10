import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
 */
public class TheLoveLetterMystery {

  static int theLoveLetterMystery(String s) {

    // split String(if count of s string is odd, except center character)
    String left = s.substring(0, s.length() / 2);
    String right = s.substring(s.length() / 2 + (s.length() % 2));

    return process(left.toCharArray(), right.toCharArray());

  }

  static int process(char[] left, char[] right) {

    int processingCount = 0;

    int lidx = 0;// start index of left
    int ridx = right.length - 1;// start index of right

    while ((lidx < left.length || ridx >= 0) && !equalsArray(left, right)) {

      if (left[lidx] != right[ridx]) {

        int changeCount = counting(left[lidx], right[ridx], left[lidx] < right[ridx]);
        processingCount += changeCount;

        if (left[lidx] < right[ridx]) {
          right[ridx] = (char) (right[ridx] - changeCount);
        } else {
          left[lidx] = (char) (left[lidx] - changeCount);
        }
      }

      lidx++;
      ridx--;

    }

    return processingCount;
  }

  /**
   * Two character distance
   */
  static int counting(char left, char right, boolean leftStandard) {
    return Math.abs(left - right);
  }

  /**
   * check equal two char array(palindromes)
   */
  static boolean equalsArray(char[] left, char[] right) {

    if (left.length != right.length) {
      return false;
    }

    for (int i = 0; i < left.length; i++) {
      if (left[i] != right[right.length - 1 - i]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      int result = theLoveLetterMystery(s);
      System.out.println(result);
    }
  }
}
