package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Platinum_5_1572 {
    static int temp[];
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();

        String temp = input.readLine();

        int arrSize = Integer.parseInt(temp.split(" ")[0]);
        int windowSize = Integer.parseInt(temp.split(" ")[1]);
        int tempNum;
        int removeNum;
        boolean isFirst = true;

        long result = 0;

        for(int i = 0 ; i < arrSize ; i++) {
            tempNum = Integer.parseInt(input.readLine());

            if(queue.size() < windowSize) {
                queue.add(tempNum);
            }
            else if(queue.size() == windowSize && isFirst) {
                isFirst = false;
                // 정렬

                // 중앙 값 찾기
                // 1 ~ N 의 배열애서 (N + 1) / 2 번째의 수

                // result에 중앙값 더하기
            }
            else {
                removeNum = queue.poll();
                queue.add(tempNum);

                // 이분 탐색으로 해당 수 끼워넣기

                // 중앙 값 찾기
                // 1 ~ N 의 배열에서 (N + 1) / 2 번째의 수

                // result에 중앙값 더하기
            }
        }

        input.close();
        output.close();
    }
}