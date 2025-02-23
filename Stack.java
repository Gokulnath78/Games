package CustomeDataType;

import java.util.*;

public class Stack {
	
	int size = 10;
	int point = -1;
	int stk[] ;

	public Stack() {
		stk = new int[size];
	}
	
	public void push(int val) {
		point += 1;
		if(point >= size) {
			int temp[] = new int[stk.length];
			
			for(int i=0; i<stk.length; i++) {
				temp[i] = stk[i];
			}
			
			size = size + (size/2);
			stk = new int[size];
			
			for(int i=0; i<temp.length; i++) {
				stk[i] = temp[i];
			}
			stk[point] = val;			
		}
		else {
			stk[point] = val;
		}
		
	}
	
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		if(point == -1) {
			return "[]";
		}
		str.append("[");
		for(int i=0; i<=point; i++) {
			if(i == point) {
				str.append(stk[i]);
				str.append("]");
			}
			else {
				str.append(stk[i] + ", ");
			}
		}
		
		return str.toString();
	}
	
	public void pop() {
		if(point >= 0) {
			stk[point] = 0;
			point -= 1;
		}
		else {
			System.out.println("No Elements for Pop...");
		}
		
	}
	
	public int peek() {
		return stk[point];
	}
	
	public int size() {
		
		return point+1;
	}
	
	public boolean isEmpty() {
		
		return (point < 0);
	}

}
