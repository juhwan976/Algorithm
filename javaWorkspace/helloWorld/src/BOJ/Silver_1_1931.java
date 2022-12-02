package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Silver_1_1931 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int meetingNum = Integer.parseInt(input.nextLine());

    int meetings[][] = new int[meetingNum][2];

    String tempString = "";

    for(int i = 0 ; i < meetingNum ; i++) {
      tempString = input.nextLine();

      meetings[i][0] = Integer.parseInt(tempString.split(" ")[0]);
      meetings[i][1] = Integer.parseInt(tempString.split(" ")[1]);
    }

    Arrays.sort(meetings, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        if(i1[1] == i2[1]) {
          return i1[0] - i2[0];
        }

        return i1[1] - i2[1];
      }
    });

    int result = 0;
    int currentEndTime = 0;

    for(int i = 0 ; i < meetingNum ; i++) {
      if(currentEndTime <= meetings[i][0]) {
        currentEndTime = meetings[i][1];
        result++;
      }
    }

    System.out.println(result);

    input.close();
  }
}
