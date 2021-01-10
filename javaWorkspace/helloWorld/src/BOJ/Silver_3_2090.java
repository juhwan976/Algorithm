package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_2090 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int length;
    private static int nums[];
    private static long minSame;
    private static long result = 0;

    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(input.readLine());
        nums = new int[length];
        String data[] = input.readLine().split(" ");
        boolean flag = false;

        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(data[i]);
        }

        minSame = nums[0];

        for(int i = 1 ; i < nums.length ; i++) {
            minSame *= nums[i];
        }

        for(int i = 0 ; i < nums.length ; i++) {
            result += minSame/nums[i];
        }

        while(true) {
            for(long i = 2 ; i <= ((100>minSame)?minSame:100); i++) {
                if(minSame % i == 0 && result % i == 0) {
                    minSame /= i;
                    result /= i;
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                break;
            }
            else {
                flag = false;
            }
        }

        output.write(minSame + " " + result);

        output.flush();
        output.close();
        input.close();
    }
}
