package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = input.readLine();
        int countRight = 0;
        int need = 0;

        for(int i = 0 ; i < data.length() ; i++) {
            if(data.charAt(i) == ')') {
                if(countRight - 1 >= 0) {
                    countRight -= 1;
                    need -= 1;
                }
                else {
                    need += 1;
                }
            }
            else if(data.charAt(i) == '(') {
                countRight++;
                need++;
            }
        }

        output.write(need + " ");
        output.flush();

        input.close();
        output.close();
    }
}
