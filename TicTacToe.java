package Games;

import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {
	
	private static char grid[][];
	private static int count = 0;
	private static char player = 'X';

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Grid Size : ");
		int size = input.nextInt();
		grid = new char[size][size];
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid.length; j++) {
				grid[i][j] = '-';
			}
		}
		for(char ar[] : grid) {
			System.out.println(Arrays.toString(ar));
		}
		
		while(count < size*size) {
			System.out.println("Enter the Row : " );
			int r = input.nextInt();
			System.out.println("Enter the Column : ");
			int c = input.nextInt();
			if(r < size && c < size) {
				positionSet(r, c);
			}
			else {
				System.out.println("Invalid Position...");
				System.out.println("Enter the Valid Position :)");
			}
			
			if(checkRow(r) || checkCol(c) || checkDiaLR() || checkDiaRL()) {
				player = (player == 'X')? 'O' : 'X';
				System.out.println(player + " is Won the Game...");
				return;
			}
		}		
		
	}	
	
	static boolean checkCol(int c) {
		
		char ch = grid[0][c];
		for(int i=0; i<grid.length; i++) {
			if(ch != grid[i][c]) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean checkRow(int r) {
		
		char ch = grid[r][0];
		for(int i=0; i<grid.length; i++) {
			if(ch != grid[r][i]) {
				return false;
			}
		}
		
		return true;
	}

	static boolean checkDiaLR() {
		
		char ch = grid[0][0];
		for(int i=0; i<grid.length; i++) {
			if(ch == '-' || ch != grid[i][i]) {
				System.out.println("grid len : " + grid.length);
				return false;
			}
		}
		
		return true;
	}
	
	static boolean checkDiaRL() {
		
		char ch2 = grid[0][grid.length-1];
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid.length; j++) {
				if(ch2 == '-' || (i+j) == grid.length-1 && ch2 != grid[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void positionSet(int r, int c) {
		if(grid[r][c] == '-') {
			grid[r][c] = player;
			player = (player == 'X') ? 'O' : 'X';
			count += 1;
		}
		else {
			System.out.println("This Index is already Taken..., Take anyother :)");
		}
		
		for(char ar[] : grid) {
			System.out.println(Arrays.toString(ar));
		}
	}
			
		
}
