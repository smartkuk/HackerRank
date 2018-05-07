import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/gem-stones/problem
 */
public class Gemstones {

  static int gemstones(String[] arr) {
    Map<Character, Integer> pocket = new HashMap<Character, Integer>();
    for (String gemstone : arr) {
      find(pocket, gemstone);
    }
    int howmany = 0;
    for (Integer cnt : pocket.values()) {
      if (cnt == arr.length) {
        howmany++;
      }
    }
    return howmany;
  }

  static void find(Map<Character, Integer> pocket, String gem) {
    if (pocket.isEmpty()) {
      for (Character ch : gem.toCharArray()) {
        pocket.put(ch, 1);
      }
    } else {
      beUnique(gem).forEach((ch) -> {
        if (pocket.containsKey(ch)) {
          pocket.put(ch, pocket.get(ch) + 1);
        }
      });
    }
  }

  static List<Character> beUnique(String gem) {
    Set<Character> pocket = new HashSet<Character>();
    for (char ch : gem.toCharArray()) {
      pocket.add(ch);
    }
    return pocket.stream().map((ch) -> {
      return ch;
    }).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] arr = new String[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.next();
    }
    int result = gemstones(arr);
    System.out.println(result);
  }
}
