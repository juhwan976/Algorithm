package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_5_23048 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp = input.readLine();

    int num = Integer.parseInt(temp);
    int colorNum = 0;
    int[] colorBoard = new int[num + 1];

    for(int i = 1 ; i <= num ; i++) {
      if(i == 1) {
        colorBoard[i] = ++colorNum;
      }
      else {
        Integer divideNum = null;

        for(int j = 2 ; j * j <= i ; j++) {
          if(i % j == 0) {
            divideNum = j;
            break;
          }
        }

        if(divideNum != null) {
          colorBoard[i] = colorBoard[divideNum];
        }
        else {
          colorBoard[i] = ++colorNum;
        }
      }
    }

    output.write(colorNum + "\n");
    for(int i = 1 ; i <= num ; i++) {
      output.write(colorBoard[i] + " ");
    }
    output.flush();

    output.close();
    input.close();
  }
}
