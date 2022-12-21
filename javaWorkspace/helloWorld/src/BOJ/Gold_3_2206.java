package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_3_2206 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    String temp = input.readLine();

    int row = Integer.parseInt(temp.split(" ")[0]);
    int col = Integer.parseInt(temp.split(" ")[1]);

    int[][] board = new int[row][col];
    boolean[][] canMove = new boolean[row][col];

    for(int i = 0 ; i < row ; i++) {
      temp = input.readLine();

      for(int j = 0 ; j < col ; j++) {
        // board[i][j] = Integer.parseInt(temp.charAt(j) + "");
        if(Integer.parseInt(temp.charAt(j) + "") == 1) {
          canMove[i][j] = false;
        }
        else {
          canMove[i][j] = true;
        }
      }
    }

    bfs(board, canMove, 0, 0, true);

    output.close();
    input.close();
  }

  public static void bfs(int[][] board, boolean[][] canMove, int currentRow, int currentCol, boolean canBreak) {

  }
}
