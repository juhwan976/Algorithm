package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Silver_4_10828 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    int commandNum = Integer.parseInt(input.readLine());
    Stack<Integer> stack = new Stack<Integer>();
    String temp;

    for(int i = 0 ; i < commandNum ; i++) {
      temp = input.readLine();

      String command = temp.split(" ")[0];

      if(command.equals("push")) {
        stack.push(Integer.parseInt(temp.split(" ")[1]));
      }
      else if(command.equals("pop")) {
        if(stack.isEmpty()) {
          output.write("-1\n");
        }
        else {
          output.write(stack.pop() + "\n");
        }
      }
      else if(command.equals("size")) {
        output.write(stack.size() + "\n");
      }
      else if(command.equals("empty")) {
        if(stack.isEmpty()) {
          output.write("1\n");
        }
        else {
          output.write("0\n");
        }
      }
      else if(command.equals("top")) {
        if(stack.isEmpty()) {
          output.write("-1\n");
        }
        else {
          output.write(stack.lastElement() + "\n");
        }
      }
    }

    output.flush();

    input.close();
    output.close();
  }
}
