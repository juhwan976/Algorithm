package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_3_24337 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp;

    temp = input.readLine();

    int num = Integer.parseInt(temp.split(" ")[0]);
    int a = Integer.parseInt(temp.split(" ")[1]);
    int b = Integer.parseInt(temp.split(" ")[2]);

    int count = 1;

    if(num < a + b - 1) {
      output.write("-1");
    }
    else {
      for(int i = 0 ; i < num ; i++) {
        if(num - 1 - i < b) {
          output.write(count-- + " ");
        }
        else {
          if(a - 1 == num - b) {
            output.write(count++ + " ");
          }
          else {
            output.write(count + " ");
          }
        }
      }
    }

    output.flush();
    output.close();
    input.close();
  }
}
