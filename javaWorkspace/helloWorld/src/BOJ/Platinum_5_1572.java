package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Platinum_5_1572 {
    static int temp[];
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String data[] = input.readLine().split(" ");
        int arrLength = Integer.parseInt(data[0]);
        int partLength = Integer.parseInt(data[1]);
        long result = 0;
        int count = 0;

        int arr[] = new int[arrLength];
        temp = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        divide(arr, 0, arrLength - 1);

        for(int i = ((partLength - 1) / 2) ; (i - ((partLength - 1) / 2)) != (arrLength - partLength + 1) ; i++) {
            result += arr[i];
            count++;
        }

        output.write(Long.toString(result) + " " + count);

        input.close();
        output.flush();
        output.close();
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
        int L = left;
        int R = mid + 1;
        int index = left;

        while(L <= mid && R <= right) {
            temp[index++] = (arr[L] > arr[R])? arr[R++] : arr[L++];
        }

        if(L > mid) {
            for(int i = R ; i <= right ; i++) {
                temp[index++] = arr[i];
            }
        }
        else {
            for(int i = L ; i <= mid ; i++) {
                temp[index++] = arr[i];
            }
        }

        for(int i = left ; i <= right ; i++) {
            arr[i] = temp[i];
        }
    }
}