package test;

import java.util.Scanner;

public class Combination_test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int arr[] = new int[num];
        boolean visited[] = new boolean[num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }

        for(int i = 1 ; i <= num/2 ; i++) {
            combination(arr, visited, 0, num, i);
        }
    }

    public static void combination(int arr[], boolean visited[], int depth, int n, int r) {
        if (r == 0) {
            for(int i = 0 ; i < n ; i++) {
                if(visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return; 
        }

        if (depth == n)
            return;

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n , r);
    }
}
