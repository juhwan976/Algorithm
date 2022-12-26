package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_3_9095 {
  public static void main(String[] args) throws IOException{
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    int length = Integer.parseInt(input.readLine());

    int nums[] = new int[11];

    for(int i = 0 ; i < length ; i++) {
      output.write(findNum(nums, Integer.parseInt(input.readLine())) + "\n");
    }

    output.flush();
    output.close();
    input.close();
  }

  public static int findNum(int[] nums, int target) {
    if(target <= 0) {
      return 0;
    } else if(target == 1) {
      return 1;
    } else if(target == 2) {
      return 2;
    } else if(target == 3) {
      return 4;
    }

    if(nums[target] != 0) {
      return nums[target];
    }


    return findNum(nums, target - 1) + findNum(nums, target - 2) + findNum(nums, target - 3);
  }
}