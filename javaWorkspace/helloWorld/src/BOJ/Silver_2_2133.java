package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_2_2133 {
    static int temp[];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());
        temp = new int[length + 1];

        output.write(Integer.toString(dp(length)));

        input.close();
        output.flush();
        output.close();
    }

    public static int dp(int num) {
        int sum = 0;

        if (num == 0)
            return 1;
        if (num % 2 == 1)
            return 0;
        if (num == 2)
            return 3;

        if (temp[num] != 0)
            return temp[num];

        for (int i = 4 ; i <= num ; i++) {
            if (i % 2 == 0)
                sum += dp(num - i);
        }

        return temp[num] = (3 * dp(num - 2) + 2 * sum);
    }
}
