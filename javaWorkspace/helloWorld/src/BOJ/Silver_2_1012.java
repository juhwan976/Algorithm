package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_2_1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());

        for (int i = 0; i < length; i++) {
            String dataIn[] = input.readLine().split(" ");
            int x = Integer.parseInt(dataIn[0]);
            int y = Integer.parseInt(dataIn[1]);
            int baechu = Integer.parseInt(dataIn[2]);
            boolean board[][] = new boolean[x][y];
            boolean counted[][] = new boolean[x][y];
            int num = 0;

            for (int j = 0; j < baechu; j++) {
                String data2[] = input.readLine().split(" ");
                board[Integer.parseInt(data2[0])][Integer.parseInt(data2[1])] = true;
            }

            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if (board[j][k]) {
                        if(!counted[j][k]) {
                            num++;
                            counted[j][k] = true;
                            checkNear(board, counted, j, k, x, y);
                        }
                    }
                }
            }

            output.write(num + "\n");
        }

        input.close();
        output.flush();
        output.close();
    }

    public static void checkNear(boolean board[][], boolean counted[][], int j, int k, int x, int y) {
        if(j - 1 != -1 && board[j - 1][k] && !counted[j-1][k]) {
            counted[j-1][k] = true;
            checkNear(board, counted, j-1, k, x, y);
        }

        if(k - 1 != -1 && board[j][k-1] && !counted[j][k-1]) {
            counted[j][k-1] = true;
            checkNear(board, counted, j, k-1, x, y);
        }

        if(j + 1 != x && board[j+1][k] && !counted[j+1][k]) {
            counted[j+1][k] = true;
            checkNear(board, counted, j+1, k, x, y);
        }   

        if(k + 1 != y && board[j][k + 1] && !counted[j][k+1]) {
            counted[j][k+1] = true;
            checkNear(board, counted, j, k+1 ,x, y);
        }
    }
}
