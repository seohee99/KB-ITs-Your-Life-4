package com.edu.condition.test;

import java.util.Scanner;

public class SwitchGradeTest3 {

	public static void main(String[] args) {
		System.out.println("성적 입력 : ");
		Scanner sc = new Scanner(System.in);
		
		int grade = sc.nextInt();
		
		switch(grade) {
		case 95 :
		case 90 : 
		case 85 :
			System.out.println("A");
//			break;
		case 80 :
		case 75 :
			System.out.println("A");
			break;
		case 60 :
			System.out.println("A");
			break;
		}

	}

}
