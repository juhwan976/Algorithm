package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Silver_4_1764 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int dontSee = Integer.parseInt(input.next());
    int dontListen = Integer.parseInt(input.next());

    String[] dontSees = new String[dontSee];
    String[] dontListens = new String[dontListen];

    int dontSeeNListen = 0;
    String[] dontSeeNListens = new String[Math.max(dontSee, dontListen)];

    for (int i = 0; i < dontSee; i++) {
      dontSees[i] = input.next();
    }

    for (int i = 0; i < dontListen; i++) {
      dontListens[i] = input.next();
    }

    Arrays.sort(dontSees);
    Arrays.sort(dontListens);

    int result = 0;
    int start;
    int mid;
    int last;

    for (int i = 0; i < dontSee; i++) {
      start = 0;
      last = dontListen - 1;
      mid = dontListen / 2;

      while (start <= last) {
        result = dontSees[i].compareTo(dontListens[mid]);

        if (result == 0) {
          dontSeeNListens[dontSeeNListen++] = dontSees[i];
          break;
        }
        // 인자가 사전적으로 뒤에 있을 때
        else if(result > 0) {
          start = mid + 1;
        }
        // 인자가 사전적으로 앞에 있을 때
        else {
          last = mid - 1;
        }
        mid = (start + last) / 2;
      }
    }

    System.out.println(dontSeeNListen);
    for (int i = 0; i < dontSeeNListen; i++) {
      System.out.println(dontSeeNListens[i]);
    }

    // a.compareTo(b)
    // 0보다 클 경우 : a가 b보다 뒤에 있음
    // 0보다 작을 경우 : a가 b보다 앞에 있음
    // 0 일 경우 : 두개가 같음

    input.close();
  }
}
