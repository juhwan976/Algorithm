package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_11727 {
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
        if(num == 1) return 1;
        if(num == 2) return 3;

        if(temp[num] != 0) return temp[num];

        return temp[num] = (dp(num - 1) + 2 * dp(num - 2)) % 10007;
    }
}
