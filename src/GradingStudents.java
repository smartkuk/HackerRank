import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradingStudents {

  /*
   * Complete the gradingStudents function below.
   */
  static int[] gradingStudents(int[] grades) {

    List<Integer> numbers = new ArrayList<Integer>();
    for (int number : grades) {
      if (isFail(number)) {
        continue;
      }
      if (closed(number)) {
        numbers.add(roundMultiple(number));
      } else {
        numbers.add(number);
      }
    }

    int[] results = new int[numbers.size()];
    for (int i = 0; i < numbers.size(); i++) {
      results[i] = numbers.get(i);
    }

    return results;
  }

  /**
   * 낙제 여부 리턴
   *
   * @param number 정수
   * @return 38 미만이면 낙제
   */
  static boolean isFail(int number) {
    return number < 38;
  }

  /**
   * 정수를 받아서 5로 나눈 뒤에 나머지가 3이상이면 true
   *
   * @param number 정수
   * @return 다음 5의 배수에 근접한지 검사하여 근접하면 true
   */
  static boolean closed(int number) {
    return number % 5 >= 3;
  }

  /**
   * 입력 받은 정수를 기준으로 다음 5의 배수를 구하여 리턴
   *
   * @param number 정수
   * @return 다음 5의 배수
   */
  static int roundMultiple(int number) {
    return number / 5 * 5 + 5;
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(scan.nextLine().trim());

    int[] grades = new int[n];

    for (int gradesItr = 0; gradesItr < n; gradesItr++) {
      int gradesItem = Integer.parseInt(scan.nextLine().trim());
      grades[gradesItr] = gradesItem;
    }

    int[] result = gradingStudents(grades);

    for (int resultItr = 0; resultItr < result.length; resultItr++) {
      bw.write(String.valueOf(result[resultItr]));

      if (resultItr != result.length - 1) {
        bw.write("\n");
      }
    }
    bw.newLine();
    bw.close();
  }

}
