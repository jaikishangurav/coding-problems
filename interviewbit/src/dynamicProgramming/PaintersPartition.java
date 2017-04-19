package dynamicProgramming;

public class PaintersPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[]{100, 200, 300, 400, 500,600, 700, 800, 900};
		int best=partition(a,a.length,3);
		System.out.println(best);
	}
	private static int partition(int[] a,int n, int k){
		if(k==1){
			return sum(a,0,n-1);
		}
		if(n==1)
			return a[0];
		int best=Integer.MAX_VALUE;
		for(int j=1;j<n;j++){
			best=Math.min(best, Math.max(partition(a,j,k-1), sum(a,j,n-1)));
			System.out.println(best);
		}
		return best;
	}
	private static int sum(int[] a, int from, int to){
		int total=0;
		for(int i=from;i<=to;i++){
			total+=a[i];
		}
		return total;
	}
}
