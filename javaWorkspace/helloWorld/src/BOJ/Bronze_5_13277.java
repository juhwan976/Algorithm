package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Bronze_5_13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data[] = input.readLine().split(" ");
        BigInteger num1 = new BigInteger(data[0]);
        BigInteger num2 = new BigInteger(data[1]);

        output.write(num1.multiply(num2) + "");

        output.flush();
        output.close();
        input.close();
    }
}