import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 *
 * Sami's spaceship crashed on Mars! She sends n sequential SOS messages to Earth for help.
 * 새미의 우주선이 화성에 불시착 했다. 그녀는 지구에 도움을 요청하기 위해서 n개의 순차적인 SOS 메세지를 보낸다.
 *
 * Letters in some of the SOS messages are altered by cosmic radiation during transmission.
 * SOS 메세지들의 일부 문자들은 전송 중에 우주 방사선에 의해 변형된다.
 *
 * Given the signal received by Earth as a string, S,
 * 지구에서 문자열로 받는 전송 신호 S는
 *
 * determine how many letters of Sami's SOS have been changed by radiation.
 * 새미의 SOS 중에 몇 개의 문자들이 방사능에 의해 변형되는지 결정해라
 *
 * Input Format
 * There is one line of input: a single string, S.
 * 한줄의 입력이 있다: 1개의 문자열 S
 *
 * Note: As the original message is just SOS repeated n times, S's length will be a multiple of 3.
 * 원본 메세지는 단지 n번 반복된 SOS이다. S의 길이는 3의 배수가 될 것이다.
 *
 * Constraints
 * 1 <= |S| <= 99
 * |S| % 3 == 0
 * S will contain only uppercase English letters.
 * S 문자열은 대문자 영문 글자만을 포함한다.
 *
 * Output Format
 * Print the number of letters in Sami's message that were altered by cosmic radiation.
 * 새미의 메시지에서 우주 방사능에 변형된 문자의 숫자를 출력해라
 *
 * Sample Input 0
 * SOSSPSSQSSOR
 *
 * Sample Output 0
 * 3
 */
public class MarsExploration {

  /**
   * for compare
   */
  private static char[] sos = "SOS".toCharArray();

  static int marsExploration(String s) {
    if (s == null || s.isEmpty() || (1 > s.length() || s.length() > 99) || (s.length() % 3 != 0)) {
      return -1;
    }
    return checkByRanges(s.toCharArray());
  }

  /**
   * 문자 배열을 받아서 구간별로 검사를 보내서 변형된 개수를 리턴
   *
   * @param chars 검사할 문자 배열
   * @return 변형된 문자의 개수
   */
  static int checkByRanges(char[] chars) {
    int sum = 0;
    for (int i = 0; i <= chars.length - 1; i += 3) {
      sum += alteredLetters(new char[] { chars[i], chars[i + 1], chars[i + 2] });
    }
    return sum;
  }

  /**
   * 변형된 신호인지 검사
   *
   * @param msg 문자 배열
   * @return SOS 문자열 기반 문자 배열과 비교하여 변형된 문자 개수 리턴
   */
  static int alteredLetters(char[] msg) {
    int letters = 0;
    for (int i = 0; i < msg.length; i++) {
      letters += (sos[i] != msg[i]) ? 1 : 0;
    }
    return letters;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int result = marsExploration(s);
    System.out.println(result);
    in.close();
  }
}
