package com.edu.hw;
// 2반_박서희
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BoxFlattenTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int boxLen = 100;

		for (int tcn = 1; tcn <= tc; tcn++) {
			int dump = sc.nextInt();
			int[] boxes = new int[boxLen];
			for (int i = 0; i < boxes.length; i++) {
				boxes[i] = sc.nextInt();
			} // 초기화 완료...

			int heighDiff = flatten(boxes, dump);
			System.out.printf("#%d %d%n", tcn, heighDiff);
		}

	}

	static int flatten(int[] boxes, int dump) {
		int result = 0;
		for (int i = 0; i < dump; i++) {
			Arrays.sort(boxes);
			
			// 비교
			if ((boxes[boxes.length-1] - boxes[0]) < 2) {
				result = (boxes[boxes.length-1] - boxes[0]);
				break;
			}
			else {
				boxes[0] += 1;
				boxes[boxes.length-1] -= 1;
			}
			
			// flatten 결과 출력 전 sort 한번 더
			Arrays.sort(boxes);
			result = (boxes[boxes.length-1] - boxes[0]);
		}

		return result;
	}
}

