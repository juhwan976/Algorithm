package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_4_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String dataIn[] = input.readLine().split(" ");
        int length = Integer.parseInt(dataIn[0]);
        int diff = Integer.parseInt(dataIn[1]);

        boolean isPicked[] = new boolean[length];
        int remain;
        int cursor = 0;

        output.write("<");

        for (int i = 0; i < length; i++) {
            remain = (i == 0) ? diff - 1 : diff;

            while (true) {
                if (remain == 0)
                    break;

                if(!isPicked[returnCursor(cursor, 1, length)]) {
                    remain--;
                }

                cursor = returnCursor(cursor, 1, length);
            }

            isPicked[cursor] = true;
            
            if(i == length - 1)
                output.write(cursor + 1 + ">");
            else
                output.write(cursor + 1 + ", ");
        }

        input.close();
        output.flush();
        output.close();
    }

    public static int returnCursor(int cursor, int move, int length) {
        if(cursor + move >= length) {
            return cursor + move - length;
        }
        else
            return cursor + move;
    }
}
