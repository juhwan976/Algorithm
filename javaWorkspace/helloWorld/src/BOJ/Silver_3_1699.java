package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_1699 {
    static int temp[];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(input.readLine());
        temp = new int[num + 1];

        output.write(Long.toString(dp(num)));

        input.close();
        output.flush();
        output.close();
    }

    public static int dp(int num) {
        int min = 1000000;

        if (num == 0)
            return 0;

        if (temp[num] != 0)
            return temp[num];

        if ((int) Math.sqrt(num) * (int) Math.sqrt(num) == num)
            min = 1;
        else {
            for (int i = 1; (i * i) < num; i++) {
                min = Math.min(dp(num - (i * i)) + 1, min);
            }
        }

        return temp[num] = min;
    }
}
