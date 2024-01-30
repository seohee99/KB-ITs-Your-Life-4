package day02.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> temp = new LinkedList<>();
		int[] result = new int[n];

		// 1 ~ n을 queue에 저장
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		// k-1개는 뒤로 붙이고 1개는 poll
		int idx = 0;
		while (queue.size() > 0) {
			for (int i = 0; i < k - 1; i++) {
				queue.add(queue.poll());
			}
			result[idx++] = queue.poll();

		}
		System.out.println(Arrays.toString(result));
		
	}

}
