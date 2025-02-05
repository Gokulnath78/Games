package Games;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//{
//

//	
//}

public class TwoZeroFourEight {
	
	private static int matrix[][];
	private static char movement;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);		
		
		System.out.println("Enter the Matrix Size : ");
		int size = input.nextInt();
		matrix = new int[size][size];
		
		while(true) {
			System.out.println("Enter the Input : ");
			movement = input.next().charAt(0);
			switch(movement) {
			case 'P' :
				System.out.println("Enter the Row : ");
				int row = input.nextInt();
				System.out.println("Enter the Column : ");
				int column = input.nextInt();
				System.out.println("Enter the Value : ");
				int value = input.nextInt();
				
				putValue(row, column, value);
				printMatrix();
				break;
				
			case 'L' :
				moveLeft();
				addLeft();
				moveLeft();
				printMatrix();
				break;
				
			case 'R' :
				moveRight();
				addRight();
				moveRight();
				printMatrix();
				break;
				
			case 'T' :
				moveTop();
				printMatrix();
				break;
				
			case 'B' : 
				moveBottom();
				printMatrix();
				break;
			}
				
		}

	}
	
	public static void moveBottom() {
		
		List<Integer> list;
		for(int i=0; i<matrix[0].length; i++) {
			list = new ArrayList();
			for(int j=0; j<matrix.length; j++) {
				if(matrix[j][i] != 0) {
					list.add(matrix[j][i]);
				}
			}
			for(int m=0; m<matrix.length; m++) {
				matrix[m][i] = 0;
			}
			for(int k=1; k<list.size(); k++) {
				if(list.get(k-1) == list.get(k)) {
					list.set(k-1, list.get(k) + list.get(k-1));
					list.remove(k);
				}
			}
			int ind = matrix.length-list.size(), listInd = 0;
			for(int l=ind; l<matrix.length; l++) {
				matrix[l][i] = list.get(listInd++);
			}
			
		}
		
	}
	
	public static void moveTop() {
		
		List<Integer> list;
		for(int i=0; i<matrix[0].length; i++) {
			list = new ArrayList();
			for(int j=0; j<matrix.length; j++) {
				if(matrix[j][i] != 0) {
					list.add(matrix[j][i]);
				}
			}
			for(int c=0; c<matrix.length; c++) {
				matrix[c][i] = 0;
			}
			if(list.size() > 1) {
				for(int a=1; a<list.size(); a++) {
					if(list.get(a) == list.get(a-1)) {
						list.set(a-1, list.get(a) + list.get(a-1));
						list.remove(a);
					}
				}
			}
			for(int k=0; k<list.size(); k++) {
				matrix[k][i] = list.get(k);
			}
		}
		
	}
	
	public static void addRight() {
		
		for(int ar[] : matrix) {
			for(int i=1; i<ar.length; i++) {
				if(ar[i-1] == ar[i]) {
					ar[i] += ar[i-1];
					ar[i-1] = 0;
					i += 1;
				}
			}
		}
		System.out.println();
	}
	
	public static void moveRight() {
		
		for(int ar[] : matrix) {
			int l = ar.length-2, r = ar.length-1;
			while(l < ar.length && r < ar.length && l >= 0 && r >= 0) {
				if(l == r) {
					l--;
				}
				else if(ar[l] == 0) {
					l--;
				}
				else if(ar[r] != 0) {
					r--;
				}
				else if(ar[l] != 0 && ar[r] == 0) {
					int temp = ar[r];
					ar[r] = ar[l];
					ar[l] = temp;
				}
			}
		}
		
	}
	
	public static void addLeft() {
		
		for(int ar[] : matrix) {
			for(int i=1; i<ar.length; i++) {
				if(ar[i-1] == ar[i]) {
					ar[i-1] += ar[i];
					ar[i] = 0;
					i += 1;
				}
			}
		}
		System.out.println();
	}
	
	public static void moveLeft() {
		
		for(int ar[] : matrix) {
			int l = 0, r = 1;
			while(l < matrix[0].length && r < matrix[0].length) {
				if(l == r) {
					r++;
				}
				else if(ar[l] != 0) {
					l++;
				}
				else if(ar[r] == 0) {
					r++;
				}
				else if(ar[l] == 0 && ar[r] != 0) {
					int temp = ar[l];
					ar[l] = ar[r];
					ar[r] = temp;
				}
			}
		}
		
	}
	
	public static void putValue(int r, int c, int val) {
		
		if(r >= matrix.length || c >= matrix[0].length) {
			System.out.println("Invalid Position");
			return;
		}
		
		if(matrix[r][c] == 0) {
			matrix[r][c] = val;
		}
				
	}
	
	public static void printMatrix() {
		for(int ar[] : matrix) {
			System.out.println(Arrays.toString(ar));
		}
	}

}
