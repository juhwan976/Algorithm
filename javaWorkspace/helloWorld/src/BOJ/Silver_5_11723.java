package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_5_11723 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean[] nums = new boolean[21];

    String temp;
    String command;
    int target;

    int commandNum = Integer.parseInt(input.readLine());

    for(int i = 0 ; i < commandNum ; i++) {
      temp = input.readLine();

      command = temp.split(" ")[0];

      if(command.equals("add")) {
        target = Integer.parseInt(temp.split(" ")[1]);

        nums[target] = true;
      }
      else if(command.equals("remove")) {
        target = Integer.parseInt(temp.split(" ")[1]);

        nums[target] = false;
      }
      else if(command.equals("check")) {
        target = Integer.parseInt(temp.split(" ")[1]);

        output.write((nums[target] ? 1 : 0) + "\n");
      }
      else if(command.equals("toggle")) {
        target = Integer.parseInt(temp.split(" ")[1]);

        nums[target] = !nums[target];
      }
      else if(command.equals("all")) {
        for(int j = 1 ; j <= 20 ; j++) {
          nums[j] = true;
        }
      }
      else if(command.equals("empty")) {
        for(int j = 1 ; j <= 20 ; j ++) {
          nums[j] = false;
        }
      }
    }

    output.flush();
    output.close();
    input.close();
  }
}
