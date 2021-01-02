package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_2360 {
    static int black = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(input.readLine());
        int board[][] = new int[size][size];

        for (int i = 0; i < size; i++) {
            String data[] = input.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(data[j]);
            }
        }

        divide(board, 0, size - 1 , 0, size - 1);

        output.write(white + "\n" + black);

        output.flush();
        output.close();
        input.close();
    }

    public static void divide(int board[][], int left, int right, int top, int bottom) {
        if(left == right || top == bottom) {
            if(board[left][top] == 0) {
                white++;
            }
            else {
                black++;
            }

            return;
        }

        int temp = board[left][top];
        int midx = (left + right) / 2;
        int midy = (top + bottom) / 2;
        boolean flag = false;

        for(int i = top ; i <= bottom ; i++) {
            for(int j = left ; j <= right ; j++) {
                if(board[j][i] != temp) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                break;
            }
        }

        if(flag) {
            divide(board, left, midx, top, midy);
            divide(board, midx + 1, right, top, midy);
            divide(board, left, midx, midy + 1, bottom);
            divide(board, midx + 1, right, midy + 1, bottom);
        }
        else {
            if(temp == 0) {
                white++;
            }
            else {
                black++;
            }
        }
    }
}
