
public class HeapSort {

	private static int[] A;
	
	private static int heapSize;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A= new int[]{12,1,56,32,45,26,5,86,17,62,10,54,96,30,214,45,63,23,99};
		//A= new int[]{1, 5 ,10, 12, 17 ,23, 26 ,30, 32, 45, 45 ,54 ,56, 62, 63, 86, 96, 99, 214};
		heapSize = A.length;
		int[] sortedArray = new int[A.length];
		System.out.println("Before Sorting :");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println();
		heapSortProcedure(A,heapSize);
		System.out.println("After Sorting :");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
	}
	
	public static void heapSortProcedure(int[] A, int heapSize){
		buildMaxHeap(A);
		for(int i=heapSize-1; i>=1;i--){
			swap(A,0,i);
			heapSize=heapSize-1;			
			maxHeapify(A, 0,heapSize);
		}		
	}
	
	/*
	 * Build a max heap from a given array containing values
	 * A[PARENT(i)]>=A[i]
	 */
	public static void buildMaxHeap(int[] A){
		heapSize=A.length;
		for(int i=A.length/2;i>=0;i--)
			maxHeapify(A,i,heapSize);
	}
	
	/*
	 * maxHeapify lets value at A[i] float down in the max heap so subtree rooted at i obeys max heap property
	 */
	public static void maxHeapify(int[] A, int i, int heapSize){
		int left = leftChild(i);
		int right = rightChild(i);
		int largest = -1;
		boolean swapFlag=false;
		
		if(left<heapSize || right<heapSize){
		if(left < heapSize && A[left]>A[i]){
			largest = left;
			swapFlag=true;
		}else{
			largest=i;
			swapFlag=false;
		}
		if(right < heapSize && A[right]>A[largest]){
			largest = right;
			swapFlag=true;
		}
		if(swapFlag){
			swap(A,i,largest);
			maxHeapify(A,largest,heapSize);
		}
		}
		else return;
	}
	
	public static int leftChild(int i){
		return 2*i+1;
	}
	
	public static int rightChild(int i){
		return 2*i+2;
	}
	
	public static void swap(int[] A,int i , int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	

}
