package day02.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++ ) queue.add(i);
		int cnt = 0;
		while(queue.size() > 1) {
			int top = queue.poll();
			if (cnt % 2 == 1) {
				queue.add(top);
			}
			cnt++;
		}
		int result = queue.poll();
		System.out.println(result);

	}

}
