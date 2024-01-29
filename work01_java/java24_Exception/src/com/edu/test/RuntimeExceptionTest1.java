package com.edu.test;
/*
 * 컴파일 시에는 에러가 없는데
 * 실행 시점에서 에러가 발생
 * 컴파일러가 인지하지 못함
 * ::
 * 명시적인 예외처리 하지 말고 
 * 
 * SQLException
 * 
 * 명시적인 예외처리 방법
 * try, catch, finally, throws, throw
 * 
 * try{
 * 
 * 	//예외 발생 가능 코드
 * 
 * }catch(ArrayIndexOutOfBoundsException e){
 * 	//예외 발생하면 이곳으로 코드가 이동.. 여기서 예외 잡혔을 때 코드
 * 
 * }catch(ArithmeticException e){
 * 	//예외 발생하면 이곳으로 코드가 이동.. 여기서 예외 잡혔을 때 코드
 * 
 * 	// catch는 여러번 잡을 수 있지만, 제대로 잡힌 처음 블럭만 실행
 *  // 작은 것부터 커지는 순으로 catch
 * 
 * }finally{
 * 	// 예외 발생 하건 안하건 무조건 작성해야하는 코드
 * 	// 가장 중요한 코드를 이곳에 넣자 예를 들어 stream 닫는거?
 * }
 * 
 * 
 * 
 * 
 */
public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str = {
				"Hello",
				"No, I mean it",
				"Nice to meet you"
		};
		
		int i=0;
		// 에러는 줄 단위로 발생한다 
		// i>=3일때 프로그램이 비정상 종료된다
		// 예외 처리 해야 하는 경우는 컴파일 에러!
		while(i<=3) {
			try{
				System.out.println(str[i]);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch1!!");
			}catch (ArithmeticException e) {
				System.out.println("Nice Catch2!!");
			}catch (Exception e) {
				System.out.println("Nice Catch3!!");
			}finally {
				System.out.println("Always!!");
			}
			i++;
		}

	}

}
