package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Gold_4_2206 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int x;
    private static int y;
    private static int board[][];
    private static boolean rboard[][];
    private static Deque<Integer> xpos = new ArrayDeque<>();
    private static Deque<Integer> ypos = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        String data[] = input.readLine().split(" ");
        y = Integer.parseInt(data[0]);
        x = Integer.parseInt(data[1]);

        board = new int[x][y];
        rboard = new boolean[x][y];

        for (int i = 0; i < y; i++) {
            String data1 = input.readLine();
            for (int j = 0; j < x; j++) {
                if (data1.charAt(j) == '1')
                    rboard[j][i] = true;
            }
        }

        xpos.addLast(0);
        ypos.addLast(0);

        bfs(false);

        output.write(board[x-1][y-1] + "");

        output.flush();
        output.close();
        input.close();
    }

    public static void bfs(boolean isBroken) {
        if (xpos.isEmpty() && ypos.isEmpty()) {
            return;
        }

        int xnow = xpos.removeFirst();
        int ynow = ypos.removeFirst();
        int num = board[xnow][ynow];

        if (xnow != 0) {
            if (!rboard[xnow - 1][ynow]) {
                board[xnow - 1][ynow] = num + 1;
                xpos.addLast(xnow - 1);
                ypos.addLast(ynow);
                bfs(isBroken);
            } else {
                if (!isBroken) {
                    board[xnow - 1][ynow] = num + 1;
                    xpos.addLast(xnow - 1);
                    ypos.addLast(ynow);
                    bfs(true);
                }
            }
        }

        if (ynow != 0) {
            if (!rboard[xnow][ynow - 1]) {
                board[xnow][ynow - 1] = num + 1;
                xpos.addLast(xnow);
                ypos.addLast(ynow - 1);
                bfs(isBroken);
            } else {
                if (!isBroken) {
                    board[xnow][ynow - 1] = num + 1;
                    xpos.addLast(xnow);
                    ypos.addLast(ynow - 1);
                    bfs(true);
                }
            }
        }

        if (xnow != x - 1) {
            if (ynow == y - 1) {
                if (xnow + 1 == x - 1 && ynow == y - 1) {
                    if (board[xnow + 1][ynow] == 0) {
                        board[xnow + 1][ynow] = num + 1;
                    } else {
                        if (num + 1 < board[xnow + 1][ynow]) {
                            board[xnow + 1][ynow] = num + 1;
                        }
                    }
                }
            } else {
                if (!rboard[xnow + 1][ynow]) {
                    board[xnow + 1][ynow] = num + 1;
                    xpos.addLast(xnow + 1);
                    ypos.addLast(ynow);
                    bfs(isBroken);
                } else {
                    if (!isBroken) {
                        board[xnow][ynow + 1] = num + 1;
                        xpos.addLast(xnow);
                        ypos.addLast(ynow + 1);
                        bfs(true);
                    }
                }
            }
        }

        if (ynow != y - 1) {
            if (xnow == x - 1) {
                if (xnow == x - 1 && ynow + 1 == y - 1) {
                    if (board[xnow][ynow + 1] == 0) {
                        board[xnow][ynow + 1] = num + 1;
                    } else {
                        if (num + 1 < board[xnow][ynow + 1]) {
                            board[xnow][ynow + 1] = num + 1;
                        }
                    }
                }
            } else {
                if (!rboard[xnow][ynow + 1]) {
                    board[xnow][ynow + 1] = num + 1;
                    xpos.addLast(xnow);
                    ypos.addLast(ynow + 1);
                    bfs(isBroken);
                } else {
                    if (!isBroken) {
                        board[xnow][ynow + 1] = num + 1;
                        xpos.addLast(xnow);
                        ypos.addLast(ynow + 1);
                        bfs(true);
                    }
                }
            }
        }
    }
}
