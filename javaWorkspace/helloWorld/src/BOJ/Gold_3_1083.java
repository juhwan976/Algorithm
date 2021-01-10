package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_3_1083 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int length;
    private static int arr[];
    private static int count;
    private static int max = 0;
    private static int pos = 0;
    private static int value = 0;

    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(input.readLine());
        arr = new int[length];

        String data[] = input.readLine().split(" ");
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        count = Integer.parseInt(input.readLine());

        while (count != 0) {
            if(value >= length) {
                break;
            }

            max = 0;
            pos = 0;

            if((count + value) >= length) {
                for(int i = value ; i < length ; i++) {
                    if(max < arr[i]) {
                        pos = i;
                        max = arr[i];
                    }
                }
            }
            else {
                for(int i = value ; i <= count + value ; i++) {
                    if(max < arr[i]) {
                        pos = i;
                        max = arr[i];
                    }
                }
            }

            if(max == arr[value]) {
                value++;
                continue;
            }

            int temp = arr[pos];
            for(int i = pos - 1 ; i >= value ; i--) {
                arr[i+1] = arr[i];
            }
            arr[value] = temp;
            count -= (pos - value);
            value++;
        }

        for (int i = 0; i < length; i++) {
            output.write(arr[i] + " ");
        }

        output.flush();
        output.close();
        input.close();
    }
}
