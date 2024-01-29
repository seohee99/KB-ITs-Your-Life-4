package com.edu.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// 메소드 블럭에서 발생하는 에러는 try,catch가 아니라 throws한다
class FileReading2{
	public void readFile(String filename) throws FileNotFoundException, IOException {
		FileReader reader = null;
		try{
			reader = new FileReader(filename);
			System.out.println("1. 파일을 잘 찾았습니다!");
		}finally {
			reader.close();
		}
		
		
		System.out.println("2. FileReader API..");
	}
}

public class CompileTest3 {

	public static void main(String[] args) throws Exception {
		FileReading2 fr = new FileReading2();
		fr.readFile("C:\\KB_EDU\\doc\\KB알고리즘JAVA1차테스트_교육생배포용.pdf");
		
		System.out.println("3. readFile");

	}

}
