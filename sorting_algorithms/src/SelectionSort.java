public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {56,23,100,99,20,51,25,05,36,151,11};
		sort(a);
		for(Integer value :a)
		System.out.print(value+" ");
			//{56,23,100,99,20,51,25,05,36,151,11};
	}
	
	public static void sort(Comparable[] a){
		int N = a.length;
		for(int i =0; i<N; i++){
			int min = i;
			for(int j=i+1; j<N; j++){
				if(less(a[j],a[min]))
					min = j;
			}
			exchange(a,i,min);
		}
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exchange(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
