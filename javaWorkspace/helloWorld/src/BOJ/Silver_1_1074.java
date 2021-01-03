package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_1_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String nums[] = input.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int r = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);

        int result = doitZ(n, r, c);

        output.write(result + " ");
        
        output.flush();
        output.close();
        input.close();
    }

    public static int doitZ(int n, int r, int c) {
        int base = 0;
        int rbase = 0;
        int cbase = 0;
        int num = (int) Math.pow(2, n);

        if(n == 1) {
            if(r == 0 && c == 0) {
                return 0;
            }
            else if(r == 0 && c == 1) {
                return 1;
            }
            else if(r == 1 && c == 0) {
                return 2;
            }
            else {
                return 3;
            }
        }

        if(r >= num / 2) {
            rbase = 1;
        }

        if(c >= num / 2) {
            cbase = 1;
        }

        if(rbase == 0 && cbase == 0) {}
        else if(rbase == 1 && cbase == 0) {
            r -= num / 2;
            base += num * num / 4 * 2;
        }
        else if(rbase == 0 && cbase == 1) {
            c -= num / 2;
            base += num * num / 4;
        }
        else {
            r -= num / 2;
            c -= num / 2;
            base += num * num / 4 * 3;
        }

        return base + doitZ(n - 1, r, c);
    }
}
