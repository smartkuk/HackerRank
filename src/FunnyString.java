import java.util.Scanner;

public class FunnyString {

  static String funnyString(String s) {

    char[] src = s.toCharArray();
    char[] reversed = reverse(src);

    boolean isFunny = true;
    for (int i = 0; i < src.length - 1; i++) {
      if (!test(i, src, reversed)) {
        isFunny = false;
        break;
      }
    }
    return isFunny ? "Funny" : "Not Funny";
  }

  /**
   * 특정 위치를 기준으로 문자 2개를 각각의 배열에서 비교
   * 
   * @param idx
   * @param src
   * @param reversed
   * @return
   */
  static boolean test(int idx, char[] src, char[] reversed) {
    int first = idx + 1;
    return Math.abs(src[first] - src[idx]) == Math.abs(reversed[first] - reversed[idx]);
  }

  /**
   * 문자 배열을 역으로 변경
   *
   * @param src 문자 배열
   * @return 거꾸로 정렬된 문자 배열
   */
  static char[] reverse(char[] src) {
    char[] reversed = new char[src.length];
    for (int i = src.length - 1, j = 0; i > -1; i--, j++) {
      reversed[j] = src[i];
    }
    return reversed;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      String result = funnyString(s);
      System.out.println(result);
    }
  }

}
