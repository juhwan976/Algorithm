package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_5_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data[] = input.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int d = Integer.parseInt(data[1]);
        int k = Integer.parseInt(data[2]);
        int c = Integer.parseInt(data[3]);
        int nums[] = new int[n];
        int visited[] = new int[d + 1];
        int max = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input.readLine());
        }

        for (int i = 0; i < k; i++) {
            if (visited[nums[i]] == 0) {
                total++;
            }
            visited[nums[i]]++;
        }

        max = total;

        for (int i = 1; i < n; i++) {
            if (max <= total) {
                if (visited[c] == 0) {
                    max = total + 1;
                } else {
                    max = total;
                }
            }

            visited[nums[i - 1]]--;
            if (visited[nums[i - 1]] == 0) {
                total--;
            }

            if (visited[nums[(i + k - 1) % n]] == 0) {
                total++;
            }
            visited[nums[(i + k - 1) % n]]++;

        }

        output.write(max + " ");

        output.flush();
        output.close();
        input.close();

    }
}
