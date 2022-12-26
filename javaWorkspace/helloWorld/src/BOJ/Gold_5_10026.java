package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_5_10026 {
  public static int boardSize;
  public static void main(String[] args) throws IOException{
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));


    int size = Integer.parseInt(input.readLine());

    char board[][] =  new char[size][size];
    boardSize = size;

    String temp;

    boolean color3Visit[][] = new boolean[size][size];
    boolean color2Visit[][] = new boolean[size][size];

    int color3Area = 0;
    int color2Area = 0;

    for(int i = 0 ; i < size; i ++) {
      temp = input.readLine();

      for(int j = 0 ; j < size ; j++) {
        board[i][j] = temp.charAt(j);
      }
    }

    for(int i = 0 ; i < size ; i++) {
      for(int j = 0 ; j < size ; j++) {
        if(!color3Visit[i][j]) {
          color3Area++;
          color3Visit[i][j] = true;
          dpsFor3(board, color3Visit, i, j, board[i][j]);
        }

        if(!color2Visit[i][j]) {
          color2Area++;
          color2Visit[i][j] = true;
          dpsFor2(board, color2Visit, i, j, board[i][j]);
        }

      }
    }

    output.write(color3Area + " " + color2Area);

    output.flush();
    output.close();
    input.close();
  }

  public static void dpsFor3(char[][] board, boolean[][] visit, int currentX, int currentY, char currentColor) {
    if(currentX > 0) {
      if(!visit[currentX - 1][currentY] && board[currentX - 1][currentY] == currentColor) {
        visit[currentX - 1][currentY] = true;
        dpsFor3(board, visit, currentX - 1, currentY, currentColor);
      }
    }

    if(currentX < boardSize - 1) {
      if(!visit[currentX + 1][currentY] && board[currentX + 1][currentY] == currentColor) {
        visit[currentX + 1][currentY] = true;
        dpsFor3(board, visit, currentX + 1, currentY, currentColor);
      }
    }

    if(currentY > 0) {
      if(!visit[currentX][currentY - 1] && board[currentX][currentY - 1] == currentColor) {
        visit[currentX][currentY - 1] = true;
        dpsFor3(board, visit, currentX, currentY - 1, currentColor);
      }
    }

    if(currentY < boardSize - 1) {
      if(!visit[currentX][currentY + 1] && board[currentX][currentY + 1] == currentColor) {
        visit[currentX][currentY + 1] = true;
        dpsFor3(board, visit, currentX, currentY + 1, currentColor);
      }
    }
  }

  public static void dpsFor2(char[][] board, boolean[][] visit, int currentX, int currentY, char currentColor) {
    if(currentX > 0) {
      if(!visit[currentX - 1][currentY] && compare2Color(board[currentX - 1][currentY], currentColor)) {
        visit[currentX - 1][currentY] = true;
        dpsFor2(board, visit, currentX - 1, currentY, currentColor);
      }
    }

    if(currentX < boardSize - 1) {
      if(!visit[currentX + 1][currentY] && compare2Color(board[currentX + 1][currentY], currentColor)) {
        visit[currentX + 1][currentY] = true;
        dpsFor2(board, visit, currentX + 1, currentY, currentColor);
      }
    }

    if(currentY > 0) {
      if(!visit[currentX][currentY - 1] && compare2Color(board[currentX][currentY - 1], currentColor)) {
        visit[currentX][currentY - 1] = true;
        dpsFor2(board, visit, currentX, currentY - 1, currentColor);
      }
    }

    if(currentY < boardSize - 1) {
      if(!visit[currentX][currentY + 1] && compare2Color(board[currentX][currentY + 1], currentColor)) {
        visit[currentX][currentY + 1] = true;
        dpsFor2(board, visit, currentX, currentY + 1, currentColor);
      }
    }
  }

  public static boolean compare2Color(char color1, char color2) {
    if((color1 == 'R' || color1 == 'G') && (color2 == 'R' || color2 == 'G')) {
      return true;
    }
    else if(color1 == color2) {
      return true;
    }
    else {
      return false;
    }
  }
}
