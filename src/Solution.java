import java.util.Scanner;

/**
 * Steve has a string, s, consisting of n lowercase English alphabetic letters.
 * 스티브는 n개의 소문자릂 포함하는 문자열 s를 가지고 있다.
 *
 * In one operation, he can delete any pair of adjacent letters with same value.
 * 한번의 처리를 통해서 그는 근처에 동일한 문자 쌍을 삭제할 수 있다.
 *
 * For example, string "aabcc" would become either "aab" or "bcc" after operation.
 * 예를들어 문자열 "aabcc"는 처리를 통해 "aab"나 "bcc"가 된다.
 *
 * Steve wants to reduce as much as possible. To do this, he will repeat the above operation
 * 스티브는 이렇게 하여서 가능한 (문자열을) 줄이길 원한다. 그는 그 처리가 가능할 수 있을때까지 몇번의 처리를 통해 반복할 것이다.
 *
 * as many times as it can be performed. Help Steve out by finding and printing 's non-reducible
 * form!
 * 스티브를 더이상 줄일수 없는 형태까지 찾아 출력하고 도와줘라
 *
 * Note: If the final string is empty, print Empty String .
 * 최종적인 문자열이 비어있으면 빈 문자열을 출력해라
 *
 */
public class Solution {

  /**
   * 필요한 함수
   * 문자열, 인덱스를 받아서 인덱스 + 1 이 검색 가능한 인덱스 인지 판단
   * 인접문자열 1개가 동일한지 판단
   * 인덱스에 해당하는 문자열을 제거
   *
   * @param s
   * @return
   */
  static String super_reduced_string(String s) {

    int index = 0;
    char[] mutablechars = s.toCharArray();

    while (validateNextIndex(mutablechars, index)) {
      if (same(mutablechars, index)) {
        mutablechars = removeDuplicate(mutablechars, index);
        index = 0;
        continue;
      }
      index++;
    }

    return mutablechars == null || mutablechars.length == 0 ? "Empty String"
        : new String(mutablechars);
  }

  /**
   * 문자열과 인덱스를 사용하여 인덱스를 제외한 문자열을 생성하여 리턴
   *
   * @param chars 처리할 문자 배열
   * @param current 삭제할 문자열 위치
   * @return 인덱스에 해당하는 문자열이 삭제된 문자열
   */
  static char[] removeDuplicate(char[] chars, int current) {

    char[] beNew = new char[chars.length - 2];

    int idx = 0;
    for (int i = 0; i < chars.length; i++) {
      if (i != current && i != current + 1) {
        beNew[idx++] = chars[i];
      }
    }
    return beNew;
  }

  /**
   * 문자 배열과 인덱스를 받아서 문자 2개를 비교하고 동일한지 결과를 리턴
   *
   * @param chars 검사할 문자 배열
   * @param current 검사할 문자 배열의 인덱스
   * @return 인덱스에 해당하는 문자와 인덱스+1에 해당하는 문자가 같으면 true
   */
  static boolean same(char[] chars, int current) {
    return chars[current] == chars[current + 1];
  }

  /**
   * 문자배열과 현재 인덱스를 사용하여 인접 검증 가능 길이 검사
   *
   * @param chars 문자 배열
   * @param current 검사할 위치 인덱스
   * @return 문자 배열이 없거나 길이가 올바르지 않거나, 인덱스 기준으로 비교할 인덱스가 없으면 false
   */
  static boolean validateNextIndex(char[] chars, int current) {
    return !(chars == null || chars.length < 1 || current < 0 || chars.length - 1 < current
        || current + 1 < 0 || chars.length - 1 < current + 1);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String result = super_reduced_string(s);
    System.out.println(result);
  }
}
