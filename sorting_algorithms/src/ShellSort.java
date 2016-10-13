
public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {56,23,100,99,20,51,25,05,36,151,11,63,52,45,456,32,525,61,626,94,212,5,02,62,51,55,212,22,655,22,336,55,2,1,5,6,22,5559};
		sort(a);
		for(Integer value :a)
		System.out.print(value+" ");
	}

	public static void sort(Comparable[] a){
		int N = a.length;
		System.out.println("Length :"+N);
		int h = 1;
		while(h<N/3)
			h=3*h+1;
			//System.out.println(h);
		
		while(h>=1){
			System.out.println(h);
			for(int i=h; i<N; i++){
				for(int j=i;j>=h && less(a[j],a[j-h]); j=j-h)
					exchange(a,j,j-h);
			}
			h=h/3;
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
