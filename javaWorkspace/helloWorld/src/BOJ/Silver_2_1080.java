package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_2_1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String xNy[] = input.readLine().split(" ");
        int y = Integer.parseInt(xNy[0]);
        int x = Integer.parseInt(xNy[1]);
        int inputBoard[][] = new int[x][y];
        int resultBoard[][] = new int[x][y];
        int num = 0;
        boolean flag = false;

        for(int i = 0 ; i < y ; i++) {
            String data = input.readLine();
            for(int j =  0 ; j < x ; j++) {
                inputBoard[j][i] = Integer.parseInt(data.charAt(j)+"");
            }
        }

        for(int i = 0 ; i < y ; i++) {
            String data = input.readLine();
            for(int j = 0 ; j < x ; j++) {
                resultBoard[j][i] = Integer.parseInt(data.charAt(j)+"");
            }
        }

        for(int i = 0 ; i < y - 2 ; i++) {
            for(int j = 0 ; j < x-2 ; j++) {
                if(inputBoard[j][i] != resultBoard[j][i]) {
                    toggleBoard(inputBoard, j, i);
                    num++;
                }
            }
        }

        for(int i = 0 ; i < y ; i++) {
            for(int j = 0 ; j < x ; j++) {
                if(inputBoard[j][i] != resultBoard[j][i]) {
                   flag = true;
                   break;
                }
            }
        }

        if(flag) {
            output.write("-1");
        }
        else {
            output.write(num+"");
        }

        output.flush();
        
        input.close();
        output.close();
    }

    public static void toggleBoard(int arr[][], int x, int y) {
        for(int i = y ; i <= y + 2 ; i++) {
            for(int j = x ; j <= x + 2 ; j++) {
                if(arr[j][i] == 1)
                    arr[j][i] = 0;
                else   
                    arr[j][i] = 1;
            }
        }
    }
}
