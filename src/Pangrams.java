import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Roy wanted to increase his typing speed for programming contests.
 * His friend suggested that he type the sentence "The quick brown fox jumps over
 * the lazy dog" repeatedly. This sentence is known as a pangram because it contains every
 * letter of the alphabet.
 * After typing the sentence several times, Roy became bored with it so he started to
 * look for other pangrams.
 * Given a sentence, determine whether it is a pangram.
 */
public class Pangrams {

  private static char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();

  /*
   * Complete the pangrams function below.
   */
  static String pangrams(String s) {
    List<String> alphabets = new ArrayList<String>();
    for (char ch : alphabetArray) {
      alphabets.add(String.valueOf(ch));
    }
    long checked = alphabets.stream().filter((spell) -> {
      return s.contains(spell.toLowerCase()) || s.contains(spell.toUpperCase());
    }).count();
    return alphabetArray.length == checked ? "pangram" : "not pangram";
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    String s = scanner.nextLine();
    String result = pangrams(s);
    System.out.println(result);
  }
}
