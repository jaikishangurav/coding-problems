
public class BottomUpMergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {56,23,100,99,20,51,25,05,36,151,11,63,52,45,456,32,525,61,626,94,212,5,02,62,51,55,212,22,655,22,336,55,2,1,5,6,22,5559};
		for(Integer value :a)
			System.out.print(value+" ");
		System.out.println();
		sort(a);
		for(Integer value :a)
		System.out.print(value+" ");
	}
	
	private static void sort(Comparable a[]){
		int N = a.length;
		Comparable aux[] = new Comparable[a.length];
		for(int sz=1; sz<N; sz=sz+sz){
			for(int lo=0; lo<N-sz; lo+=sz+sz){
				merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
			}
		}
	}
	
	private static void merge(Comparable a[], Comparable aux[],int lo,int mid,int hi){
		for(int k=0; k<a.length;k++)
			aux[k]=a[k];
		int i = lo;
		int j = mid+1;
		for(int k=lo;k<=hi;k++){
			if(i > mid)
				a[k]=aux[j++];
			else if(j>hi)
				a[k]=aux[i++];
			else if(less(aux[i],aux[j]))
				a[k]=aux[i++];
			else 
				a[k]=aux[j++];
		}
		
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}

}
