
package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int options = Integer.parseInt(input.readLine());
        char shortcuts[] = new char[options]; // 숏컷들을 저장할 변수
        int shortcutNum = 0; // 숏컷에 몇개가 들어있는지 판단할 변수

        for (int i = 0; i < options; i++) {
            String str[] = input.readLine().split(" "); // 입력받은 문자열을 공백을 기준으로 분리한 문자열 배열
            boolean flag = false;
            int shortcutindex = 0;
            int shortcutstr = 0;

            if (i == 0) {
                shortcuts[0] = str[0].charAt(0);
                shortcutNum++;
            } else {
                for (int j = 0; j < str.length; j++) {
                    flag = false;

                    for (int k = 0; k < shortcutNum; k++) {
                        if (shortcuts[k] == ((Character.isUpperCase(str[j].charAt(0)))
                                ? Character.toLowerCase(str[j].charAt(0))
                                : Character.toUpperCase(str[j].charAt(0))) || shortcuts[k] == str[j].charAt(0)) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                    } else {
                        shortcuts[shortcutNum] = str[j].charAt(0);
                        shortcutNum++;
                        shortcutindex = 0;
                        shortcutstr = j;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < str.length; j++) {
                        for (int k = 0; k < str[j].length(); k++) {
                            flag = false;

                            for (int l = 0; l < shortcutNum; l++) {
                                if (shortcuts[l] == ((Character.isUpperCase(str[j].charAt(k)))
                                        ? Character.toLowerCase(str[j].charAt(k))
                                        : Character.toUpperCase(str[j].charAt(k)))
                                        || shortcuts[l] == str[j].charAt(k)) {
                                    flag = true;
                                    break;
                                }
                            }

                            if (flag) {
                            } else {
                                shortcuts[shortcutNum] = str[j].charAt(k);
                                shortcutNum++;
                                shortcutindex = k;
                                shortcutstr = j;
                                break;
                            }
                        }

                        if(!flag) {
                            break;
                        }
                    }
                }
            }

            for (int j = 0; j < str.length; j++) {
                for (int k = 0; k < str[j].length(); k++) {
                    if (shortcutindex == k && shortcutstr == j && !flag) {
                        output.write("[" + str[j].charAt(k) + "]");
                    } else {
                        output.write(str[j].charAt(k));
                    }
                }
                output.write(" ");
            }
            output.write("\n");
        }

        output.flush();
        output.close();
        input.close();
    }
}
