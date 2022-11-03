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
        int num[] = new int[arrLength];
        temp = new int[arrLength];
        long result = 0;

        for(int i = 0 ; i < arrLength ; i++) {
            num[i] = Integer.parseInt(input.readLine());
        }

        divide(num, 0, num.length - 1);

        int base = (partLength - 1) / 2;

        for(int i = 0 ; i < (arrLength - partLength + 1) ; i++) {
            result += num[i + base];
        }

        output.write(Long.toString(result));

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