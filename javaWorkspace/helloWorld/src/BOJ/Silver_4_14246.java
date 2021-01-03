package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_4_14246 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());
        int nums[] = new int[length];
        long result = 0;

        String data[] = input.readLine().split(" ");

        for(int i = 0 ; i < length ; i++) {
            nums[i] = Integer.parseInt(data[i]);
        }   

        int target = Integer.parseInt(input.readLine());

        for(int i = 0 ; i < length ; i++) {
            long sum = 0;
            int index = 0;
            boolean flag = false;

            for(int j = i ; j < length ; j++) {
                sum += nums[j];
                if(sum > target) {
                    index = j;
                    flag = true;
                    break;
                }
            }

            if(flag) {
                result += length - index;
            }
        }

        output.write(result + " ");

        output.flush();
        output.close();
        input.close();
    }
}
