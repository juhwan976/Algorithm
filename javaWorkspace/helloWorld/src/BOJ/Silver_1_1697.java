package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Silver_1_1697 {
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data[] = input.readLine().split(" ");
        int start = Integer.parseInt(data[0]);
        int end = Integer.parseInt(data[1]);
        int temp[] = new int[100000 + 10];

        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> depth = new ArrayDeque<>();

        deque.addLast(start);
        depth.addLast(0);

        if (start >= end) {
            min = start - end;
        } else {
            while (true) {
                if (deque.isEmpty()) {
                    break;
                }

                int num = deque.removeFirst();
                int deep = depth.removeFirst();

                if (num > end + 1) {
                } else if (num < 0) {
                } else {
                    if (num * 2 == end) {
                        min = deep + 1;
                        break;
                    } else if (num + 1 == end) {
                        min = deep + 1;
                        break;
                    } else if (num - 1 == end) {
                        min = deep + 1;
                        break;
                    } else {
                        if (num * 2 <= 100000 && temp[num * 2] == 0) {
                            temp[num * 2] = 1;
                            deque.addLast(num * 2);
                            depth.addLast(deep + 1);
                        }

                        if (num + 1 <= 100000 && temp[num + 1] == 0) {
                            temp[num + 1] = 1;
                            deque.addLast(num + 1);
                            depth.addLast(deep + 1);
                        }

                        if (num - 1 >= 0 && temp[num - 1] == 0) {
                            temp[num - 1] = 1;
                            deque.addLast(num - 1);
                            depth.addLast(deep + 1);
                        }
                    }
                }
            }
        }

        output.write(min + " ");

        output.flush();
        output.close();
        input.close();
    }
}
