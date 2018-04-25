import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 *
 * Julius Caesar protected his confidential information by encrypting it using a cipher.
 * 줄리어스 시저는 그의 기밀 정보를 암호문을 사용한 암호화를 통해 보호했습니다.
 *
 * Caesar's cipher shifts each letter by a number of letters.
 * 시저의 암호문은 각각의 문자가 문자들의 수에 의해 바뀐다.
 *
 * If the shift takes you past the end of the alphabet, just rotate back to the front of the
 * alphabet.
 * 만약에 그 전환 처리가 알파벳의 끝까지 지나버리면, 알파벳의 시작으로 돌아온다.
 *
 * In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
 * 3회의 전환을 처리시 w, x, y, z는 z, a, b, c와 연결된다.
 *
 * Original alphabet: abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +3: defghijklmnopqrstuvwxyzabc
 *
 * Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
 * 암호문은 문자만 암호화 한다. -와 같은 기호들은 비암호화한다.
 *
 * Input Format
 * The first line contains the integer, n, the length of the unencrypted string.
 * 첫번째 라인은 정수형인 n, 암호화 되지 않은 문자열의 길이이다.
 *
 * The second line contains the unencrypted string, s.
 * 두번째 라인은 암호화 되지 않은 문자열 s 이다.
 *
 * The third line contains k, the number of letters to rotate the alphabet by.
 * 세번째 라인은 k이고 알파벳에 희새 전환하는 횟수이다.
 *
 * Constraints
 * 1 <= n <= 100
 * 0 <= k <= 100
 * s is a valid ASCII string without any spaces.
 * s는 공백이 없는 아스키 문자열이다.
 *
 * Output Format
 * For each test case, print the encoded string.
 * 각각의 케이스를 위해서 암호화된 문자열을 출력해라.
 *
 */
public class CaesarCipher {

  static final char[] lowers =
      "abcdefghijklmnopqrstuvwxyz".toCharArray();// 26

  static final char[] uppers =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

  static String caesarCipher(String s, int k) {

    if (0 > k || k > 100) {
      System.exit(3);
      return "";
    }

    char[] beConverted = s.toCharArray();
    char[] result = new char[beConverted.length];

    for (int i = 0; i < beConverted.length; i++) {
      result[i] = encrypt(beConverted[i], k);
    }

    return new String(result);
  }

  /**
   * 문자와 로테이션 숫자를 사용하여 암호화를 하여 문자를 리턴
   *
   * @param c 암호화 하려는 문자
   * @param rotation 로테이션 처리를 할 횟수
   * @return 로테이션 처리가 완료된 문자(암호화 할 수 없는 문자면 그대로 리턴)
   */
  static char encrypt(char c, int rotation) {

    if (!encryptable(c)) {
      return c;
    }

    int position = idx(c) + rotation + 1;// 인덱스기 때문에 1 보정

    char[] store = Character.isLowerCase(c) ? lowers : uppers;

    if (position <= 26) {
      return store[position - 1];
    } else {
      return store[(position % 26 == 0 ? 26 : position % 26) - 1];
    }
  }

  /**
   * 문자가 알파벳(대문자, 소문자) 배열에서 어느 인덱스 위치에 있는지 확인하여 리턴
   *
   * @param c 확인할 문자
   * @return lowers, uppers 배열에서 인덱스 숫자(만약 찾이 못하거나 알파벳이 아니면 -1)
   */
  static int idx(char c) {
    char[] temps = Character.isLowerCase(c) ? lowers : uppers;
    for (int i = 0; i < temps.length; i++) {
      if (temps[i] == c) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 문자를 암호화 할 수 있는지 검사
   *
   * @param c 문자
   * @return true 이면 대문자 또는 소문자이기 때문에 처리 가능
   */
  static boolean encryptable(char c) {
    return Character.isLowerCase(c) || Character.isUpperCase(c);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String s = in.next();
    if (n != s.length()) {
      System.exit(3);
    }
    int k = in.nextInt();
    String result = caesarCipher(s, k);
    System.out.println(result);
    in.close();
  }

}
