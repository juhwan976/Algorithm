package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_15650 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int targetNum;
    private static int selectNum;
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        // 끝 숫자와 몇개 고를건지 입력받음
        String data[] = input.readLine().split(" ");
        targetNum = Integer.parseInt(data[0]);
        selectNum = Integer.parseInt(data[1]);
        visited = new boolean[targetNum + 1];

        // 조합 실행
        combination(targetNum, selectNum, 0);

        output.flush();
        output.close();
        input.close();
    }

    public static void combination(int n, int r, int depth) throws IOException{
        if(r == 0) {
            for(int i = 0 ; i < visited.length ; i++) {
                if(visited[i]) {
                    output.write((i + 1) + " ");
                }
            }
            output.write("\n");
            return;
        }

        if(n == depth) {
            return;
        }

        visited[depth] = true;
        combination(n, r-1, depth + 1);

        visited[depth] = false;
        combination(n, r, depth + 1);
    }
}
