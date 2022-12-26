package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Gold_4_1043 {
  public static int peopleNum;
  public static int partyNum;

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp;

    temp = input.readLine();

    peopleNum = Integer.parseInt(temp.split(" ")[0]);
    partyNum = Integer.parseInt(temp.split(" ")[1]);

    int[][] parties = new int[51][51];
    boolean[] isCheck = new boolean[51];

    Queue<Integer> knowTrue = new LinkedList<>();

    temp = input.readLine();

    for(int i = 1 ; i <= Integer.parseInt(temp.split(" ")[0]) ; i++) {
      knowTrue.add(Integer.parseInt(temp.split(" ")[i]));
    }

    for(int i = 1 ; i <= partyNum ; i++) {
      temp = input.readLine();

      parties[i][0] = Integer.parseInt(temp.split(" ")[0]);

      for(int j = 1 ; j <= parties[i][0] ; j++) {
        parties[i][j] = Integer.parseInt(temp.split(" ")[j]);
      }
    }

    bfs(parties, isCheck, knowTrue);

    int result = 0;

    for(int i = 1 ; i <= partyNum ; i++) {
      if(!isCheck[i]) {
        result++;
      }
    }

    output.write(result + "");
    output.flush();

    output.close();
    input.close();
  }

  public static void bfs(int[][] parties, boolean[] isCheck, Queue<Integer> knowTrue) {
    if(knowTrue.isEmpty()) {
      return;
    }

    int target = knowTrue.poll();

    for(int i = 1 ; i <= partyNum ; i++) {
      for(int j = 1 ; j <= parties[i][0] ; j++) {
        if(target == parties[i][j]) {
          if(!isCheck[i]) {
            isCheck[i] = true;

            for(int k = 1 ; k <= parties[i][0] ; k++) {
              knowTrue.add(parties[i][k]);
            }

            break;
          }
        }
      }

      bfs(parties, isCheck, knowTrue);
    }
  }
}
