package day02.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class B17608 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			stack.push(sc.nextInt());
		}

		int standard = stack.pop();
		int cnt = 1; // 자기 자신
		while (!stack.isEmpty()) {
			int stick = stack.pop();
			if (stick > standard) {
				cnt++;
				standard = stick;
				
			}
		}
		System.out.println(cnt);

	}

}
