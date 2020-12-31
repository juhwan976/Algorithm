package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Silver_2_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> maxqueue = new PriorityQueue<>(Collections.reverseOrder());
        int length = Integer.parseInt(input.readLine());

        for(int i = 0 ; i < length ; i++) {
            int num = Integer.parseInt(input.readLine());
            if(num == 0) {
                if(maxqueue.isEmpty()) {
                    output.write("0");
                }
                else {
                    output.write(maxqueue.remove() + " ");
                }
                output.write("\n");
            }
            else {
                maxqueue.add(num);
            }
        }

        output.flush();
        output.close();
        input.close();
    }
}
