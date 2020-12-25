package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_1463 {
    static int temp[];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(input.readLine());
        temp = new int[num + 1];

        output.write(Integer.toString(dp(num)));

        input.close();
        output.flush();
        output.close();
    }

    public static int dp(int num) {
        if (num == 1)
            return 0;
        if (num == 2)
            return 1;
        if (num == 3)
            return 1;

        if (temp[num] != 0)
            return temp[num];

        if (num % 6 == 0)
            return temp[num] = Math.min(Math.min(dp(num / 2), dp(num / 3)), dp(num - 1)) + 1;
        else if (num % 3 == 0)
            return temp[num] = Math.min(dp(num / 3), dp(num - 1)) + 1;
        else if (num % 2 == 0)
            return temp[num] = Math.min(dp(num / 2), dp(num - 1)) + 1;
        else
            return temp[num] = dp(num - 1) + 1;
    }
}