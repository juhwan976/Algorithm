package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_4_1744 {
    private final static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int arr[];
    private static int temp[];
    private static boolean isUsed[];
    private static int length;

    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(input.readLine());
        arr = new int[length];
        temp = new int[length];
        isUsed = new boolean[length];

        int result = 0;

        for(int i = 0 ; i < length ; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        divide(arr, 0, length - 1);

        for(int i = 0 ; i < length ; i++) {
            if(i == length - 1) {

            }
            else {
                if(arr[i] <= 0 && arr[i + 1] <= 0 && !isUsed[i] && !isUsed[i + 1]) {
                    result += arr[i] * arr[i + 1];
                    isUsed[i] = true;
                    isUsed[i + 1] = true;
                }
    
                if(arr[i + 1] > 0) {
                    break;
                }
            }
        }

        for(int i = length - 1 ; i >= 0 ; i--) {
            if(i == 0) {

            }
            else {
                if(arr[i] == 1 || arr[i - 1] == 1) {}
                else {
                    if(arr[i] > 0 && arr[i - 1] > 0 && !isUsed[i] && !isUsed[i - 1]) {
                        result += arr[i] * arr[i - 1];
                        isUsed[i] = true;
                        isUsed[i - 1] = true;
                    }
        
                    if(arr[i - 1] <= 0)
                        break;
                }
            }
        }

        for(int i = 0 ; i < length ; i++) {
            if(!isUsed[i]) {
                result += arr[i];
            }
        }

        output.write(result+"");

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
            if (arr[L] >= arr[R])
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
