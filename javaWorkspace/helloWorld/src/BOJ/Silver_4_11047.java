package BOJ;

import java.util.Scanner;

public class Silver_4_11047 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int coinVariant = Integer.parseInt(input.next());
    int target = Integer.parseInt(input.next());

    int[] coins = new int[coinVariant];
    int result = 0;

    for(int i = 0 ; i < coinVariant ; i++) {
      coins[i] = Integer.parseInt(input.next());
    }

    for(int i = coinVariant - 1 ; i >= 0 ; i--) {
      if((double) target / coins[i] > 0) {
        int num = (int) Math.floor((double) target/coins[i]);
        result += (int) Math.floor((double) target/coins[i]);
        target -= num * coins[i];
      }

      if(target == 0) {
        break;
      }
    }

    System.out.println(result);

    input.close();
  }
}
