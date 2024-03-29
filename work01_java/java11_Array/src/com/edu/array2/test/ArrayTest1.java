package com.edu.array2.test;
/*
 * stack 영역에서의 참조가 끊어진 객체를 쓰레기 객체라고 한다
 * 쓰레기 객체는 더이상 객체로서의 효용가치가 없기 때문에
 * GC의 제거대상이 된다
 * GC는 내부적으로 우선순위 1짜리 쓰레드로 작동..알아서 삭제
 */

public class ArrayTest1 {

	public static void main(String[] args) {
		// 배열 선언 + 생성 + 초기화
		int[ ] arr1 = {11, 22, 33};
		int[ ] arr2 = {100, 200, 300};
		
		// 배열 안에 있는 값들을 반복문을 통해서 출력
		for (int num : arr1) System.out.println(num);
		for (int num2 : arr2) System.out.println(num2);
		
		System.out.println("============================");
		arr1 = arr2;
		
		for (int num : arr1) System.out.println(num);
		for (int num2 : arr2) System.out.println(num2);
	}

}
