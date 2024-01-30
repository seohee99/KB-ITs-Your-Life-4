package day01.array;

public class timeMiles {

	public static void main(String[] args) {
		int N = 100000;
		long start, end;
		
		int total = 0;
		
		// 반복문: O(n)
		start = System.currentTimeMillis();
		
		for (int i = 0; i < N; i++) {
			total += i;
		}
		end = System.currentTimeMillis();
		System.out.println("반복문 실행 시간(ms) : " + (end - start));

		// 2중 반복문 : O(n^2)
				total = 0;
				
				start = System.currentTimeMillis();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						total += j;				
					}
				}
				end = System.currentTimeMillis();
				System.out.println("2중 반복문 실행 시간(ms) : " + (end - start));
				

	}

}
