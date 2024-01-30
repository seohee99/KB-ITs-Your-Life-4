package day03.sorting;

public class RecursiveTest {
	public static void recur(int n) {
		System.out.println(n + " hi");
		if (n==0) return;
		
		recur(--n);
		System.out.println(n + " bye");
		
	}
	public static void main(String[] args) {
		recur(3);

	}

}
