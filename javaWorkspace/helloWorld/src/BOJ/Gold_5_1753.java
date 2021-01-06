package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Gold_5_1753 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 2_000_000_000;
    static List<Node_1753> list[];

    public static void main(String[] args) throws IOException {
        String data1[] = input.readLine().split(" ");
        int nodeNum = Integer.parseInt(data1[0]);
        int lineNum = Integer.parseInt(data1[1]);
        int initNode = Integer.parseInt(input.readLine());
        int costs[] = new int[nodeNum + 1];

        list = new ArrayList[nodeNum + 1];
        for(int i = 1 ; i <= nodeNum ; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(costs, INF);

        for(int i = 0 ; i < lineNum ; i++) {
            String data2[] = input.readLine().split(" ");
            int start = Integer.parseInt(data2[0]);
            int end = Integer.parseInt(data2[1]);
            int cost = Integer.parseInt(data2[2]);

            list[start].add(new Node_1753(end, cost));
        }

        dijkstra(list, costs, initNode);

        for(int i = 1 ; i <= nodeNum ; i++) {
            if(costs[i] == INF) {
                output.write("INF");
            }
            else {
                output.write(costs[i] + "");
            }

            output.write("\n");
        }

        output.flush();
        output.close();
        input.close();
    }

    public static void dijkstra(List<Node_1753> list[], int costs[], int initNode) {
        PriorityQueue<Node_1753> queue = new PriorityQueue<>();

        costs[initNode] = 0;
        queue.add(new Node_1753(initNode, 0));

        while(!queue.isEmpty()) {
            Node_1753 node = queue.remove();
            int current = node.end;
            int distance = node.value;

            if(costs[current] < distance) continue;

            for(int i = 0 ; i < list[current].size() ; i++) {
                Node_1753 nextNode = list[current].get(i);
                int next = nextNode.end;
                int nextDistance = distance + nextNode.value;

                if(costs[next] > nextDistance) {
                    costs[next] = nextDistance;
                    queue.add(new Node_1753(next, nextDistance));
                }
            }
        }

    }
}

class Node_1753 implements Comparable<Node_1753> {
    int end;
    int value;

    public Node_1753(int end, int value) {
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Node_1753 a) {
        return Integer.compare(this.value, a.value);
    }
}