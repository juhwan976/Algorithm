package BOJ;

import java.util.Scanner;

public class Silver_3_2346 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int cursor = 0;
        int remain = 0;
        int value = 0;
        int arr[] = new int[length];
        boolean arrb[] = new boolean[length];

        for (value = 0; value < length; value++) {
            arr[value] = input.nextInt();
        }

        value = 0;

        while (true) {
            if (value++ == length) {
                break;
            }

            arrb[cursor] = true;
            System.out.print(cursor + 1 + " ");
            remain = arr[cursor];

            while (true) {
                if (remain == 0 || value == length)
                    break;
                else if (remain > 0) {
                    if (++cursor == length)
                        cursor = 0;

                    if (arrb[cursor] == true) {
                    } else {
                        remain--;
                    }
                } else {
                    if (--cursor == -1) {
                        cursor = length - 1;
                    }

                    if (arrb[cursor] == true) {
                    } else
                        remain++;

                }
            }
        }

        input.close();
    }
}
