package math;

public class TrailingZerosInFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trailingZeroes(9247);
	}
	
	public static int trailingZeroes(int a) {
	    long nfact=1;
	    System.out.println(nfact);
	    for(int i=1;i<=a/2;i++){
	        nfact*=i*(a+1-i);
	        System.out.println(nfact);
	    }
	    System.out.println(nfact);
	    if(a%2==1)
	        nfact*=(a+1)/2;
	    int count=0;
	    System.out.println(nfact);
	    while(nfact>0){
	        if(nfact%10==0){
	            count++;
	            nfact/=10;
	        }else break;     
	    }
	    return count;
	}

}
