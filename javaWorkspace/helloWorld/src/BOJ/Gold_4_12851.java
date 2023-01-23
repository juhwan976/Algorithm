package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_4_12851 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp = input.readLine();

    int start = Integer.parseInt(temp.split(" ")[0]);
    int end = Integer.parseInt(temp.split(" ")[1]);

    int[] fastest = new int[end + 1];

    output.write(dp(fastest, start, end) + "");
    output.flush();

    input.close();
    output.close();
  }

  public static int dp(int[] fastest, int start, int end) {
    if(end > fastest.length || end < 0) {
      return Integer.MAX_VALUE;
    }

    if(fastest[end] != 0) {
      return fastest[end];
    }

    if(start == end) {
      fastest[end] = 0;
      return 0;
    }
    else if(start - 1 == end) {
      fastest[end] = 1;
      return 1;
    }
    else if(start + 1 == end) {
      fastest[end] = 1;
      return 1;
    }
    else if(start * 2 == end) {
      fastest[end] = 1;
      return 1;
    }

    int minus = dp(fastest, start, end - 1);
    int plus = dp(fastest, start , end + 1);
    int multiple = Integer.MAX_VALUE;

    if(end % 2 == 0) {
      multiple = dp(fastest, start, end / 2);
    }

    int min = Math.min(minus, Math.min(plus, multiple));

    if(min == minus) {
      fastest[end] = dp(fastest,start, end - 1) + 1;
    }
    else if(min == plus) {
      fastest[end] = dp(fastest,start, end + 1) + 1;
    }
    else {
      fastest[end] = dp(fastest, start, end / 2) + 1;
    }

    return fastest[end];
  }
}
