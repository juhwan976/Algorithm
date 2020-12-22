package helloWorld;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int x = Integer.parseInt(input.next());
		int y = Integer.parseInt(input.next());
		int maxNum = 0;
		int maxX = 0, maxY = 0;
		int curX = 0, curY = 0;
		int curNum = 0;
		int result = 0;
		boolean isDid = false;
		
		int board[][] = new int[x][y];
		int path[][] = new int[4][2];
		
		for(int i = 0 ; i < x ; i++) {
			for(int j = 0 ; j < y ; j++) {
				board[i][j] = Integer.parseInt(input.next());
				if(board[i][j] > maxNum) {
					maxX = i;
					maxY = j;
					maxNum = board[i][j];
				}
			}
		}
		
		result += maxNum;
		curX = maxX;
		curY = maxY;
		path[0][0] = curX;
		path[0][1] = curY;
		maxNum = 1;
		
		for(int count = 1; count < 4 ; count ++) {
			isDid = false;
			
			if(curX != 0) {
				for(int i = 0 ; i < count ; i++) {
					if(path[i][0] == (curX - 1) && path[i][1] == (curY))
						isDid = true;
				}
				if(board[curX - 1][curY] >= maxNum && !isDid) {
					maxX = curX - 1;
					maxY = curY;
					maxNum = board[maxX][maxY];
				}
			}
			
			isDid = false;
			
			if(curX != (x - 1)) {
				for(int i = 0 ; i < count ; i++) {
					if(path[i][0] == (curX + 1) && path[i][1] == (curY))
						isDid = true;
				}
				if(board[curX + 1][curY] >= maxNum && !isDid) {
					maxX = curX + 1;
					maxY = curY;
					maxNum = board[maxX][maxY];
					
				}
			}
			
			isDid = false;
			
			if(curY != 0) {
				for(int i = 0 ; i < count ; i++) {
					if(path[i][0] == (curX) && path[i][1] == (curY - 1))
						isDid = true;
				}
				if(board[curX][curY - 1] >= maxNum) {
					maxX = curX;
					maxY = curY - 1;
					maxNum = board[maxX][maxY];
				}
			}
			
			isDid = false;
			
			if(curY != (y - 1)) {
				for(int i = 0 ; i < count ; i++) {
					if(path[i][0] == (curX) && path[i][1] == (curY + 1))
						isDid = true;
				}
				if(board[curX][curY + 1] >= maxNum) {
					maxX = curX;
					maxY = curY + 1;
					maxNum = board[maxX][maxY];
				}
			}
			
			curX = maxX;
			curY = maxY;
			path[count][0] = curX;
			path[count][1] = curY;
			result += maxNum;
			maxNum = 1;
		}
		
		System.out.println(result);
		for(int i = 0 ; i < 4 ; i++) {
			System.out.print(path[i][0] + ", ");
			System.out.println(path[i][1]);
		}
		
	}

}
