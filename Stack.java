package CustomeDataType;

import java.util.*;

public class Stack {
	
	int size = 10;
	int peek = -1;
	int stk[] ;

	public Stack() {
		stk = new int[size];
	}
	
	public void push(int val) {
		peek += 1;
		if(peek >= size) {
			int temp[] = new int[stk.length];
			
			for(int i=0; i<stk.length; i++) {
				temp[i] = stk[i];
			}
			
			size = size + (size/2);
			stk = new int[size];
			
			for(int i=0; i<temp.length; i++) {
				stk[i] = temp[i];
			}
			stk[peek] = val;			
		}
		else {
			stk[peek] = val;
		}
		
	}
	
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		if(peek == -1) {
			return "[]";
		}
		str.append("[");
		for(int i=0; i<=peek; i++) {
			if(i == peek) {
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
		if(peek >= 0) {
			stk[peek] = 0;
			peek -= 1;
		}
		else {
			System.out.println("No Elements for Pop...");
		}
		
	}
	
	public int size() {
		
		return peek+1;
	}
	
	public boolean isEmpty() {
		
		return (peek < 0);
	}

}
