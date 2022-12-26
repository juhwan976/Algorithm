package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Silver_2_18870 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(input.readLine());

    Set<Integer> set = new TreeSet<Integer>();
    Integer[] nums = new Integer[num];

    StringTokenizer token = new StringTokenizer(input.readLine(), " ");
    String temp;

    for(int i = 0 ; i < num ; i++) {
      temp = token.nextToken();

      nums[i] = Integer.parseInt(temp);
      set.add(Integer.parseInt(temp));
    }

    Integer[] sorted = set.toArray(new Integer[0]);

    for(int i = 0 ; i < num ; i++) {
      output.write(binarySearch(sorted, nums[i], 0, sorted.length - 1) + " ");
    }

    output.flush();
    output.close();
    input.close();
  }

  public static int binarySearch(Integer[] nums, Integer target, int left, int right) {
    int mid = (right + left) / 2;

    if(nums[mid].equals(target)) {
      return mid;
    }
    else if(nums[mid].compareTo(target) > 0) {
      return binarySearch(nums, target, left, mid - 1);
    } else {
      return binarySearch(nums, target, mid + 1, right);
    }
  }
}
