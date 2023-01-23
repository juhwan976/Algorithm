package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver_1_6588 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    int maxValue = 1000001;

    boolean[] primes = new boolean[maxValue] ;
    int temp;

    for(int i = 3 ; i <= 1000000 ; i += 2) {
      boolean isPrime = true;

      for(int j = 3 ; j * j <= i ; j += 2) {
        if(i % j == 0) {
          isPrime = false;
          break;
        }
      }

      if(isPrime) {
        primes[i] = true;
      }
    }

    while(true) {
      temp = Integer.parseInt(input.readLine());

      if(temp == 0) {
        break;
      }

      boolean isFound = false;

      for(int i = 3 ; i <= temp / 2 ; i += 2) {
        if(primes[i] && primes[temp - i]) {
          output.write(temp + " = " + i + " + " + (temp - i) + "\n");
          isFound = true;
          break;
        }
      }

      if(!isFound) {
        output.write("Goldbach's conjecture is wrong.\n");
      }
    }

    output.flush();

    output.close();
    input.close();
  }
}
