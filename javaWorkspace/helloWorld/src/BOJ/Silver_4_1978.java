package BOJ;

import java.util.Scanner;

public class Silver_4_1978 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = Integer.parseInt(input.next());
        int result = length;
        int num;

        for (int i = 0; i < length; i++) {
            num = Integer.parseInt(input.next());
            if (num != 1) {
                for (int j = 2; j < num; j++) {
                    if (num % j == 0) {
                        result--;
                        break;
                    }
                }
            }
            else if(num == 1) 
                result--;
        }

        System.out.println(result);
    }
}