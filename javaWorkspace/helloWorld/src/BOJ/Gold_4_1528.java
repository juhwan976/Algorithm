package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Gold_4_1528 {
    static int temp[];
    static int value[];
    final static int lucky[] = { 4, 7, 
            44, 47, 74, 77, 
            444, 447, 474, 477, 744, 747, 774, 777, 
            4444, 4447, 4474, 4477, 4744, 4747, 4774, 4777, 7444, 7447, 7474, 7477, 7744, 7747, 7774, 7777, 
            44444, 44447, 44474, 44477, 44744, 44747, 44774, 44777, 47444, 47447, 47474, 47477, 47744, 47747, 47774, 47777,
            74444, 74447, 74474, 74477, 74744, 74747, 74774, 74777, 77444, 77447, 77474, 77477, 77744, 77747, 77774, 77777, 
            444444, 444447, 444474, 444477, 444744, 444747, 444774, 444777, 447444, 447447, 447474, 447477, 447744, 447747, 447774, 447777,
            474444, 474447, 474474, 474477, 474744, 474747, 474774, 474777, 477444, 477447, 477474, 477477, 477744, 477747, 477774, 477777,
            744444, 744447, 744474, 744477, 744744, 744747, 744774, 744777, 747444, 747447, 747474, 747477, 747744, 747747, 747774, 747777,
            774444, 774447, 774474, 774477, 774744, 774747, 774774, 774777, 777444, 777447, 777474, 777477, 777744, 777747, 777774, 777777};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int num = Integer.parseInt(input.readLine());
        temp = new int[num + 1];
        value = new int[num + 1];
        int result = dp(num);
        //output.write(result + "\n");

        if (result != -1) {
            print(queue, num);

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                output.write(queue.remove() + " ");
            }
        } else {
            output.write("-1");
        }

        output.flush();
    }

    public static int dp(int num) {
        if (num <= 7) {
            if (num == 4) {
                value[num] = 4;
                return 1;
            } else if (num == 7) {
                value[num] = 7;
                return 1;
            } else {
                return -1;
            }
        }

        if (temp[num] != 0) {
            return temp[num];
        }

        if (isGold(num)) {
            value[num] = num;
            return temp[num] = 1;
        }

        boolean flag = false;
        int goldnum = 0;
        int min = num;

        for (int i = lucky.length - 1; i >= 0; i--) {
            if(lucky[i] <= num) {
                int tp = dp(num - lucky[i]);
                if (tp != -1 && min >= (tp + 1)) {
                    flag = true;
                    goldnum = lucky[i];
                    min = tp + 1;
                }
            }    
        }

        if (flag) {
            value[num] = goldnum;
            return temp[num] = dp(num - goldnum) + 1;
        } else {
            return temp[num] = -1;
        }
    }

    public static boolean isGold(int num) {
        if (num % 10 == 4 || num % 10 == 7) {
            if (num <= 10) {
                return true;
            } else {
                return isGold(num / 10);
            }
        } else {
            return false;
        }
    }

    public static void print(PriorityQueue<Integer> queue, int num) {
        if (num == 0)
            return;

        queue.add(value[num]);
        print(queue, num - value[num]);
    }
}
