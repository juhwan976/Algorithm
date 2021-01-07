package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinarySearch_test {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int targetNum = Integer.parseInt(input.readLine());

        output.write(binarySearch(arr, targetNum, 0, arr.length - 1) + "");

        output.flush();
        output.close();
        input.close();
    }

    public static int binarySearch(int arr[], int targetNum, int left, int right) {
        int mid = (right + left) / 2;

        if(arr[mid] == targetNum) {
            return mid;
        }
        else if(arr[mid] > targetNum) {
            right = mid - 1;
        }
        else if(arr[mid] < targetNum) {
            left = mid + 1;
        }

        return binarySearch(arr, targetNum, left, right);
    }
}
