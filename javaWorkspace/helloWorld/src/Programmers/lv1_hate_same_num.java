package Programmers;

import java.util.*;

public class lv1_hate_same_num {

    public static void main(String args[]) {
        int arr[] = { 4, 4, 4, 3, 3 };

        ArrayList<Integer> newArr = new ArrayList<>();
        int answer[];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                newArr.add(arr[i]);
            } else if (arr[i] != arr[i - 1]) {
                newArr.add(arr[i]);
            }
        }

        answer = new int[newArr.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = newArr.get(i);
        }

        System.out.println(answer);
    }
}
