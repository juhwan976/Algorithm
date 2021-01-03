package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_2_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data[] = input.readLine().split(" ");
        int start = Integer.parseInt(data[0]);
        int end = Integer.parseInt(data[1]);
        int min = check(start);

        for(int i = start ; i <= end ; i++) {
            int temp = check(i);
            if(temp < min) {
                min = temp;
            }

            if(min == 0) {
                break;
            }
        }

        output.write(min + " ");
        output.flush();
        output.close();
        input.close();
    }

    public static int check(int num) {
        if(num <= 10) {
            if(num == 8) {
                return 1;
            }
            else return 0;
        }

        if(num % 10 == 8) {
            return check(num / 10) + 1;
        }
        else {
            return check(num / 10);
        }
    }
}