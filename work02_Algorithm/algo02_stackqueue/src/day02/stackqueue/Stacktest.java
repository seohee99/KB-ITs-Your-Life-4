package day02.stackqueue;

import java.util.Stack;

public class Stacktest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		System.out.println(stack.toString());
		
		int top = stack.pop();
		System.out.println("top : " + top);
		System.out.println(stack.toString());
		
		while(!stack.isEmpty()) {
			System.out.println(stack.toString());
			stack.pop();
		}
	}

}
