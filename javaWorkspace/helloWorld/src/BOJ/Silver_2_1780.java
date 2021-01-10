package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_2_1780 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int board[][];
    private static int size;
    private static int num1 = 0;
    private static int num0 = 0;
    private static int numm1 = 0;

    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(input.readLine());

        board = new int[size][size];

        for (int i = 0; i < size; i++) {
            String data[] = input.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(data[j]);
            }
        }

        divide(0, 0, size);

        output.write(numm1 + "\n" + num0 + "\n" + num1);

        output.flush();
        output.close();
        input.close();
    }

    public static void divide(int left, int top, int size) {
        boolean flag = false;
        int def = board[left][top];

        if (size == 1) {
            if (def == -1) {
                numm1++;
            } else if (def == 0) {
                num0++;
            } else {
                num1++;
            }
        } else {
            for (int i = left; i < size + left; i++) {
                for (int j = top; j < size + top; j++) {
                    if (board[i][j] != def) {
                        flag = true;
                        break;
                    }
                }

                if (flag)
                    break;
            }

            if (flag) {
                divide(left, top, size / 3);
                divide(left + size / 3, top, size / 3);
                divide(left + size * 2 / 3, top, size / 3);

                divide(left, top + size / 3, size / 3);
                divide(left + size / 3, top + size / 3, size / 3);
                divide(left + size * 2 / 3, top + size / 3, size / 3);

                divide(left, top + size * 2 / 3, size / 3);
                divide(left + size / 3, top + size * 2 / 3, size / 3);
                divide(left + size * 2 / 3, top + size * 2 / 3, size / 3);
            } else {
                if (def == -1) {
                    numm1++;
                } else if (def == 0) {
                    num0++;
                } else {
                    num1++;
                }
            }
        }
    }
}