package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gold_1_1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = input.readLine();
        String comp = input.readLine();
        int count = 0;
        int stack[] = new int[comp.length()];
        boolean flag = false;
        stack[0] = 1;
        int value = 0;

        // 우선 시작점과 같은 곳들을 찾아야 한다.
        for (int i = 1; i < comp.length(); i++) {
            if(comp.charAt(0) == comp.charAt(i))
                stack[i] = 1;
        }

        // 몇단계까지 이어져있는지 판별한다.
        for(int i = 1 ; i < comp.length() ; i++) {
            if(stack[i] == 1) {
                if(stack[i-1] == 1) continue;
                else {
                    if(i+1 != comp.length()) {
                        if(stack[i+1] == 1)
                            continue;
                        else {
                            stack[i+1] = stack[i] + 1;
                        }
                    }
                }
            }
        }

        // 문자열을 분석한다.
        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == comp.charAt(value)) {
                if(value == comp.length()) {
                    value = 0;
                    count++;

                } else {
                    value++;
                }
            }
            else {
                for(int j = comp.length() - 1 ; j >= 0 ; j--) {
                    if(stack[value - 1] == stack[j]) {
                        i += j;
                        break;
                    }
                }
            }
        }

        output.write(count + " ");

        input.close();
        output.flush();
        output.close();
    }
}
