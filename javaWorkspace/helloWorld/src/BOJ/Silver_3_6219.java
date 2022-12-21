package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_6219 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp = input.readLine();

    int startNum = Integer.parseInt(temp.split(" ")[0]);
    int endNum = Integer.parseInt(temp.split(" ")[1]);
    int containNum = Integer.parseInt(temp.split(" ")[2]);

    boolean isPrime;
    int count = 0;

    for(int i = startNum ; i <= endNum ; i++) {
      if(i == 1) {
        continue;
      }

      isPrime = true;

      for(int j = 2 ; j * j <= i ; j++) {
        if(i % j == 0) {
          isPrime = false;
          break;
        }
      }

      if(isPrime) {
        temp = i + "";

        for(int j = 0 ; j < temp.length() ; j++) {
          if(Integer.parseInt(temp.charAt(j) + "") == containNum) {
            count++;
            break;
          }
        }
      }
    }

    output.write(count + "");
    output.flush();

    output.close();
    input.close();
  }
}
