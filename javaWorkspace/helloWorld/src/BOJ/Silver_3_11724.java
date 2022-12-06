package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_11724 {
  public static void main(String[] args) throws IOException{
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp;

    temp = input.readLine();

    int nodeNum = Integer.parseInt(temp.split(" ")[0]);
    int roadNum = Integer.parseInt(temp.split(" ")[1]);

    boolean[] visited  = new boolean[nodeNum];
    boolean[][] nodes = new boolean[nodeNum][nodeNum];

    int start;
    int end;
    int result = 0;

    for(int i = 0 ; i < roadNum ; i++) {
      temp = input.readLine();

      start = Integer.parseInt(temp.split(" ")[0]);
      end = Integer.parseInt(temp.split(" ")[1]);

      nodes[start - 1][end - 1] = true;
      nodes[end - 1][start - 1] = true;
    }

    for(int i = 0 ; i < nodeNum ; i++) {
      if(!visited[i]) {
        result++;
        dfs(nodes, visited, i);
      }
    }

    if(roadNum == 0) {
      result = nodeNum;
    }

    output.write(result + "");
    output.flush();

    output.close();
    input.close();
  }

  public static void dfs(boolean[][] nodes, boolean[] visited, int current) {
    if(visited[current]) {
      return;
    }

    visited[current] = true;

    for(int i = 0 ; i < nodes[current].length ; i++) {
      if(nodes[current][i] && !visited[i]) {
        dfs(nodes, visited, i);
      }
    }
  }
}
