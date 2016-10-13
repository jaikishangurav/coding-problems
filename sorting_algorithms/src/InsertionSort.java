
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {56,23,100,99,20,51,25,05,36,151,11};
		sort(a);
		for(Integer value :a)
		System.out.print(value+" ");
			//{56,23,100,99,20,51,25,05,36,151,11};
	}
	
	private static void sort(Comparable[] a){
		int N = a.length;
		for(int i = 0; i<N; i++)
			for(int j=i; j>0; j--){
				if(less(a[j],a[j-1])){
					exchange(a,j,j-1);
				}
				else break;
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


