
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {56,23,100,99,20,51,25,05,36,151,11,63,52,45,456,32,525,61,626,94,212,5,02,62,51,55,212,22,655,22,336,55,2,1,5,6,22,5559};
		//Integer[] a ={1,2,3,4,5,6,7,8};
		System.out.println("Unsorted Array");
		for(Integer value :a)
			System.out.print(value+" ");
		System.out.println();
		sort(a);
		System.out.println("Sorted Array:");
		for(Integer value :a)
		System.out.print(value+" ");
	}
	
	private static void sort(Comparable[] a){
		//StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi<=lo)
			return;
		int j = partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	/*
	 * Tony Hoare partition algo
	 */
	private static int partition(Comparable[] a, int lo, int hi){
		int i=lo;
		int j=hi+1;
		while(true){
			while(less(a[++i],a[lo])){
				if(i==hi)
					break;}
			while(less(a[lo],a[--j])){
				//if(j==lo)
					//break;
				}
			if(i>=j)
				break;
			exchange(a, i, j);
		}
		exchange(a,lo,j);
		return j;
	}
	
	/*
	 * partition algo given in CLRS
	 */
	private static int partitionCLRS(Comparable[] a, int lo, int hi){
		int x = (int) a[hi];
		int i = lo-1;
		for(int j=lo;j<hi;j++){
			if(less(a[j],x)){
				i+=1;
				exchange(a,i,j);
			}
		}
		exchange(a,i+1,hi);
		return i+1;
	}
	
	private static boolean less(Comparable v, Comparable w){
		//System.out.println("v :"+v+" w :"+w);
		return v.compareTo(w) < 0;
	}
	
	private static void exchange(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	
	

}
