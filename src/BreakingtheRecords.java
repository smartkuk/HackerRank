import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */
public class BreakingtheRecords {

  static int[] breakingRecords(int[] score) {

    int min = score[0];
    int max = score[0];
    int minCnt = 0;
    int maxCnt = 0;

    for (int point : score) {
      if (point > max) {
        max = point;
        maxCnt++;
      }
      if (point < min) {
        min = point;
        minCnt++;
      }
    }
    return new int[] { maxCnt, minCnt };
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(scan.nextLine().trim());
    int[] score = new int[n];
    String[] scoreItems = scan.nextLine().split(" ");
    for (int scoreItr = 0; scoreItr < n; scoreItr++) {
      int scoreItem = Integer.parseInt(scoreItems[scoreItr].trim());
      score[scoreItr] = scoreItem;
    }

    int[] result = breakingRecords(score);

    for (int resultItr = 0; resultItr < result.length; resultItr++) {
      System.out.print(String.valueOf(result[resultItr]));

      if (resultItr != result.length - 1) {
        System.out.print(" ");
      }
    }
  }
}
