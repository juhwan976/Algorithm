package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_4_25955 {
  public static char[] ranks = {'B', 'S', 'G', 'P', 'D'};
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp = input.readLine();

    int arrLength = Integer.parseInt(temp);

    String[] arr = new String[arrLength];
    String[] sorted = new String[arrLength];

    temp = input.readLine();

    for(int i = 0 ; i < arrLength ; i++) {
      arr[i] = temp.split(" ")[i];
      sorted[i] = temp.split(" ")[i];
    }

    for(int i = 0 ; i < arrLength - 1 ; i++) {
      for(int k = i + 1 ; k < arrLength ; k++) {
        if(sorted[i].charAt(0) == sorted[k].charAt(0)) {
          if(Integer.parseInt(sorted[i].substring(1)) < Integer.parseInt(sorted[k].substring(1))) {
            String tempString = sorted[i];
            sorted[i] = sorted[k];
            sorted[k] = tempString;
          }
        }
        else {
          int c1Index = 0;
          int c2Index = 0;

          for(int j = 0 ; j < ranks.length ; j++) {
            if(ranks[j] == sorted[i].charAt(0)) {
              c1Index = j;
            }

            if(ranks[j] == sorted[k].charAt(0)) {
              c2Index = j;
            }
          }

          if(c2Index < c1Index) {
            String tempString = sorted[i];
            sorted[i] = sorted[k];
            sorted[k] = tempString;
          }
        }
      }
    }

    Integer firstIndex = null;
    Integer secondIndex = null;

    for(int i = 0 ; i < arrLength ; i++) {
      if(!(arr[i].equals(sorted[i]))) {
        if(firstIndex == null) {
          firstIndex = i;
        }
        else {
          secondIndex = i;
        }
      }
    }

    // output.write("\n");

    if(firstIndex == null) {
      output.write("OK");
    }
    else {
      output.write("KO\n");
      output.write(sorted[firstIndex] + " " + sorted[secondIndex]);
    }
    output.flush();

    output.close();
    input.close();
  }
}
