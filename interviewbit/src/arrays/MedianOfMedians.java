package arrays;

import java.util.Arrays;

public class MedianOfMedians {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2,5,9,19,24,54,5,87,9,10,44,32,21,13,2,4,18,26,16,19,25,39,47,56,71,91,6,1,44,28 };
		int medOfMed = medOfMedians(arr);
		System.out.println("Result : "+medOfMed);
	}

	public static int getMedian(int[] arr, int start, int end) {
		Arrays.sort(arr, start, end);
		int n= (end + start)/ 2;
		return arr[n];
	}

	public static int medOfMedians(int[] arr) {
		// median array size
		int size=arr.length;
		int mSize = arr.length / 5 ;
		if(arr.length % 5!=0)
			mSize++;
		int[] median = new int[mSize];
		int i = 0;
		for (i = 0; i < arr.length / 5; i++) {
			median[i] = getMedian(arr, i * 5, i * 5 + 5);
			System.out.println(median[i]);
		}
		if (arr.length % 5 != 0) {
			median[i] = getMedian(arr, i * 5, arr.length);
		}

		int medOfMed = getMedian(median, 0, median.length);
		return medOfMed;
	}

}
