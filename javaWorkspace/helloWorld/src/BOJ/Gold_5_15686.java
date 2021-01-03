package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_5_15686 {
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data[] = input.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int board[][] = new int[n + 1][n + 1];
        int hnum = 0;
        int cnum = 0;

        for (int i = 1; i <= n; i++) {
            String line[] = input.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                board[j][i] = Integer.parseInt(line[j - 1]);
                if (board[j][i] == 1) {
                    hnum++;
                } else if (board[j][i] == 2) {
                    cnum++;
                }
            }
        }

        int homes[][] = new int[hnum][2];
        int chicken[][] = new int[cnum][2];
        int min[] = new int[hnum];
        int sum = 0;
        int temp1 = 0;
        int temp2 = 0;

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                if(board[j][i] == 1) {
                    homes[temp1][0] = j;
                    homes[temp1][1] = i;
                    temp1++;
                }
                else if(board[j][i] == 2) {
                    chicken[temp2][0] = j;
                    chicken[temp2][1] = i;
                    temp2++;
                }
            }
        }

        if(m >= cnum) {
            for(int i = 0 ; i < hnum ; i++) {
                for(int j = 0 ; j < cnum ; j++) {
                    if(j == 0) {
                        min[i] = Math.abs(chicken[j][0] - homes[i][0]) + Math.abs(chicken[j][1] - homes[i][1]);
                    }
                    else {
                        if(min[i] > Math.abs(chicken[j][0] - homes[i][0]) + Math.abs(chicken[j][1] - homes[i][1])) {
                            min[i] = Math.abs(chicken[j][0] - homes[i][0]) + Math.abs(chicken[j][1] - homes[i][1]);
                        }
                    }
                }
                sum += min[i];
            }
        }
        else {
            int mins[][] = new int[13*12*11][hnum];
            boolean visited[] = new boolean[cnum];
            int result = 0;

            combination(mins, homes, hnum, chicken, cnum, visited, 0, cnum, m);

            for(int i = 0 ; i < index ; i++) {
                sum = 0;
                for(int j = 0 ; j < hnum ; j++) {
                    sum +=  mins[i][j];
                }

                if(i == 0) {
                    result = sum;
                }
                else {
                    if(result > sum) {
                        result = sum;
                    }
                }
            }

            sum = result;
        }

        output.write(sum + " ");

        output.flush();
        output.close();
        input.close();
    }

    static void combination(int mins[][], int homes[][], int hnum, int chicken[][], int cnum, boolean visited[], int depth, int n, int r) {
        if(r == 0) {
            for(int i = 0 ; i < hnum ; i++) {
                boolean flag = false;

                for(int j = 0 ; j < cnum ; j++) {
                    if(visited[j]) {
                        if(!flag) {
                            mins[index][i] = Math.abs(chicken[j][0] - homes[i][0]) + Math.abs(chicken[j][1] - homes[i][1]);
                            flag = true;
                        }
                        else {
                            if(mins[index][i] > Math.abs(chicken[j][0] - homes[i][0]) + Math.abs(chicken[j][1] - homes[i][1])) {
                                mins[index][i] = Math.abs(chicken[j][0] - homes[i][0]) + Math.abs(chicken[j][1] - homes[i][1]);
                            }
                        }
                    }
                }
            }

            index++;
            return;
        }

        if(depth == n)
            return;

        visited[depth] = true;
        combination(mins, homes, hnum, chicken, cnum, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(mins, homes, hnum, chicken, cnum, visited, depth + 1, n ,r);
    }
}
