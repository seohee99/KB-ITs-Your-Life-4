package day03.sorting;

public class MergeSort {
	public static void mergeSort(int[] arr,int n) {
		int left = arr[0];
		int right = arr[n-1];
		int center = (left + right) / 2;
		mergeSort(arr, left, center);
		mergeSort(arr, center+1, right);
	}
	
	public static void mergeSort(int[] arr,int left, int right) {
		if (left >= right) return; // 종료조건
		
		int center = (left + right) / 2;
		mergeSort(arr, left, center); // 왼쪽 정렬
		mergeSort(arr, center+1, right); // 오른쪽 정렬
	}
	
	public static void main(String[] args) {
		int n = 8;
		int[] arr = {5,2,8,6,4,7,3,1};
		mergeSort(arr,n);
		
		
		

	}

}
