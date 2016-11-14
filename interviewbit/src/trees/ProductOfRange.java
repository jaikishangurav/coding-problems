package trees;

import java.util.Scanner;
//Code uses segment tree to store product of range of largest divisor pf array
public class ProductOfRange {

	public static void main(String args[] ) throws Exception {
        Scanner sr = new Scanner(System.in);
        int N = sr.nextInt();
		int[] input=new int[N];
		//read input from console and store largest divisor of each value read in an array
        for (int i = 0; i < N; i++) {
            int num=sr.nextInt();
            input[i]=largestDivisor(num);
            System.out.print(input[i]+" ");
        }
        System.out.println();
        int x = (int) (Math.ceil(Math.log(N) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x);
        //System.out.println(max_size);
        int[] segT=new int[max_size];
        buildSegmentTree(input,segT,0,N-1,0); //builds segment tree of the input array storing range of product
        for(int i=0;i<segT.length;i++){
        	System.out.print(segT[i]+" ");
        }
        System.out.println();
        int T=sr.nextInt();
        //reads test cases containing lower and upper bound of range and prints the product of largest divisors of range 
        for(int i=0;i<T;i++){
        	int lo=sr.nextInt();
        	int hi=sr.nextInt();
        	int res=getQueryRes(segT,lo-1,hi-1,0,N-1,0);
        	System.out.println(res);
        }
    }
    
    private static void buildSegmentTree(int[] input, int[] segT, int lo, int hi, int pos){
    	if(lo==hi){
    		segT[pos]=input[lo];
    		return;
    	}
    	int mid=lo+(hi-lo)/2;
    	buildSegmentTree(input,segT,lo,mid,2*pos+1);
		buildSegmentTree(input,segT,mid+1,hi,2*pos+2);
		segT[pos]=segT[2*pos+1]*segT[2*pos+2];
    }
    
    private static int getQueryRes(int[] segT,int rlow,int rhigh,int low,int high,int pos){
		if(rlow<=low && rhigh>=high){
			return (int) (segT[pos]%(Math.pow(10,9)+7));
		}
		if(rlow>high || rhigh<low){
			return 1;
		}
		int mid=low+(high-low)/2;
		return (int) ((getQueryRes(segT,rlow,rhigh,low,mid,2*pos+1)*getQueryRes(segT,rlow,rhigh,mid+1,high,2*pos+2))%(Math.pow(10,9)+7));
    	
    }
    
    private static int largestDivisor(int a){
    	int ans=0;
    	if(a<=2)
    		return 1;
    	for(int i=2;i<=a/2;i++){
    		if(a%i==0){
    			ans=a/i;
    			break;
    		}
    	}
    	return ans;
    }

}
