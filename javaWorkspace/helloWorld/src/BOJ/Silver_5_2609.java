package BOJ;

import java.util.Scanner;

public class Silver_5_2609 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = Integer.parseInt(input.next());
        int b = Integer.parseInt(input.next());
        int max = 1;
        int min = 1;
        boolean isActive = false;

        for (int i = 1; i <= ((a > b) ? b : a); i++) {
            // 최대공약수
            if (a % i == 0 && b % i == 0)
                max = i;

            // 최소공배수
            if(!isActive) {
                if ((((a > b) ? a : b) * i) % ((a > b) ? b : a) == 0) {
                    min = ((a > b) ? a : b) * i;
                    isActive = true;
                }
            }
        }

        System.out.println(max);
        System.out.println(min);

        input.close();
    }
}