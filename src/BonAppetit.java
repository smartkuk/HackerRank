import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */
public class BonAppetit {

  public static String calculate(int noEatIndex, int[] bills, int chared) {
    int sum = 0;
    for (int i = 0; i < bills.length; i++) {
      if (i != noEatIndex) {
        sum += bills[i];
      }
    }
    int annasChared = chared - (sum / 2);
    return annasChared == 0 ? "Bon Appetit" : String.valueOf(annasChared);
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String args[]) throws Exception {

    String[] nk = scan.nextLine().split(" ");
    int n = Integer.parseInt(nk[0].trim());
    int k = Integer.parseInt(nk[1].trim());

    int[] prices = new int[n];
    String[] aPrices = scan.nextLine().split(" ");
    for (int i = 0; i < prices.length; i++) {
      prices[i] = Integer.parseInt(aPrices[i]);
    }

    String aChared = scan.nextLine();
    int chared = Integer.parseInt(aChared);

    String result = calculate(k, prices, chared);
    System.out.println(result);

  }
}
