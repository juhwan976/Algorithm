package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_4_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());

        for (int i = 0; i < length; i++) {
            String[] data = input.readLine().split(" ");
            int x1 = Integer.parseInt(data[0]);
            int y1 = Integer.parseInt(data[1]);
            int r1 = Integer.parseInt(data[2]);
            int x2 = Integer.parseInt(data[3]);
            int y2 = Integer.parseInt(data[4]);
            int r2 = Integer.parseInt(data[5]);
            double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
            int result = 0;

            int largeR = (r1 > r2) ? r1 : r2;
            int smallR = (r1 > r2) ? r2 : r1;

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    result = -1;
                } else {
                    result = 0;
                }
            } else {
                if (distance > largeR) {
                    if (distance < (r1 + r2)) {
                        result = 2;
                    } else if (distance == (r1 + r2)) {
                        result = 1;
                    } else {
                        result = 0;
                    }
                } else {
                    if (distance + smallR == largeR) {
                        result = 1;
                    } else if (distance + smallR > largeR) {
                        result = 2;
                    } else {
                        result = 0;
                    }
                }
            }
            output.write(result + "\n");
        }

        output.flush();
        output.close();
        input.close();
    }
}
