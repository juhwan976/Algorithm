package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_4_1337 {
    private final static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int length;
    private static int arr[];
    private static int temp[];
    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(input.readLine());
        arr = new int[length];
        temp = new int[length];

        for(int i = 0 ; i < length ; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        
        divide(arr, 0, length - 1);

        int count = 1;
        int max = 1;
        int index = 0;
        for(int i = 1 ; i < length ; i++) {

            count++;
            
            while(arr[index] - arr[i] > 4) {
                index++;
                count--;
            }

            max = Math.max(max, count);
        }

        if(max > 5) max = 5;
        output.write((5 - max) + "");

        output.flush();


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
