package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_2606 {
    public static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int nodeNum;
    public static boolean visited[];
    public static int lineNum;
    public static int lines[][];
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        nodeNum = Integer.parseInt(input.readLine());
        visited = new boolean[nodeNum + 1];

        lineNum = Integer.parseInt(input.readLine());
        lines = new int[lineNum][2];

        for(int i = 0 ; i < lineNum ; i++) {
            String data[] = input.readLine().split(" ");

            lines[i][0] = Integer.parseInt(data[0]);
            lines[i][1] = Integer.parseInt(data[1]);
        }

        dps(1);

        output.write((count - 1) + "");

        output.flush();
        output.close();
        input.close();
    }

    public static void dps(int start) {
        if(visited[start]) {
            return;
        } 
        else {
            visited[start] = true;
            count++;
        }

        for(int i = 0 ; i < lineNum ; i++) {
            if(lines[i][0] == start) {
                dps(lines[i][1]);
            }
            else if(lines[i][1] == start) {
                dps(lines[i][0]);
            }
        }
    }
}
