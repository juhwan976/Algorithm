package BOJ;

import java.util.Scanner;

public class repaintChessBoard {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int m = Integer.parseInt(input.next());
		int n = Integer.parseInt(input.next());
		int board[][] = new int[m + 1][n + 1];
		String row1;
		int errCount[] = { 0, 0 };
		Boolean errBoard[][][] = new Boolean[2][m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			row1 = input.next();
			for (int j = 1; j <= n; j++) {
				if (row1.charAt(j - 1) == 'B') {
					// 검정이면 1
					board[i][j] = 1;
				} else
					// 흰색이면 0
					board[i][j] = 0;
			}
		}

		// 에러 갯수 파악
		for (int a = 0; a <= 1; a++) {
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (i % 2 == 1) {
						if (j % 2 == 1) {
							if (a == 0) {
								if (board[i][j] == 1) {
									errBoard[a][i][j] = true;
									errCount[a] += 1;
								} else
									errBoard[a][i][j] = false;
							} else {
								if (board[i][j] == 0) {
									errBoard[a][i][j] = true;
									errCount[a] += 1;
								} else
									errBoard[a][i][j] = false;
							}
						} else {
							if (a == 0) {
								if (board[i][j] == 0) {
									errBoard[a][i][j] = true;
									errCount[a] += 1;
								} else
									errBoard[a][i][j] = false;
							} else {
								if (board[i][j] == 1) {
									errBoard[a][i][j] = true;
									errCount[a] += 1;
								} else
									errBoard[a][i][j] = false;
							}
						}
					} else {
						if (j % 2 == 1) {
							if (a == 0) {
								if (board[i][j] == 0) {
									errBoard[a][i][j] = true;
									errCount[a] += 1;
								} else
									errBoard[a][i][j] = false;
							} else {
								if (board[i][j] == 1) {
									errBoard[a][i][j] = true;
									errCount[a] += 1;
								} else
									errBoard[a][i][j] = false;
							}
						} else {
							if (a == 0) {
								if (board[i][j] == 1) {
									errBoard[a][i][j] = true;
									errCount[a] += 1;
								} else
									errBoard[a][i][j] = false;
							} else {
								if (board[i][j] == 0) {
									errBoard[a][i][j] = true;
									errCount[a] += 1;
								} else
									errBoard[a][i][j] = false;
							}
						}
					}
				}
			}
		}
		int errC[] = { 0, 0 };
		int result[] = { 64, 64 };

		// 에러가 가장 적게 발생하는 구역 발견
		for (int a = 0; a <= 1; a++) {
			for (int i = 1; i <= m - 8 + 1; i++) {
				for (int j = 1; j <= n - 8 + 1; j++) {
					for (int k = 0; k <= 7; k++) {
						for (int o = 0; o <= 7; o++) {
							if (errBoard[a][i + k][j + o] == true)
								errC[a] += 1;
						}
					}
					if (result[a] >= errC[a])
						result[a] = errC[a];
					errC[a] = 0;
				}
			}

		}

		System.out.println((result[0] >= result[1]) ? result[1] : result[0]);
		input.close();
	}


}
