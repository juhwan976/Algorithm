package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_3_1132 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int weight[] = new int[10];
    private static int match[] = new int[10];
    private static int first[] = new int[10];
    private static boolean visited[] = new boolean[10];
    private static int length;
    private static String data[];
    private static long result = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(input.readLine());
        data = new String[length];

        for (int i = 0; i < length; i++) {
            String str = input.readLine();
            data[i] = str;

            for (int j = 0; j < str.length(); j++) {
                int vip = str.length() - j;
                int target = 0;

                switch (str.charAt(j)) {
                    case 'A':
                        target = 0;
                        break;
                    case 'B':
                        target = 1;
                        break;
                    case 'C':
                        target = 2;
                        break;
                    case 'D':
                        target = 3;
                        break;
                    case 'E':
                        target = 4;
                        break;
                    case 'F':
                        target = 5;
                        break;
                    case 'G':
                        target = 6;
                        break;
                    case 'H':
                        target = 7;
                        break;
                    case 'I':
                        target = 8;
                        break;
                    case 'J':
                        target = 9;
                        break;
                    default:
                        break;
                }

                if (j == 0) {
                    first[target]++;
                }

                weight[target] += vip;
            }
        }

        for (int i = 0; i < weight.length; i++) {
            if (weight[i] == 0) {
                flag = true;
                break;
            }
        }

        if (true) {
            int maxvalue = 9;

            while (maxvalue >= 0) {
                int max = 0;
                int maxIndex = 0;
                int maxFirst = 0;

                for (int i = 0; i < weight.length; i++) {
                    if (weight[i] > max && !visited[i] && maxFirst <= first[i]) {
                        max = weight[i];
                        maxIndex = i;
                    }
                }

                if (!visited[maxIndex]) {
                    match[maxIndex] = maxvalue--;
                    visited[maxIndex] = true;
                }
                else {
                    maxvalue--;
                }
            }

        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length(); j++) {
                int target = 0;

                switch (data[i].charAt(j)) {
                    case 'A':
                        target = 0;
                        break;
                    case 'B':
                        target = 1;
                        break;
                    case 'C':
                        target = 2;
                        break;
                    case 'D':
                        target = 3;
                        break;
                    case 'E':
                        target = 4;
                        break;
                    case 'F':
                        target = 5;
                        break;
                    case 'G':
                        target = 6;
                        break;
                    case 'H':
                        target = 7;
                        break;
                    case 'I':
                        target = 8;
                        break;
                    case 'J':
                        target = 9;
                        break;
                    default:
                        break;
                }


                result += match[target] * Math.pow(10, data[i].length() - j - 1);
            }
        }

        output.write(result +"\n");

        for(int i = 0 ; i < match.length ; i++) {
            output.write(match[i] + " ");
        }

        output.flush();
        output.close();
        input.close();
    }
}
