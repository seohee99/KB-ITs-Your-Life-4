package com.edu.service;

import java.util.ArrayList;

import com.edu.domain.Employee;
import com.edu.domain.Person;
import com.edu.domain.Student;
import com.edu.domain.Teacher;



public class Manager {
	/*private Person[ ] p;
	private int index;
	*/
	
	private ArrayList<Person> list;
	
	public Manager(int size){
		list = new ArrayList<>();
	}
	public void getPersons(){
		for(Person p : list) {
			System.out.println(p);
		}
	}	
	
	public void addPerson(Person person){		
		//추가하려는 사람이 없을때만 추가되도록 작성
		boolean find = false;
		for(Person p : list) {
			if(p.getSsn() == person.getSsn()) {
				find=true;
				System.out.println("그런 사람 이미 존재합니다");
				return;
			}
		}
		if(find == false) {
			list.add(person);
			System.out.println(person.getName() + "님이 등록되었씁니당");
		}
		
//		if (!list.contains(person)) list.add(person);		
		
	}
	
	public void deletePerson(int ssn){
		//삭제하려는 대상이 있을때에만 삭제가 되도록 작성
		boolean find = false;
		for(Person p : list) {
			if(p.getSsn() == ssn) {
				find=true;
				System.out.println(p.getName() + "님 탈퇴!");
				list.remove(p);
				break;
			}
		}
		if(find == false) {
			System.out.println("삭제 대상이 존재하지 않습니다");
		}
	}

	public Person findPerson(int ssn){
		for(Person p:list) {
			if(p.getSsn() == ssn) return p;
		}
		return null;
	}//

	public ArrayList<Person> findPerson(String addr){
		ArrayList<Person> temp = new ArrayList<>();
		for(Person p:list) {
			if(p.getAddress().contains(addr)) temp.add(p);
		}
		return temp;
	}

	public void updatePerson(String name,int age, String addr, String str,int k){	
		
		//툭정한 위치에 있는 사람의 정보를 수정함
		//메소드의 인자값을 잘 활용해서 모든 객체의 정보가 수정될수 있도록 로직을 작성
		
		// ssn이 없는 이유 : PK는 수정의 대상이 되지 않는다!!
		Person p = list.get(k);
		p.setName(name);
		p.setAddress(addr);
		p.setAge(age);
		
		if(p instanceof Student) ((Student) p).setStuId(str);
		else if(p instanceof Employee) ((Employee) p).setDept(str);
		else if(p instanceof Teacher) ((Teacher) p).setSubject(str);
		
	}
}
