package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_1_12852 {
  public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  public static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {


    String temp = input.readLine();

    int target = Integer.parseInt(temp);

    int[] numStorage = new int[target + 1];
    String[] stringStorage = new String[target + 1];

    output.write(dp(numStorage, stringStorage, target) + "\n");
    output.write(stringStorage[target]);
    output.flush();

    output.close();
    input.close();
  }

  public static int dp(int[] numStorage, String[] stringStorage, int target) throws IOException {
    if(numStorage[target] != 0) {
      return numStorage[target];
    }

    if(target == 1) {
      numStorage[1] = 0;
      // output.write("1 ");
      stringStorage[1] = "1";
      return 0;
    }
    else if(target == 2) {
      numStorage[2] = 1;
      // output.write("2 1 ");
      stringStorage[2] = "2 1";
      return 1;
    }
    else if(target == 3) {
      numStorage[3] = 1;
      // output.write("3 1 ");
      stringStorage[3] = "3 1";
      return 1;
    }

    int divide3 = Integer.MAX_VALUE;
    int divide2 = Integer.MAX_VALUE;
    int minus1 = Integer.MAX_VALUE;

    if(target % 3 == 0) {
      divide3 = dp(numStorage, stringStorage, target / 3);
    }

    if(target % 2 == 0) {
      divide2 = dp(numStorage, stringStorage, target / 2);
    }

    minus1 = dp(numStorage, stringStorage, target - 1);

    int min = Math.min(divide3, Math.min(divide2, minus1));

    // output.write(target + " ");
    if(divide3 == min) {
      stringStorage[target] = target + " " + stringStorage[target / 3];
      return numStorage[target] = 1 + dp(numStorage, stringStorage, target / 3);
    }
    else if(divide2 == min) {
      stringStorage[target] = target + " " + stringStorage[target / 2];
      return numStorage[target] = 1 + dp(numStorage, stringStorage, target / 2);
    }
    else {
      stringStorage[target] = target + " " + stringStorage[target - 1];
      return numStorage[target] = 1 + dp(numStorage, stringStorage, target - 1);
    }
  }
}
