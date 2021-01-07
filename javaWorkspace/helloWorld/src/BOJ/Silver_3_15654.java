package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Silver_3_15654 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int numlength;
    private static int selectNum;
    private static int nums[];
    private static int result[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        String data1[] = input.readLine().split(" ");
        numlength = Integer.parseInt(data1[0]);
        selectNum = Integer.parseInt(data1[1]);
        nums = new int[numlength];
        visited = new boolean[numlength];
        result = new int[numlength];

        String data2[] = input.readLine().split(" ");
        for (int i = 0; i < numlength; i++) {
            pq.add(Integer.parseInt(data2[i]));
        }

        for (int i = 0; i < numlength; i++) {
            nums[i] = pq.remove();
        }

        permutation(numlength, selectNum, 0);

        output.flush();
        output.close();
        input.close();
    }

    public static void permutation(int n, int r, int depth) throws IOException {
        if(depth == r) {
            for(int i = 0 ; i < r ; i++) {
                output.write(result[i] + " ");
            }
            output.write("\n");
        }

        for(int i = 0 ; i < n ; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                result[depth] = nums[i];
                permutation(n, r, depth + 1);
                visited[i] = false;
            }
        }
    }
}
