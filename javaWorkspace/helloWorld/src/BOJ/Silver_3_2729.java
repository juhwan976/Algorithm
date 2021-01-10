package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_2729 {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int length;

    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(input.readLine());

        for (int i = 0; i < length; i++) {
            String data[] = input.readLine().split(" ");
            int up[] = new int[82];
            int result[] = new int[82];
            int len1 = data[0].length() - 1;
            int len2 = data[1].length() - 1;
            int lenu = up.length - 1;
            int lenr = result.length - 1;
            boolean flag = false;

            while(true) {
                if(len1 >= 0 && len2 >= 0) {
                    if(data[0].charAt(len1) == '1' && data[1].charAt(len2) == '1') {
                        if(up[lenu] == 1) {
                            result[lenr] = 1;
                            up[lenu-1] = 1;
                        }
                        else {
                            result[lenr] = 0;
                            up[lenu-1] = 1;
                        }
                    }
                    else if(data[0].charAt(len1) == '1' || data[1].charAt(len2) == '1') {
                        if(up[lenu] == 1) {
                            result[lenr] = 0;
                            up[lenu-1] = 1;
                        }
                        else {
                            result[lenr] = 1;
                            up[lenu-1] = 0;
                        }
                    }
                    else {
                        if(up[lenu] == 1) {
                            result[lenr] = 1;
                        }
                    }
                }
                else if(len1 >= 0 || len2 >= 0){
                    if(len1 >= 0) {
                        if(data[0].charAt(len1) == '1' && up[lenu] == 1) {
                            result[lenr] = 0;
                            up[lenu-1] = 1;
                        }
                        else if(data[0].charAt(len1) == '1' || up[lenu] == 1) {
                            result[lenr] = 1;
                        }
                    }
                    else {
                        if(data[1].charAt(len2) == '1' && up[lenu] == 1) {
                            result[lenr] = 0;
                            up[lenu-1] = 1;
                        }
                        else if(data[1].charAt(len2) == '1' || up[lenu] == 1) {
                            result[lenr] = 1;
                        }
                    }
                }
                else {
                    if(up[lenu] == 1) {
                        result[lenr] = 1;
                    }
                    break;
                }

                len1--;
                len2--;
                lenu--;
                lenr--;
            }

            for(int j = 0 ; j < result.length ; j++) {
                if(!flag) {
                    if(result[j] == 1) {
                        flag = true;
                        output.write("1");
                    }
                }
                else {
                    if(result[j] == 1) {
                        output.write("1");
                    }
                    else {
                        output.write("0");
                    }
                }
            }
            if(!flag) {
                output.write("0");
            }
            output.write("\n");
        }

        

        output.flush();
        output.close();
        input.close();
    }
}
