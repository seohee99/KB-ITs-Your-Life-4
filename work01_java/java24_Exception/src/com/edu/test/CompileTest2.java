package com.edu.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading{
	public void readFile(String filename) {
		FileReader reader = null;
		try{
			reader = new FileReader(filename);
			
			
			System.out.println("1. 파일을 잘 찾았습니다!");
			
			
		}catch (FileNotFoundException e) {
			System.out.println("1. 파일을 찾을 수 없어용");
		}catch (IOException e) {
			System.out.println("1. 파일을 찾을 수 없어용");
		}finally {
			try{
				reader.close();
			}catch(IOException e){
				
			}
		}
		
		System.out.println("2. FileReader API..");
	}
}

public class CompileTest2 {

	public static void main(String[] args) {
		FileReading fr = new FileReading();
		fr.readFile("C:\\KB_EDU\\doc\\KB알고리즘JAVA1차테스트_11교육생배포용.pdf");
		
		System.out.println("3. readFile");

	}

}
