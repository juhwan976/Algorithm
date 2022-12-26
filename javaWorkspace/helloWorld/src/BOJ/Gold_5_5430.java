package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Gold_5_5430 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    int testNum = Integer.parseInt(input.readLine());

    Deque<Integer> deque = new ArrayDeque<>();

    boolean isReverse;

    boolean isError;

    String command;

    int arrayLength;

    String nums;

    int currentDequeSize;

    for(int i = 0 ; i < testNum ; i++) {
      deque.clear();

      isReverse = false;

      isError = false;

      command = input.readLine();

      arrayLength = Integer.parseInt(input.readLine());

      nums = input.readLine();

      StringTokenizer st = new StringTokenizer(nums, "[,]");

      for(int j = 0 ; j < arrayLength ; j++) {
        deque.add(Integer.parseInt(st.nextToken()));
      }

      for(int j = 0 ; j < command.length() ; j++) {
        if(command.charAt(j) == 'R') {
          isReverse = !isReverse;
        } else {
          if(deque.isEmpty()) {
            isError = true;
          }
          else {
            if(isReverse) {
              deque.removeLast();
            }
            else {
              deque.removeFirst();
            }
          }
        }
      }

      if(deque.isEmpty()) {
        if(isError) {
          // output.write("error");
          output.write("error");
        }
        else {
          output.write("[]");
        }
      } else {
        if(isReverse) {
          output.write("[");

          currentDequeSize = deque.size();

          for(int j = 0 ; j < currentDequeSize ; j++) {
            output.write(deque.pollLast().toString());

            if(j != currentDequeSize - 1) {
              output.write(",");
            }
          }

          output.write("]");
        }
        else {
          output.write("[");

          currentDequeSize = deque.size();

          for(int j = 0 ; j < currentDequeSize ; j++) {
            output.write(deque.pollFirst().toString());

            if(j != currentDequeSize - 1) {
              output.write(",");
            }
          }

          output.write("]");
        }
      }

      output.write("\n");
    }

    input.close();
    output.close();
  }
}
