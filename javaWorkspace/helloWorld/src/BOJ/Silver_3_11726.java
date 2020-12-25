package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_11726 {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());
        arr = new int[length + 1];

        output.write(Integer.toString(dp(length)));

        input.close();
        output.flush();
        output.close();
    }

    public static int dp(int num) {
        if(num == 1) return 1;
        if(num == 2) return 2;

        if(arr[num] != 0) return arr[num];

        return arr[num] = (dp(num - 1) + dp(num - 2)) % 10007;
    }
}
