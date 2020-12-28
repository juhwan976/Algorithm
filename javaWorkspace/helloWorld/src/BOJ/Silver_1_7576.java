package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Silver_1_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data1[] = input.readLine().split(" ");
        int x = Integer.parseInt(data1[0]);
        int y = Integer.parseInt(data1[1]);
        int board[][] = new int[x][y];
        Deque<Integer> boardx = new ArrayDeque<>();
        Deque<Integer> boardy = new ArrayDeque<>();
        boolean flag = false;

        int max = 0;

        for (int i = 0; i < y; i++) {
            String data2[] = input.readLine().split(" ");
            for (int j = 0; j < x; j++) {
                board[j][i] = Integer.parseInt(data2[j]);
                if (board[j][i] == 1) {
                    boardx.addLast(j);
                    boardy.addLast(i);
                }
            }
        }

        bfs(boardx, boardy, board, x, y);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(board[i][j] == 0) {
                    flag = true;
                    break;
                } else {
                    if(board[i][j] > max)
                        max = board[i][j];
                }
            }
        }

        if (flag) {
            output.write("-1");
        } else {
            output.write((max - 1) + " ");
        }

        output.flush();
        output.close();
        input.close();

    }

    public static void bfs(Deque<Integer> boardx, Deque<Integer> boardy, int board[][], int x,
            int y) {
        int xpos, ypos;
        if (boardx.size() == 0 || boardy.size() == 0)
            return;

        xpos = boardx.removeFirst();
        ypos = boardy.removeFirst();

        int day = board[xpos][ypos];

        if (xpos - 1 != -1) {
            if (board[xpos - 1][ypos] == 0) {
                boardx.addLast(xpos - 1);
                boardy.addLast(ypos);
                board[xpos - 1][ypos] = day+1;;
            }
        }

        if (xpos + 1 != x) {
            if (board[xpos + 1][ypos] == 0) {
                boardx.addLast(xpos + 1);
                boardy.addLast(ypos);
                board[xpos + 1][ypos] = day+1;
            }
        }

        if (ypos - 1 != -1) {
            if (board[xpos][ypos - 1] == 0) {
                boardx.addLast(xpos);
                boardy.addLast(ypos - 1);
                board[xpos][ypos - 1] = day+1;
            }
        }

        if (ypos + 1 != y) {
            if (board[xpos][ypos + 1] == 0) {
                boardx.addLast(xpos);
                boardy.addLast(ypos + 1);
                board[xpos][ypos + 1] = day+1;
            }
        }

        bfs(boardx, boardy, board, x, y);
    }
}
