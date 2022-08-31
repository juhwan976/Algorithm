package BOJ;

import java.util.Scanner;

public class Silver_4_1920 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputLength = Integer.parseInt(input.next());
		int inputArr[] = new int[inputLength];

		for (int i = 0; i < inputLength; i++) {
			inputArr[i] = Integer.parseInt(input.next());
		}

		int compareLength = Integer.parseInt(input.next());
		int compareArr[] = new int[compareLength];
		// int resultArr[] = new int[compareLength];

		for (int i = 0; i < compareLength; i++) {
			compareArr[i] = Integer.parseInt(input.next());
			/*
			 * for(int j = 0 ; j < inputLength ; j++) {
			 * if(compareArr[i] == inputArr[j]) {
			 * resultArr[i] = 1;
			 * break;
			 * }
			 * else {
			 * resultArr[i] = 0;
			 * }
			 * }
			 * 
			 * System.out.println(resultArr[i]);
			 */
		}
		input.close();
	}

}
