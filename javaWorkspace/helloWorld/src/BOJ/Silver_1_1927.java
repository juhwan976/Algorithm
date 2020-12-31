package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Silver_1_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minqueue = new PriorityQueue<>();
        int length = Integer.parseInt(input.readLine());

        for(int i = 0 ; i < length ; i++) {
            int num = Integer.parseInt(input.readLine());
            if(num == 0) {
                if(minqueue.isEmpty()) {
                    output.write("0");
                }
                else {
                    output.write(minqueue.remove() + " ");
                }
                output.write("\n");
            }
            else {
                minqueue.add(num);
            }
        }

        output.flush();
        output.close();
        input.close();
    } 
}
