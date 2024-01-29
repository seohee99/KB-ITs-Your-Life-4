package com.edu.colllection.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("가");
		set.add("나");
		set.add("다");
		set.add("라");
		set.add("가");
		set.add("바");
		System.out.println(set);
		
		//1. set에 저장된 데이터 개수 출력
		System.out.println(set.size());
		//2. 김준호 멤버가 저장되어 있는지 여부
		System.out.println(set.contains("사"));
		//3. 이수근을 삭제
		set.remove("나");
		System.out.println(set);
		//4. 모든 멤버를 삭제
		set.removeAll(set);
		System.out.println(set);
		//5. set이 비어져 잇는지 확인
		System.out.println(set.isEmpty());
	}

}
