package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_2_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data = input.readLine().split(" ");
        int min = Integer.parseInt(data[0]);
        int max = Integer.parseInt(data[1]);
        boolean isNprime = false;

        for(long i = min ; i <= max ; i++) {
            for(long j = 2 ; (j * j) <= i ; j++) {
                if(i % j == 0 && i / j != 1) {
                    isNprime = true;
                    break;
                }
            }

            if(!isNprime && i != 1) {
                output.write(i + "\n");
            }
            else
                isNprime = false;
        }

        input.close();
        output.flush();
        output.close();
    }
}
