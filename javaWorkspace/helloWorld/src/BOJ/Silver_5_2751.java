package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_5_2751 {
    static int length;
    static int temp[];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        length = Integer.parseInt(input.readLine());
        int[] arr = new int[length];
        temp = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        divide(arr, 0, arr.length - 1);

        for (int i = length - 1; i >= 0; i--) {
            output.write(arr[i] + "\n");
        }

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
            if (arr[L] <= arr[R])
                temp[k++] = arr[R++];
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
