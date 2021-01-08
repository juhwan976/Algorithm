package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Silver_1_1932 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> list[];
    static int result[][];
    static int length;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(input.readLine());

        list = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            list[i] = new ArrayList<>();
        }

        result = new int[length][length];

        for (int i = 0; i < length; i++) {
            String data[] = input.readLine().split(" ");

            for (int j = 0; j < data.length; j++) {
                list[i].add(Integer.parseInt(data[j]));
            }
        }

        for (int i = 0; i < list[length - 1].size(); i++) {
            max = (dp(length - 1, i) > max) ? (dp(length - 1, i)) : max;
        }

        output.write(max+ "");

        output.flush();
        output.close();
        input.close();
    }

    public static int dp(int row, int pos) {
        if (row == 0) {
            return list[0].get(0);
        }

        if (result[row][pos] != 0) {
            return result[row][pos];
        }

        if (pos == row) {
            return result[row][pos] = dp(row - 1, pos - 1) + list[row].get(pos);
        } else if (pos == 0) {
            return result[row][pos] = dp(row - 1, pos) + list[row].get(pos);
        } else {
            return result[row][pos] = Math.max(dp(row - 1, pos), dp(row - 1, pos - 1)) + list[row].get(pos);
        }
    }
}
