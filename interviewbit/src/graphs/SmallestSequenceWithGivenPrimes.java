package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestSequenceWithGivenPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p1=2,p2=3,p3=5;
		int k=5;
		solve3(p1, p2, p3, k);
	}
	
	//Time Complexity : O(n) where n=D
	 public ArrayList<Integer> solve(int A, int B, int C, int D) {
	        ArrayList<Integer> result=new ArrayList<>();
	        int[] primes=new int[3];
	        primes[0]=A;
	        primes[1]=B;
	        primes[2]=C;
	        int[] times=new int[3];
	        Arrays.sort(primes);
	        result.add(1);
	        for(int i=1;i<=D;i++){
	            int min=Integer.MAX_VALUE;
	            for(int j=0;j<primes.length;j++){
	                min=Math.min(min,primes[j]*result.get(times[j]));
	            }
	            result.add(min);
	            for(int j=0;j<times.length;j++){
	                if(result.get(times[j])*primes[j]==min)
	                    times[j]++;
	            }
	        }
	        result.remove(0);
	        return result;
	    }
	 
	 public static ArrayList<Integer> solve3(int p1,int p2,int p3,int k)
		{
			ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
			int[] nextBestNumbers = new int[3];
			int[] currIndex = new int[3];
			int[] prime = new int[3];

			nextBestNumbers[0] = prime[0] = p1;
			nextBestNumbers[1] = prime[1] = p2;
			nextBestNumbers[2] = prime[2] = p3;

			currIndex[0] = currIndex[1] = currIndex[2] = -1;

			for(int j=1;j<=k;j++)
			{
				int nextNumber = Math.min(nextBestNumbers[0],Math.min(nextBestNumbers[1],nextBestNumbers[2]));
				finalAnswer.add(nextNumber);

				for(int i=0;i<3;i++)
				{
					if(nextNumber==nextBestNumbers[i])
					{
						currIndex[i]++;
						nextBestNumbers[i] = finalAnswer.get(currIndex[i])*prime[i];
						display(currIndex,"currIndex");
						display(nextBestNumbers,"nextBestNumbers");
						System.out.println();
					}
				}
			}

			return finalAnswer;
		}

	//Time Complexity : O(nlog(n)) where n=D
		 public ArrayList<Integer> solve2(int A, int B, int C, int D) {
			 ArrayList<Integer> result=new ArrayList<>();
		     PriorityQueue<Integer> queue=new PriorityQueue<>();
		     Set<Integer> set=new HashSet<>();
		     if(set.add(A))
		    	 queue.add(A);
		     if(set.add(B))
		    	 queue.add(B);
		     if(set.add(C))
		    	 queue.add(C);
		     int count=0;
		     while(count<D){
		    	 int num=queue.poll();
		    	 result.add(num);
		    	 count++;
		    	 if(!set.contains(num*A)){
		    		 queue.add(num*A);
		    		 set.add(num*A);
		    	 }
		    	 if(!set.contains(num*B)){
		    		 queue.add(num*B);
		    		 set.add(num*B);
		    	 }
		    	 if(!set.contains(num*C)){
		    		 queue.add(num*C);
		    		 set.add(num*C);
		    	 }		    	
		     }
		     return result;
		 }
		 
		 private static void display(int[] dp,String name){
			 System.out.print(name+"[");
			 for(int i=0;i<dp.length;i++)
				 System.out.print(dp[i]+" ");
			 System.out.println("]");
		 }
	 
}
