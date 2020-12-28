package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_4_1239 {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(input.readLine());
        String data[] = input.readLine().split(" ");
        int arr[] = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        permutation(arr, 0, length, length);

        output.write(max+ " ");
        output.flush();

        input.close();
        output.close();
    }

    public static void permutation(int arr[], int depth, int n, int r) {
        if (depth == r) {
            int count = 0;
            for(int i = 0 ; i < n ; i++) {
                int sum = 0;
                for(int j = i ; j < n ; j++) {
                    if(sum + arr[j] <= 50) {
                        sum += arr[j];
                        if(sum == 50) {
                            count++;
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
            }

            if(count != 0)
                count--;

            if(max < count) 
                max = count;

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            permutation(arr, depth + 1, n, r);
            swap(arr, i, depth);
        }

    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
