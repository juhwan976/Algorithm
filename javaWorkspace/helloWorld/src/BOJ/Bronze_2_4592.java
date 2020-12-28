package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze_2_4592 {
    public static void main(String[] agrgs) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String data = input.readLine();

            if (data.charAt(0) == '0')
                break;

            String splitdata[] = data.split(" ");

            int arr[] = new int[Integer.parseInt(splitdata[0])];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(splitdata[i + 1]);

                if (i != 0) {
                    if (arr[i - 1] != arr[i]) {
                        output.write(arr[i] + " ");
                    }
                } else {
                    output.write(arr[i] + " ");
                }
            }

            output.write("$ \n");
            output.flush();
        }

        input.close();
        output.close();
    }
}
