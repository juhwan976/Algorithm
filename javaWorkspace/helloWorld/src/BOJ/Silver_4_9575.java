package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_4_9575 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());

        for (int i = 0; i < length; i++) {
            int a[] = new int[Integer.parseInt(input.readLine())];
            String dataA[] = input.readLine().split(" ");
            for (int j = 0; j < a.length; j++) {
                a[j] = Integer.parseInt(dataA[j]);
            }
            int b[] = new int[Integer.parseInt(input.readLine())];
            String dataB[] = input.readLine().split(" ");
            for (int j = 0; j < b.length; j++) {
                b[j] = Integer.parseInt(dataB[j]);
            }
            int c[] = new int[Integer.parseInt(input.readLine())];
            String dataC[] = input.readLine().split(" ");
            for (int j = 0; j < c.length; j++) {
                c[j] = Integer.parseInt(dataC[j]);
            }
            int count = 0;
            int result[] = new int[a.length * b.length * c.length];
            boolean isThere = false;

            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < b.length; k++) {
                    for (int l = 0; l < c.length; l++) {
                        if (isLucky(a[j] + b[k] + c[l])) {
                            if (count == 0) {
                                result[count++] = a[j] + b[k] + c[l];
                            } else {
                                for (int m = 0; m < count; m++) {
                                    if (result[m] == a[j] + b[k] + c[l]) {
                                        isThere = true;
                                        break;
                                    }
                                }

                                if (isThere) {
                                    isThere = false;
                                } else {
                                    result[count] = a[j] + b[k] + c[l];
                                    count++;
                                }
                            }
                        }
                    }
                }
            }

            output.write((count) + "\n");
        }

        input.close();
        output.flush();
        output.close();
    }

    public static boolean isLucky(int num) {
        if (num < 10) {
            if (num == 5 || num == 8) {
                return true;
            }
            else {
                return false;
            }
        } else {
            if (num % 10 == 5 || num % 10 == 8) {
                if (isLucky(num / 10)) {
                    return true;
                } else
                    return false;
            } else
                return false;
        }
    }
}
