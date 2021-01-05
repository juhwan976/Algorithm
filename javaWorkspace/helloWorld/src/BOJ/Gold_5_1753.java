package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Gold_5_1753 {
    static final int inf = Integer.MAX_VALUE;
    static int nodeNum;
    static int lineNum;
    static int initNode;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data1[] = input.readLine().split(" ");
        nodeNum = Integer.parseInt(data1[0]);
        lineNum = Integer.parseInt(data1[1]);
        initNode = Integer.parseInt(input.readLine());
        int table[][] = new int[nodeNum + 1][nodeNum + 1];
        int costs[] = new int[nodeNum + 1];
        boolean visited[] = new boolean[nodeNum + 1];
        PriorityQueue<Route> temp = new PriorityQueue<>(new ComparatorD());

        for(int i = 0 ; i < lineNum ; i++) {
            String data2[] = input.readLine().split(" ");
            if(table[Integer.parseInt(data2[0])][Integer.parseInt(data2[1])] != 0) {
                if(table[Integer.parseInt(data2[0])][Integer.parseInt(data2[1])] > Integer.parseInt(data2[2])) {
                    table[Integer.parseInt(data2[0])][Integer.parseInt(data2[1])] = Integer.parseInt(data2[2]);
                }
            }
            else {
                table[Integer.parseInt(data2[0])][Integer.parseInt(data2[1])] = Integer.parseInt(data2[2]);
            }
        }

        for(int i = 1 ; i <= nodeNum ; i++) {
            for(int j = 1 ; j <= nodeNum ; j++) {
                if(i == j) {

                }
                else if(i != j && table[i][j] == 0){
                    table[i][j] = inf;
                }
            }
        }

        dijkstra(table, costs, visited, temp, initNode);

        for(int i = 1 ; i < costs.length ; i++) {
            if(costs[i] == inf) {
                output.write("INF ");
            }
            else {
                output.write(costs[i] + " ");
            }
        }

        output.flush();
        output.close();
        input.close();
    }

    public static void dijkstra(int table[][], int costs[], boolean visited[], PriorityQueue<Route> temp, int start) {
        for(int i = 1 ; i < costs.length ; i++) {
            costs[i] = table[start][i];
        }
        temp.add(new Route(start, 0));

        do {
            Route r = temp.remove();
            int current = r.node;
            int distance = r.value;

            if(distance > costs[current]) {
                continue;
            }

            for(int i = 1 ; i < table[current].length ; i++) {
                if(table[current][i] != inf) {
                    int next = i;
                    int nextDistance = table[current][i] + distance;

                    if(nextDistance < costs[i]) {
                        costs[i] = nextDistance;
                        temp.add(new Route(next, nextDistance));
                    }
                }
            }

            for(int i = 1 ; i < costs.length ; i++) {
                if(costs[i] == inf) {
                    System.out.print("INF ");
                }
                else {
                    System.out.print(costs[i] + " ");
                }
            }
            System.out.println();
        } while(!temp.isEmpty());
    }
}

class Route {
    int node;
    int value;

    public Route(int node, int value) {
        this.node = node;
        this.value = value;
    }
}

class ComparatorD implements Comparator<Route> {
    @Override
    public int compare(Route a, Route b) {
        if(a.value > b.value) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
