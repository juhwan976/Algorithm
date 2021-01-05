package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Silver_3_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        int length = Integer.parseInt(input.readLine());
        String data[] = input.readLine().split(" ");

        for(int i = 0 ; i < length ; i++) {
            temp.add(Integer.parseInt(data[i]));
        }

        int sum = 0;
        int before = 0;

        for(int i = 0 ; i < length ; i++) {
            before += temp.remove();
            sum += before;
        }

        output.write(sum+ " ");

        output.flush();
        output.close();
        input.close();
    }
}
