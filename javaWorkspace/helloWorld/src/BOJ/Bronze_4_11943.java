package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze_4_11943 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String dataA[] = input.readLine().split(" ");
        String dataB[] = input.readLine().split(" ");

        int a[] = new int[2];
        int b[] = new int[2];

        for(int i = 0 ; i < 2 ; i++) {
            a[i] = Integer.parseInt(dataA[i]);
            b[i] = Integer.parseInt(dataB[i]);
        }

        int result = Math.min(a[0]+b[1],a[1]+b[0]);

        output.write(result + " ");
        
        input.close();
        output.flush();
        output.close();
    }
}
