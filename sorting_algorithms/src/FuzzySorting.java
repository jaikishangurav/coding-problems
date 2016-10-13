/*
 * Represents closed intervals [r1,r2]
 * */
class ClosedInterval implements Comparable<ClosedInterval>{
	protected int a;
	protected int b;

	public ClosedInterval(int r1, int r2){
		this.a=r1;
		this.b=r2;
	}
	
	public ClosedInterval() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(ClosedInterval y) {
		if(this.a==y.a)
			return 0;
		else if(this.a<y.a)
			return -1;
		else
			return 1;
	}
	
	public int getA(){
		return a;
	}
	
	public int getB(){
		return b;
	}
	
}

public class FuzzySorting {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] vals = new int[]{3,4,5,9,2,5,1,2,7,8,4,6};
		ClosedInterval[] A = new ClosedInterval[vals.length/2];
		int j=0;
		for(int i=0; i<=vals.length-2;i=i+2){
			System.out.println(i+" "+vals[i]+","+vals[i+1]);
			A[j++]=new ClosedInterval(vals[i],vals[i+1]);
		}
		System.out.println("UnSorted Array:");
		for(ClosedInterval value :A)
		System.out.print("["+value.getA()+","+value.getB()+"], ");
		fuzzySort(A,0,A.length-1);
		System.out.println();
		System.out.println("Sorted Array:");
		
		for(ClosedInterval value :A)
		System.out.print("["+value.getA()+","+value.getB()+"], ");
	}
	
	private static void fuzzySort(Comparable[] A, int p, int s){
		if(s<=p)
			return;
		ClosedInterval pivot = findIntersection(A, p, s);
		display(A,"After findIntersection");
		int r=partitionRight(A,pivot.a,p,s);
		display(A,"After partitionRight");
		int q=partitionLeftMiddle(A,pivot.b,p,r);
		display(A,"After partitionLeftMiddle");
		fuzzySort(A,p,q-1);
		fuzzySort(A,r+1,s);
		
	}
	
	/*
	 * partition algo given in CLRS
	 */
	private static ClosedInterval findIntersection(Comparable[] A, int p, int s){
		ClosedInterval pivot =((ClosedInterval) A[s]);
		ClosedInterval intersect = new ClosedInterval();
		int i = p-1;
		
		//Find intersection of pivot and other interval
		for(i=p;i<s;i++){
			if(overlaps((ClosedInterval)A[i],pivot)){
				if(((ClosedInterval) A[i]).a>pivot.a)
					intersect.a = (int)((ClosedInterval)A[i]).a;
				if(((ClosedInterval)A[i]).b<pivot.b)
					intersect.b=(int)((ClosedInterval)A[i]).b;
			}
		}
		System.out.println("Intersect :["+intersect.a+","+intersect.b+"]");
	    return intersect;
	}
	
	/*
	 * partitions the array(p,s) such that p<s using left endpoint returned by findIntersection() as pivot.
	 * p<=r<=s
	 */
	private static int partitionRight(Comparable[] A, int pa, int p, int s){
		int i=p-1;
		for(int j=p;j<s;j++){
			if((int)((ClosedInterval)A[j]).a<=pa){
				i=i+1;
				exchange(A,i,j);
				//display(A,"Inside in partitionRight "+i+" , "+j+" , "+pa);
			}
		}
		exchange(A,i+1,s);
		return i+1;
	}
	
	/*
	 * partitions the array(p,r) such that p<=r<=s using the right endpoint returned by findIntersection() as pivot
	 * returns q such that p<=q<=r<=s
	 */
	private static int partitionLeftMiddle(Comparable[] A,int pb,int p,int r){
		int i=p-1;
		for(int j=p;j<r;j++){
			if((int)((ClosedInterval)A[j]).b<pb){
				i=i+1;
				exchange(A,i,j);
				
			}
		}
		
		exchange(A,i+1,r);
		return i+1;
	}
	
	/*
	 * return true if two intervals overlap
	 */
	private static boolean overlaps(ClosedInterval x, ClosedInterval y){
		return x.a<=y.b && y.a<=x.b;
	}
	
	
	private static void exchange(Comparable[] A, int i, int j){
		Comparable swap = A[i];
		A[i] = A[j];
		A[j] = swap;
		
	}
	
	private static void display(Comparable[] A, String message){
		System.out.println(message);
		for(Comparable value :A)
			System.out.print("["+((ClosedInterval)value).a+","+((ClosedInterval)value).b+"], ");
		System.out.println();
	}


}
