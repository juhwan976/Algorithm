package BOJ;

import java.util.Scanner;

public class Silver_3_1817 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = Integer.parseInt(input.next());
        int max = Integer.parseInt(input.next());
        int arr[] = new int[length];
        int box[] = new int[length];
        int boxNum = 0;

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(input.next());
            box[i] = 0;
        }

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if(arr[i] == 0) {}
                else {
                    box[0] += arr[i];
                    boxNum++;
                }
            } else {
                for (int j = 0; j < boxNum; j++) {
                    if (max < (box[j] + arr[i]) || (max / 2) <= (box[j] + arr[i])) {
                        if (box[j + 1] != 0) {
                            /* do noting */
                        } else {
                            boxNum++;
                            box[j + 1] = arr[i];
                            break;
                        }
                    } else {
                        box[j] += arr[i];
                        break;
                    }
                }
            }
        }

        System.out.println(boxNum);
    }
}