package binarysearch;

public class ImplementPowerFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ans:"+pow(8,8,5));
	}
	public static int pow(int x, int n, int d) {
	    long ans=1;
	    long sq=x;
	    if(x==0 && n==0){
	        return 0;
	    }
	    if(n==0){
	        return 1;
	    }
	    while(n!=0){
	        if(n%2==1){
	            ans=ans*sq;
	        }
	        System.out.println("AAA:"+ans);
	        sq=(sq*sq)%d;
	        System.out.println("BBB:"+sq);
	        n=n/2;
	        if(ans>d){
	            ans=ans%d;
	        }
	    }
	    return (int)ans;
	}

}
