package com.edu.sort.test;

import java.util.Arrays;
import java.util.Collections;
/*
 * Arrays.sort()를 사용할 수 있는 데이터타입들은
 * String, int, short, double
 * Date, File 이런것들은 다 가능함
 * 
 * Arraylist 같은 Collection API는 Arrays.sort() 사용 못한다
 * Comparable에 위해서 구현되어져 있지 않기 때문에
 * 
 * ArrayList는 Collections.sort()를 사용해야 한다.
 */
public class ComparableTest1 {

	public static void main(String[] args) {
		String[] names = {
				"Jimin", "Hobi","Tae","JK"
		};
		int[] numbers = {5, 17, 23, 2, 100, 7};
		
		Arrays.sort(names);
		Arrays.sort(numbers);
		
		for(String name:names) System.out.println(name);
		for(int i:numbers) System.out.println(i);
		
		// reverse 정렬
		Arrays.sort(numbers);

	}

}
