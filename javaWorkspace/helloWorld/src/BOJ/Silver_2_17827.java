package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_2_17827 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data1[] = input.readLine().split(" ");

        int length = Integer.parseInt(data1[0]);
        int qlength = Integer.parseInt(data1[1]);
        int destination = Integer.parseInt(data1[2]);

        int arr[] = new int[length];
        String data2[] = input.readLine().split(" ");

        for(int i = 0 ; i < length ; i++) {
            arr[i] = Integer.parseInt(data2[i]);
        }

        for(int i = 0 ; i < qlength ; i++) {
            int cursor = 0;
            int move = Integer.parseInt(input.readLine());

            if(move >= destination) {
                cursor = (move - destination) % (length - 1 - (destination - 1) + 1) + destination;

                if(cursor == length)
                    cursor = destination - 1;
            }
            else {
                cursor = move;
            }

            output.write(arr[cursor] + "\n");
        }
        
        input.close();
        output.flush();
        output.close();

    }
}
