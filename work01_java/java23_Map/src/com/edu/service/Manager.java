package com.edu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.edu.domain.Person;



public class Manager {
	private static Manager manager = new Manager(100);
	
	
	private Map<Integer,Person> map;
	
	
	private Manager(int size){
		System.out.println("싱글톤 Pattern..");
		map = new HashMap<>();
	}
	
	public static Manager getInstance() {
		return manager;
	}
	
	public void printAllPersonInfo(){
		Set<Integer> set = map.keySet();
		for(int ssn:set) {
			System.out.println(ssn + " PersonInfo : " + map.get(ssn));
		}
		
	}	
	
	public void addPerson(Person person){		
		//추가하려는 사람이 있을떄는 추가되지 않도록 작성
		if(!map.containsKey(person.getSsn())) {
			map.put(person.getSsn(), person);
			System.out.println(person.getName() + "님 등록 완!");
		}
		else {
			System.out.println("이미 회원이심!!");
			return;
		}
		
	}
	
	public void deletePerson(int ssn){
		// 삭제 대상이있을때만 삭제되도록 -> return 타입을 잘 활용하면 containsKey() 사용 안해도 됨!
		Person p = map.remove(ssn);
		if(p==null) {
			System.out.println("삭제 대상이 존재하지 않아용가리");
			return;
		}else System.out.println(p.getName() + "님 탈퇴 완!");
	}
	
	public Person findPerson(int ssn){
		//
		return map.get(ssn);
	}//

	public ArrayList<Person> findPerson(String addr){
		ArrayList<Person> temp  = new ArrayList<>();
		for(int s:map.keySet()) {
			if(map.get(s).getAddress().equals(addr)) temp.add(map.get(s));
		}
		return temp;
	}
	// map에는 set()함수가 별도로 존재하지 않고, key에 해당하는 값을 다시 put()
	public void updatePerson(Person p, int ssn){	
		if(map.containsKey(ssn)) {
			map.put(ssn, p);
			System.out.println(p.getName()+"으로 수정 완!");
		}else System.out.println("수정 실패!");
		
		
	}
}











