package day03.sorting;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2 }, { 3, 4 }, { 9, 10 }, { 9, 5 }, { 3, 6 }, { 5, 6 } };
		System.out.println(Arrays.deepToString(arr));

		// 람다 함수 이용 내림차순 : 앞(x)에서 뒤(y)를 빼면 오름차순, 뒤에서 앞을 빼면 내림차순
		Arrays.sort(arr, (x, y) -> y[0] - x[0]);
		System.out.println(Arrays.deepToString(arr));

		// 람다 함수를 이용하여 두번째 값 비교, 두번째값 오름차순 정렬 ㅣ 두번째 값이 같다면 첫번째 값(오름차순)
		Arrays.sort(arr, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
		System.out.println(Arrays.deepToString(arr));

		// 첫번째 값 내림차순 ㅣ 같다면 두번째 값 오름차순으로
		Arrays.sort(arr, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
		System.out.println(Arrays.deepToString(arr));
	}

}
