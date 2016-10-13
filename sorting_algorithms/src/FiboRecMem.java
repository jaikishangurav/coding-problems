import java.util.Scanner;


public class FiboRecMem {

	static long d[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sr = new Scanner(System.in);
		n=sr.nextInt();
		d=new long[n+1];
		System.out.println("Time : "+System.currentTimeMillis());
		long value = fiboMemoization(n);
		System.out.println("Time : "+System.currentTimeMillis()+" :: RecMem "+n+"th value : "+value);
		value = fiboIterative(n);
		System.out.println("Time : "+System.currentTimeMillis()+" :: iterat "+n+"th value : "+value);
		value = fiboRec(n);
		System.out.println("Time : "+System.currentTimeMillis()+" :: Recurs "+n+"th value : "+value);
	}
	
	public static long fiboMemoization(int n){
		if(n==0 || n==1)
			return n;
		else if(d[n]!=0)
			return d[n];
		else{
			long fibValue = fiboMemoization(n-1)+fiboMemoization(n-2);
		d[n] = fibValue;
		return fibValue;
		}
	}
	
	public static long fiboIterative(int n){
		long n0=0;
		long n1=1;
		//System.out.print(n0+" "+n1+" ");
		for(int i=0;i<n-1;i++){
			long temp = n1;
			n1+=n0;
			n0=temp;
			//System.out.print(n1+" ");
			}
			return n1;
		}
	
	public static long fiboRec(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else 
			return fiboRec(n-1)+fiboRec(n-2);
	}

}
