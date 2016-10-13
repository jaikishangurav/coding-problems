import java.util.Date;
import java.util.Scanner;


public class Fibonaci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sr = new Scanner(System.in);
		n=sr.nextInt();
		System.out.println(new Date());
		fibo(n);
		System.out.println();
		System.out.println(new Date());
		//int sum = fiboRec(n);
		//System.out.println(sum);
		//System.out.println(new Date());
		
		
		
	}
	
	public static void fibo(int n){
		int n0=0;
		int n1=1;
		System.out.print(n0+" "+n1+" ");
		for(int i=0;i<n-1;i++){
			int temp = n1;
			n1+=n0;
			n0=temp;
			System.out.print(n1+" ");
			}
			
		}
	
	public static int fiboRec(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else 
			return fiboRec(n-1)+fiboRec(n-2);
	}
	}


