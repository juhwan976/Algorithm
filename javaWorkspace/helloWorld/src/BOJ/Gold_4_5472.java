package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_4_5472 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());

        for (int i = 0; i < length; i++) {
            String data[] = input.readLine().split("");
            int boardx = Integer.parseInt(data[0]);
            int boardy = Integer.parseInt(data[1]);
            char board[][] = new char[boardx][boardy];
            int userBoard[][] = new int[boardx][boardy];
            int user[] = new int[2];
            int count = 1;

            for (int j = 0; j < boardy; j++) {
                String data1 = input.readLine();
                for (int k = 0; k < boardx; k++) {
                    board[k][j] = data1.charAt(k);
                    if (board[k][j] == '@') {
                        user[0] = k;
                        user[1] = j;
                        userBoard[user[0]][user[1]] = count;
                    }
                }
            }

            while (true) {
                for(int j = 0 ; j < boardy ; j++) {
                    for(int k = 0 ; k < boardx ; k++) {
                        if(userBoard[k][j] == count) {
                            if(k != 0 && board[k-1][j] == '.' ) {
                                if(userBoard[k-1][j] == 0 || userBoard[k-1][j] > count + 1)
                                    userBoard[k-1][j] = count + 1;
                            }

                            if(k != boardx && board[k+1][j] == '.') {
                                if(userBoard[k+1][j] == 1 || userBoard[k+1][j] > count + 1)
                                    userBoard[k+1][j] = count + 1;
                            }


                        }
                    }
                }
                
            }

        }

        input.close();
        output.flush();
        output.close();

    }
}
