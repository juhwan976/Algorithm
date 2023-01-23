package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_4_1590 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp = input.readLine();

    int busNum = Integer.parseInt(temp.split(" ")[0]);
    int arriveAt = Integer.parseInt(temp.split(" ")[1]);

    int[][] busInfos = new int[busNum][3];

    for(int i = 0 ; i < busInfos.length ; i++) {
      temp = input.readLine();

      busInfos[i][0] = Integer.parseInt(temp.split(" ")[0]);
      busInfos[i][1] = Integer.parseInt(temp.split(" ")[1]);
      busInfos[i][2] = Integer.parseInt(temp.split(" ")[2]);
    }

    int min = Integer.MAX_VALUE;

    for(int i = 0 ; i < busInfos.length ; i++) {
      for(int j = 0 ; j < busInfos[i][2] ; j++) {
        int result = busInfos[i][0] + (busInfos[i][1] * j);
        if(arriveAt <= result) {
          if(min > (result - arriveAt)) {
            min = result - arriveAt;
          }
        }
      }
    }

    if(min == Integer.MAX_VALUE) {
      output.write(-1 + "");
    }
    else {
      output.write(min + "");
    }
    output.flush();

    output.close();
    input.close();
  }
}
