package GGo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String firstLine = input.readLine();
        int nodeNum = Integer.parseInt(firstLine.split(" ")[0]);
        int costNum = Integer.parseInt(firstLine.split(" ")[1]);

        boolean visited[] = new boolean[nodeNum + 1];
        int graph[][] = new int[nodeNum + 1][nodeNum + 1];
        
        for (int i = 0 ; i < costNum ; i++) {
            String data = input.readLine();
            graph[Integer.parseInt(data.split(" ")[0])][Integer.parseInt(data.split(" ")[1])] = Integer.parseInt(data.split(" ")[2]);
        }

        int result = 0;

        visited[1] = true;

        for (int i = 1 ; i <= nodeNum ; i++) {
            int minCost = Integer.MAX_VALUE;
            int minNode = i;

            for(int j = 1 ; j <= nodeNum ; j++) {
                if(graph[i][j] < minCost && graph[i][j] != 0) {
                    if(!visited[j]) {
                        minCost = graph[i][j];
                        minNode = j;
                    }
                }
            }

            if(minCost != Integer.MAX_VALUE && minCost != 0) {
                visited[minNode] = true;
                result += minCost;
            }
        }

        System.out.println(result);

        input.close();
        output.flush();
        output.close();
    }
}