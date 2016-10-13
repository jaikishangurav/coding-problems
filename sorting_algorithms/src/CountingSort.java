import java.util.HashSet;


public class CountingSort {

	public static void main(String[] args) {
		int[] A= new int[]{12,1,56,32,45,26,5,86,17,62,10,54,96,30,21,45,63,23,99};
		//int[] A=new int[]{2,5,3,0,2,3,0,3};
		int[] B= new int[A.length];
		int k=0;
		System.out.println("Before Sorting :");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println();
		k=getmax(A)+1;
		System.out.println("k :"+k);
		countingSort(A,B,k+1);
		System.out.println("After Sorting :");
		for(int i=0;i<B.length;i++)
			System.out.print(B[i]+" ");
	}

	public static void countingSort(int[] A, int[] B, int k){
		int[] C= new int[k];
		for(int i=0;i<k;i++)
			C[i]=0;
		for(int j=0;j<A.length;j++)
			C[A[j]]=C[A[j]]+1;
		//C[i] now contains number of elements equal to i
		for(int i=1;i<k;i++)
			C[i]=C[i]+C[i-1];
		//C[i] now contains the number of elements less than or equal to i
		for(int j=A.length-1;j>=0;j--){
			B[C[A[j]]-1]=A[j];
			C[A[j]]=C[A[j]]-1;
			
		}

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
