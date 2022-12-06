package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Silver_4_1620 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    HashMap<String, Integer> nameMap = new HashMap<>();
    HashMap<Integer, String> numMap = new HashMap<>();

    String temp;

    temp = input.readLine();

    int num = Integer.parseInt(temp.split(" ")[0]);
    int findNum = Integer.parseInt(temp.split(" ")[1]);

    for(int i = 0 ; i < num ; i++) {
      temp = input.readLine();
      nameMap.put(temp, i + 1);
      numMap.put(i + 1, temp);
    }

    for(int i = 0 ; i < findNum ; i++) {
      temp = input.readLine();

      try {
        Integer.parseInt(temp);

        output.write(numMap.get(Integer.parseInt(temp)) + "\n");
      } catch(Exception e) {
        output.write(nameMap.get(temp) + "\n");
      }
    }

    output.flush();
    output.close();
    input.close();
  }
}
