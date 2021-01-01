package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Gold_4_5472 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());

        for (int i = 0; i < length; i++) {
            String xNy[] = input.readLine().split(" ");
            int x = Integer.parseInt(xNy[0]);
            int y = Integer.parseInt(xNy[1]);
            char board[][] = new char[x][y];
            int user[][] = new int[x][y];
            int fire[][] = new int[x][y];
            Deque<Pair> userDeque = new ArrayDeque<>();
            Deque<Pair> fireDeque = new ArrayDeque<>();

            for (int j = 0; j < y; j++) {
                String boardData = input.readLine();
                for (int k = 0; k < x; k++) {
                    board[k][j] = boardData.charAt(k);
                    if (board[k][j] == '@') {
                        user[k][j] = 1;
                        Pair pair = new Pair(k, j);
                        userDeque.addLast(pair);
                    } else if (board[k][j] == '*') {
                        fire[k][j] = 1;
                        Pair pair = new Pair(k, j);
                        fireDeque.addLast(pair);
                    }
                }
            }

        }

        input.close();
        output.flush();
        output.close();
    }

    public void bfs_user(Deque<Pair> userdeque, int board[][], int user[][], int fire[][], int x, int y, int day) {
        if (userdeque.isEmpty())
            return;

        Pair pair = userdeque.removeFirst();

        if (pair.x == 0 || pair.x == x - 1 || pair.y == 0 || pair.y == y - 1)
            return;

        int value = user[pair.x][pair.y];

        if (value != day) {
            userdeque.addFirst(pair);
            return;
        } else {
            if (pair.x != 0) {
                if (board[pair.x - 1][pair.y] == '.') {
                    if(isSafe(board, x, y, pair.x - 1, pair.y)) {
                        userdeque.addLast(new Pair(pair.x - 1, pair.y));
                        user[pair.x - 1][pair.y] = day + 1;
                    }
                }
            }

            if (pair.x != x - 1) {
                if (board[pair.x + 1][pair.y] == '.') {

                }
            }

            if (pair.y != 0) {
                if (board[pair.x][pair.y - 1] == '.') {

                }
            }

            if (pair.y != y - 1) {
                if (board[pair.x][pair.y + 1] == '.') {

                }
            }
        }

        bfs_user(userdeque, board, user, fire, x, y, day);
    }

    public boolean isSafe(int board[][], int x, int y, int nowx, int nowy) {
        if(nowx != 0) {
            if(board[nowx - 1][nowy] == '*') {
                return false;
            }
        }

        if(nowx + 1 != x) {
            if(board[nowx + 1][nowy] == '*') {
                return false;
            }
        }

        if(nowy != 0) {
            if(board[nowx][nowy - 1] == '*') {
                return false;
            }
        }

        if(nowy + 1 != y) {
            if(board[nowx][nowy + 1] == '*') {
                return false;
            }
        }

        return true;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
