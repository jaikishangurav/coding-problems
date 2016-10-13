
public class PriorityQueue {

	private static int[] A;
	
	private static int heapSize;
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int heapMaximum(){
		return A[0];
	}
	
	protected int heapExtractMax(int[] A) throws Exception{
		if(heapSize<0)
			throw new Exception("Heap underflow");
		int max = A[0];
		A[0]=A[heapSize];
		heapSize-=heapSize;
		HeapSort.maxHeapify(A, 1, heapSize);
		return max;
	}
	
	protected void heapIncreaseKey(int[] A, int i, int key) throws Exception{
		if(key<A[i])
			throw new Exception("New key is smaller than current key");
		else{
			A[i]=key;
			while(i>0 && A[parent(i)]<A[i]){
				swap(A,i,parent(i));
				i=parent(i);
			}
		}
	}
	
	protected void maxHeapInsert(int[] A, int key) throws Exception{
		heapSize = heapSize-1;
		A[heapSize] = Integer.MIN_VALUE;
		heapIncreaseKey(A, heapSize, key);
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
	
	public static int parent(int i){
		if(i%2==0)
			return i/2-1;
		else
			return i/2;
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
