package Programmers;

public class lv1_add_missing_num {
    public static void main(String args[]) {
        int numbers[] = { 5, 8, 4, 0, 6, 7, 9 };

        int answer = 0;

        boolean nums[] = new boolean[10];

        for (int i = 0; i < numbers.length; i++) {
            nums[numbers[i]] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!nums[i]) {
                answer += i;
            }
        }

        System.out.println(answer);
    }
}
