package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Silver_4_1920 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputLength = Integer.parseInt(input.next());
		int inputArr[] = new int[inputLength];

		for (int i = 0; i < inputLength; i++) {
			inputArr[i] = Integer.parseInt(input.next());
		}

		Arrays.sort(inputArr);

		int targetLength = Integer.parseInt(input.next());
		int currentEndIndex = inputLength - 1;
		int currentStartIndex = 0;

		for (int i = 0; i < targetLength; i++) {
			int targetNum = Integer.parseInt(input.next());
			System.out.println(findNum(inputArr, currentStartIndex, currentEndIndex, targetNum));
		}

		input.close();
	}

	public static int findNum(int[] nums, int startIndex, int endIndex, int targetNum) {
		int mid = (startIndex + endIndex) / 2;

		if (startIndex <= endIndex) {
			if (nums[mid] == targetNum) {
				return 1;
			} else if (nums[mid] > targetNum) {
				return findNum(nums, startIndex, mid - 1, targetNum);
			} else {
				return findNum(nums, mid + 1, endIndex, targetNum);
			}
		} else {
			return 0;
		}
	}
}
