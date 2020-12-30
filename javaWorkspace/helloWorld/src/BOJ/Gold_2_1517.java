package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_2_1517 {
    static long result = 0;
    static int temp[];
    public static void main(String[] arge) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(input.readLine());
        int arr[] = new int[length];
        temp = new int[length];
        String numbers[] = input.readLine().split(" ");

        for(int i = 0 ; i < length ; i++) {
            int num = Integer.parseInt(numbers[i]);
            arr[i] = num;
        }

        divide(arr, 0, length - 1);

        output.write(result + " ");

        input.close();
        output.flush();
        output.close();
    }

    public static void divide(int[] arr, int left, int right) {
        if (left == right)
            return;
        int mid = (right + left) / 2;

        divide(arr, left, mid);
        divide(arr, mid + 1, right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int L = left, R = mid + 1;
        int k = left;

        while (L <= mid && R <= right) {
            if (arr[L] > arr[R]) {
                result += R - k;
                temp[k++] = arr[R++];
            }
            else
                temp[k++] = arr[L++];
        }

        if (L > mid) {
            for (int a = R; a <= right; a++) {
                temp[k++] = arr[a];
            }
        } else {
            for (int a = L; a <= mid; a++) {
                temp[k++] = arr[a];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
