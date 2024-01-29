package com.edu.colllection.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("아이유", 90);
		map.put("정구기", 100);
		map.put("미미", 78);
		map.put("박나래", 80);
		map.put("제임스", 85);

		System.out.println(map);
		// 1. map 안에 있는 사람들의 이름들만 받아옴 ... keySet()
		Set<String> set = map.keySet();
		System.out.println(set);
		// 2. 이름에 해당하는 성적들을 출력
		for (String s : set) {
			System.out.println(s + "님의 성적 : " + map.get(s));

		}

		// 3. map에 있는 사람들의 성적만 받아옴
		Collection<Integer> scores = map.values();
		System.out.println(scores);

		// 4. 사람들의 성적의 평균과 최고 성적을 구해서 출력
		int total = 0;
		int max = 0;
		for (int s : scores) {
			total += s;
		}
		System.out.println("평균 : " + total/ map.size());
		System.out.println("최고 성적 : " + Collections.max(scores));
		System.out.println("최저 성적 : " + Collections.min(scores));

	}

}
