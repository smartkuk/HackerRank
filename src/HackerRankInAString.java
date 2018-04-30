import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 *
 * We say that a string contains the word hackerrank if a subsequence of its characters spell
 * 만약에 문자들의 철자가 hackerrank 단어의 일부이면 문자열이 hackerrank 단어를 포함한다고 말한다.
 *
 * the word hackerrank. For example, if string s == haacckkerrannkk it does contain hackerrank,
 * 예를 들어 문자열 s가 haacckkerrannkkdhk 이면 그것은 hackerrank를 포함한다.
 *
 * but s == haacckkerannk does not. In the second case, the second r is missing.
 * 하지만 s 가 haacckkerannk 이면 그렇지 않다. 두번째 경우 r 글자가 빠져있다.
 *
 * If we reorder the first string as hccaakkerrannkk, it no longer contains the subsequence
 * 만약에 우리가 다시 정렬하여 첫번째 문자열이 hccaakkerrannkk로 되면 그건 더 이상 포함하지 않는다.
 *
 * due to ordering. More formally, let p[0], p[1], ... p[9] be the respective indices of
 * 더 공식적으로 p[0], p[1], ... p[9] 는 문자열 s에서 h, a, c, k, e, r, r, a, n, k 이다.
 *
 * h, a, c, k, e, r, r, a, n, k in string s. If p[0] < p[1] < p[2] ... < p[9] is true,
 * 만약에 p[0] < p[1] < p[2] ... < p[9] 조건은 참이고 그때 hackerrank를 포함한다.
 *
 * then contains hackerrank. For each query, print YES on a new line if the string contains
 * 각각의 쿼리에서 그 문자열이 hackerrank를 포함하면 개행된 YES 를 출력해라 아니면 NO를 출력해라
 *
 * hackerrank, otherwise, print NO.
 *
 *
 * Input Format
 *
 * The first line contains an integer q, the number of queries.
 *
 * Each of the next q lines contains a single query string s.
 *
 * Constraints
 * 2 <= q <= 10E2
 * 10 <= |s| <= 10E4
 *
 *
 * Output Format
 *
 * For each query, print YES on a new line if contains hackerrank, otherwise, print NO.
 *
 * Sample Input 0
 * 2
 * hereiamstackerrank
 * hackerworld
 * Sample Output 0
 *
 * YES
 * NO
 *
 */
public class HackerRankInAString {

  /**
   * 검사의 기준이 되는 문자 배열
   */
  static final char[] baseString = "hackerrank".toCharArray();

  static String hackerrankInString(String s) {
    return test(s.toCharArray()) ? "YES" : "NO";
  }

  static boolean test(char[] targets) {

    int pos = 0;
    int matched = 0;

    for (int i = 0; i < baseString.length; i++) {

      boolean match = false;

      for (int j = pos; j < targets.length; j++) {
        if (baseString[i] == targets[j]) {
          match = true;
          pos = j + 1;
          matched++;
          break;
        }
      }

      // 1개 기준 문자를 입력 받은 문자 배열에서 찾지 못하면 중지
      if (!match) {
        break;
      }
    }

    return matched == baseString.length;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      String result = hackerrankInString(s);
      System.out.println(result);
    }
    in.close();
  }
}
