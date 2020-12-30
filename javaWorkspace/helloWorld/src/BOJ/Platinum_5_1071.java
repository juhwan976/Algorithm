package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Platinum_5_1071 {
    static int temp[];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());
        String data[] = input.readLine().split(" ");
        int num[] = new int[length];
        temp = new int[length];
        boolean flag = false;
        boolean flag1 = false;

        for (int i = 0; i < length; i++) {
            num[i] = Integer.parseInt(data[i]);
        }

        divide(num, 0, length - 1);

        while(true) {
            for (int i = length - 1; i > 0; i--) {
                if (num[i] - 1 == num[i - 1]) {
                    flag1 = true;
                    flag = false;
                    boolean flag2 = false;
                    int j = i - 1;
                    while (true) {
                        int temp = num[j];
                        num[j] = num[j + 1];
                        num[j + 1] = temp;
    
                        j--;
    
                        if ((j > 0 ) && num[j] - 1 == num[j - 1]) {
                            /* do nothing */
                        } else {
                            flag2 = true;
                        }
    
                        if (flag2)
                            break;
                    }
                } else {

                }
            }

            if(flag1 == true) {
                flag1 = false;
                flag = true;
            }
            else if(flag1 == false) {
                if(flag == true)
                    break;
            }
        }
        

        for (int i = 0; i < length; i++) {
            output.write(num[i] + " ");
        }

        output.flush();
        output.close();
        input.close();
    }

    public static void divide(int arr[], int left, int right) {
        if (left == right)
            return;

        int mid = (right + left) / 2;

        divide(arr, left, mid);
        divide(arr, mid + 1, right);
        merge(arr, left, right);
    }

    public static void merge(int arr[], int left, int right) {
        int mid = (right + left) / 2;
        int L = left, R = mid + 1, count = left;

        while (L <= mid && R <= right) {
            temp[count++] = (arr[L] > arr[R]) ? arr[R++] : arr[L++];
        }

        if (L > mid) {
            for (int i = R; i <= right; i++) {
                temp[count++] = arr[i];
            }
        } else {
            for (int i = L; i <= mid; i++) {
                temp[count++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

    }
}
