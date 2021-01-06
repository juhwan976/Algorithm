package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Gold_5_1916 {
    private static final int INF = 1_000_000_000;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Node_1916> list[];
    private static int costs[];
    private static int nodeNum;
    private static int lineNum;
    private static int initNode;
    private static int destinationNode;

    public static void main(String[] args) throws IOException {
        nodeNum = Integer.parseInt(input.readLine());
        lineNum = Integer.parseInt(input.readLine());

        // 리스트 초기화
        list = new ArrayList[nodeNum + 1];
        for(int i = 1 ; i <= nodeNum ; i++) {
            list[i] = new ArrayList<>();
        }

        // 코스트 초기화
        costs = new int[nodeNum + 1];
        for(int i = 1 ; i <= nodeNum ; i++) {
            costs[i] = INF;
        }

        // 경로 입력
        for(int i = 0 ; i < lineNum ; i++) {
            String data[] = input.readLine().split(" ");
            int start = Integer.parseInt(data[0]);
            int end = Integer.parseInt(data[1]);
            int cost = Integer.parseInt(data[2]);

            list[start].add(new Node_1916(end, cost));
        }

        // 시작노드, 도착노드 입력
        String data1[] = input.readLine().split(" ");
        initNode = Integer.parseInt(data1[0]);
        destinationNode = Integer.parseInt(data1[1]);

        // 다익스트라 실행
        dijkstra();

        // 결과값 출력
        if(costs[destinationNode] == INF) {
            output.write("INF");
        }
        else {
            output.write(costs[destinationNode] + "");
        }

        output.flush();
        output.close();
        input.close();
    }

    public static void dijkstra() {
        PriorityQueue<Node_1916> pq = new PriorityQueue<>();
        costs[initNode] = 0;
        pq.add(new Node_1916(initNode, 0));

        while(!pq.isEmpty()) {
            Node_1916 node = pq.remove();
            int current = node.node;
            int distance = node.cost;

            if(costs[current] < distance) continue;

            for(int i = 0 ; i < list[current].size() ; i++) {
                Node_1916 nextNode = list[current].get(i);
                int next = nextNode.node;
                int nextDistance = nextNode.cost + distance;

                if(costs[next] > nextDistance) {
                    costs[next] = nextDistance;
                    pq.add(new Node_1916(next, nextDistance));
                }
            }
        }
    }
}

class Node_1916 implements Comparable<Node_1916> {
    int node;
    int cost;

    public Node_1916(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node_1916 a) {
        return Integer.compare(this.cost, a.cost);
    }
}
