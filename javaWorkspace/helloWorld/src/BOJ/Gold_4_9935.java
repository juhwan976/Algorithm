package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Gold_4_9935 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    Stack<Character> string = new Stack<>();
    String temp;

    temp = input.readLine();

    String bomb = input.readLine();
    int bombLength = bomb.length();

    for(int i = 0 ; i < temp.length() ; i++) {
      string.add(temp.charAt(i));
      if(string.size() >= bombLength) {
        boolean flag = false;

        for(int j = 0 ; j < bombLength ; j++) {
          char stringChar = string.get(string.size() - bombLength + j);
          char bombChar = bomb.charAt(j);

          if(stringChar != bombChar) {
            flag = true;
            break;
          }
        }

        if(!flag) {
          for(int j = 0 ; j < bombLength ; j++) {
            string.pop();
          }
        }
      }
    }

    if(string.isEmpty()) {
      output.write("FRULA");
    } else {
      for(int i = 0 ; i < string.size() ; i++) {
        output.write(string.get(i) + "");
      }
    }
    output.flush();

    output.close();
    input.close();
  }
}
