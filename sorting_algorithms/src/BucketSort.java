import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[] A=new float[]{0.253f,0.547f,0.363f,0.045f,0.263f,0.963f,0.510f,0.654f};
		System.out.println("Before Sorting :");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println();
		bucketSort(A);
		
	}
	
	public static void bucketSort(float[] A){
		List<Float>[] bucket = new ArrayList[10];
		int n = A.length;
		for(int j=0;j<bucket.length;j++)
			bucket[j]=new ArrayList<>();
		for(int i=0;i<A.length;i++){
			bucket[(int) (10*A[i])].add(A[i]);
		}
		for(int i=0;i<bucket.length;i++)
			Collections.sort(bucket[i]);
		System.out.println("After Sorting :");
		display(bucket);
	}

	public static void display(List<Float>[] bucket){
	for(int i=0;i<bucket.length;i++){
		for(int j=0;j<bucket[i].size();j++)
			System.out.print(bucket[i].get(j)+" ");
	}
}
}
