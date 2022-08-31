package GGo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String data1 = input.readLine();
        int nodeNum = Integer.parseInt(data1.split(" ")[0]);
        int lineNum = Integer.parseInt(data1.split(" ")[1]);
        int W[][] = new int[nodeNum + 1][nodeNum + 1];
        
        for(int i = 0 ; i < nodeNum + 1 ; i++) {
            for(int j = 0 ; j < nodeNum + 1 ;  j++) {
                W[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0 ; i < lineNum ; i++) {
            String data2 = input.readLine();
            W[Integer.parseInt(data2.split(" ")[0])][Integer.parseInt(data2.split(" ")[1])] = Integer.parseInt(data2.split(" ")[2]);
            W[Integer.parseInt(data2.split(" ")[1])][Integer.parseInt(data2.split(" ")[0])] = Integer.parseInt(data2.split(" ")[2]);
        }

        boolean visited[] = new boolean[nodeNum + 1];

        visited[1] = true;

        

        input.close();
        output.flush();
        output.close();
    }
}
