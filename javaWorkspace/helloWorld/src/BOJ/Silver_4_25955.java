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

    temp = input.readLine();

    for(int i = 0 ; i < arrLength ; i++) {
      arr[i] = temp.split(" ")[i];
    }

    boolean start = false;
    Integer startIndex = null;
    boolean end = false;
    Integer endIndex = null;

    for(int i = 1 ; i < arrLength ; i++) {
      if(arr[i - 1].charAt(0) == arr[i].charAt(0)) {
        if(Integer.parseInt(arr[i - 1].substring(1)) < Integer.parseInt(arr[i].substring(1))) {
          if(!start) {
            start = true;
            startIndex = i - 1;
          }
          else {
            end = true;
            endIndex = i;
          }
        }
      }
      else {
        if(compareRank(arr[i - 1].charAt(0), arr[i].charAt(0))) {

        }
        else {
          if(!start) {
            start = true;
            startIndex = i - 1;
          }
          else {
            end = true;
            endIndex = i;
          }
        }
      }
    }

    if(startIndex == null) {
      output.write("OK");
    }
    else {
      output.write("KO\n");
      if(endIndex == null){
        endIndex = 1;
      }
      output.write(arr[endIndex] + " " + arr[startIndex]);
    }

    output.flush();

    output.close();
    input.close();
  }

  public static boolean compareRank(char c1, char c2) {
    int c1Index = 0;
    int c2Index = 0;

    for(int i = 0 ; i < ranks.length ; i++) {
      if(ranks[i] == c1) {
        c1Index = i;
      }

      if(ranks[i] == c2) {
        c2Index = i;
      }
    }

    if(c1Index <= c2Index) {
      return true;
    }
    else {
      return false;
    }
  }
}
