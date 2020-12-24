package BOJ;

import java.util.Scanner;

public class Gold_1_1016 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long mini = input.nextLong();
        long maxi = input.nextLong();
        long result = maxi - mini + 1;
        long sqrNum = 0;
        boolean flag = false;

        for(long i = 1 ; (i * i) <= maxi ; i++) {
            sqrNum++;
        }

        for(long i = 2 ; i <= sqrNum ; i++) {
            for(long j = (mini / (i * i)) ; (j * i * i) <= maxi ; j++) {
                if(j * i * i >= mini) {
                    for(long k = 2 ; k <= i ; k++) {
                        if((i * i * j) % (k * k) == 0 && i != k) {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) {
                        result--;
                    }  
                    flag = false;
                }
            }
        }
        System.out.println(result);
        input.close();
    }
}