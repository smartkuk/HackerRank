import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters/problem
 *
 * You are given a string containing characters A and B only.
 * Your task is to change it into a string such that every two consecutive characters are
 * different. To do this, you are allowed to delete one or more characters in the string.
 * Your task is to find the minimum number of required deletions.
 *
 * Input Format
 * The first line contains an integer t, the number of test cases.
 * The next t lines contain a string s.
 *
 * Constraints
 * 1 <= t <= 10
 * 1 <= |s| <= 10E5
 * Each string s will consist only of characters A and B
 *
 * Output Format
 * For each test case, print the minimum number of deletions required in a new line.
 *
 * Sample Input
 * 5
 * AAAA
 * BBBBB
 * ABABABAB
 * BABABA
 * AAABBB
 *
 * Sample Output
 * 3
 * 4
 * 0
 * 0
 * 4
 */
public class AlternatingCharacters {

  static int alternatingCharacters(String s) {
    return testDeletion(s.toCharArray());
  }

  static int testDeletion(char[] chars) {
    int cursor = 0;
    int deletion = 0;
    while (cursor <= chars.length - 1) {
      if (search(cursor++, chars)) {
        deletion++;
      }
    }
    return deletion;
  }

  /**
   * 기준 인덱스와 다음 인덱스 문자가 동일한지 결과를 리턴
   *
   * @param cur 기준이 되는 인덱스 첨자
   * @param chars 문자 배열
   * @return 동일하면 true
   */
  static boolean search(int cur, char[] chars) {
    if (cur == chars.length - 1) {
      return false;
    }
    return chars[cur] == chars[cur + 1];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    if (q < 1 || q > 10) {
      System.exit(3);
    }
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      int result = alternatingCharacters(s);
      System.out.println(result);
    }
  }
}
