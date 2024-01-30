package day02.stackqueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class B2493 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[n];

		int cnt = 1;
		for(int i = 0; i <= n;i++) {
			if(stack.size() == 0) {
				stack.push(sc.nextInt());
				System.out.println("e");
			}
			
			int num = stack.peek();
			int top = sc.nextInt();
			System.out.println(num + " " + top);
			if(num < top) {
				stack.pop();
				stack.push(top);
				result[i] = 0;
				cnt += 1;
			}else {
				result[i] = cnt;
				stack.push(top);
			}
		}
		System.out.println(Arrays.toString(result));



	}

}
