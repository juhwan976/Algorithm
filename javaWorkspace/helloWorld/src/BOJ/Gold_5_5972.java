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

public class Gold_5_5972 {
    private static final int INF = 1_000_000_000;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Node_5972> list[];
    private static int costs[];
    private static int nodeNum;
    private static int lineNum;
    private static int startNode = 1;
    private static int desNode;

    public static void main(String[] args) throws IOException {
        // 노드의 수, 명령행의 수 입력
        String data[] = input.readLine().split(" ");
        nodeNum = Integer.parseInt(data[0]);
        lineNum = Integer.parseInt(data[1]);
        desNode = nodeNum;

        // 배열 초기화
        costs = new int[nodeNum + 1];
        Arrays.fill(costs, INF);

        // 명령행 입력
        list = new ArrayList[nodeNum + 1];

        for(int i = 1 ; i <= nodeNum ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < lineNum ; i++) {
            String data1[] = input.readLine().split(" ");
            int start = Integer.parseInt(data1[0]);
            int end = Integer.parseInt(data1[1]);
            int cost = Integer.parseInt(data1[2]);

            list[start].add(new Node_5972(end, cost));
            list[end].add(new Node_5972(start, cost));
        }

        // 다익스트라 실행
        dijkstra();

        // 출력
        if(costs[desNode] == INF) {
            output.write("INF");
        }
        else {
            output.write(costs[desNode] + "");
        }

        output.flush();
        output.close();
        input.close();
    }

    public static void dijkstra() {
        PriorityQueue<Node_5972> pq = new PriorityQueue<>();
        costs[startNode] = 0;
        pq.add(new Node_5972(startNode, 0));

        while(!pq.isEmpty()) {
            Node_5972 node = pq.remove();
            int current = node.end;
            int distance = node.cost;

            if(costs[current] < distance) continue;

            for(int i = 0 ; i < list[current].size() ; i++) {
                Node_5972 nextNode = list[current].get(i);
                int next = nextNode.end;
                int nextDistance = distance + nextNode.cost;

                if(costs[next] > nextDistance) {
                    costs[next] = nextDistance;
                    pq.add(new Node_5972(next, nextDistance));
                }
            }
        }
    }
}

class Node_5972 implements Comparable<Node_5972> {
    int end;
    int cost;

    public Node_5972(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node_5972 a) {
        return Integer.compare(this.cost, a.cost);
    }
}
