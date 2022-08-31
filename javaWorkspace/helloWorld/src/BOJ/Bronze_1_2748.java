package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze_1_2748 {
    static int temp[];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(input.readLine());
        temp = new int[target + 1];

        output.write(Integer.toString(dp(target)));

        input.close();
        output.flush();
        output.close();
    }

    public static int dp(int num) {
        if (num == 0) {
            return 0;
        }
        else if(num == 1) {
            return 1;
        }

        if (temp[num] != 0) {
            return temp[num];
        }

        return temp[num] = dp(num - 1) + dp(num - 2);
    }

    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        else {
            return factorial(num - 1) * num;
        }
    }
}
