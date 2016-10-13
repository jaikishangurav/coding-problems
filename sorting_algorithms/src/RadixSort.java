import java.util.Arrays;


public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A= new int[]{12,1,56,32,45,26,5,86,17,62,10,54,96,30,21,45,63,23,99};
		int[] A=new int[]{253,547,363,045,263,963,510,654};
		System.out.println("Before Sorting :");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println();
		radixSort(A);
		System.out.println("After Sorting :");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
	}
	
	public static void radixSort(int[] A){
		int max=getmax(A);
		
		for(int exp=1;max/exp>0;exp*=10)
			countingSort(A,exp);
	}
	
	public static void countingSort(int[] A, int exp){
		int[] C= new int[10];
		int[] B = new int[A.length]; 
		Arrays.fill(C, 0);
		for(int j=0;j<A.length;j++)
			C[(A[j]/exp)%10]=C[(A[j]/exp)%10]+1;
		//C[i] now contains number of elements equal to i
		for(int i=1;i<10;i++)
			C[i]=C[i]+C[i-1];
		//C[i] now contains the number of elements less than or equal to i
		for(int j=A.length-1;j>=0;j--){
			B[C[(A[j]/exp)%10]-1]=A[j];
			C[(A[j]/exp)%10]=C[(A[j]/exp)%10]-1;
			
		}
		for(int i=0;i<A.length;i++)
			A[i]=B[i];

	}
	
	public static int getmax(int[] A){
		int k=0;
		for(int i=0;i<A.length;i++){
			if(A[i]>k)
				k=A[i];			
		}
		return k;
	}

}
