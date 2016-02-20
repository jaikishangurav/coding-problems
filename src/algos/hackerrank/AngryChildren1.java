/*Bill Gates is on one of his philanthropic journeys to a village in Utopia. He has N packets of candies and would like to distribute one packet to each of the K children in the village (each packet may contain different number of candies). To avoid a fight between the children, he would like to pick K out of N packets such that the unfairness is minimized.

Suppose the K packets have (x1, x2, x3,....xk) candies in them, where xi denotes the number of candies in the ith packet, then we define unfairness as

image1

where |a| denotes the absolute value of a.

Input Format
The first line contains an integer N.
The second line contains an integer K.
N lines follow each integer containing the candy in the ith packet.

Output Format
A single integer which will be minimum unfairness.*/

package algos.hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class AngryChildren1 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   static StringBuilder out = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		  int numPackets = Integer.parseInt(in.readLine());
	      int k = Integer.parseInt(in.readLine());
	      long[] packets = new long[numPackets];
	      long[] solPackets = new long[k];
	      for(int i = 0; i < numPackets; i ++)
	      {
	         packets[i] = Long.parseLong(in.readLine());
	      }
	      
	      long unfairness = Long.MAX_VALUE;
	      long res =0;
	      int m=0;
	      //sort to ascend order
	      Arrays.sort(packets);
	      
	      long[] cs = new long[numPackets];
	      cs[0]=packets[0];
	      for(int i=1;i<numPackets;i++)
	    	  cs[i]=cs[i-1]+packets[i];
	      
	      for(int i=0, t=i+k-1;t<numPackets;i++,t++){
	    	  if(i!=0){
	    		  //System.out.println("i:"+i);
	    		  res+=packets[i-1]*(k-1)+packets[t]*(k-1);
	    		  //System.out.println(res);
	    		  res-=((cs[t-1]-cs[i-1])*2);
	    		  //System.out.println(res);
	    		  //System.out.println("Min("+unfairness+", "+res+")");
	    		  unfairness=Math.min(unfairness, res);
	    	  }else{
	    		 m=k*(-1)+1;
	    		 //System.out.println("i:"+i);
	    		 for(int j=i;j<=t;j++, m+=2)
	                    res+=(packets[j] * m);
	    		 unfairness=res;
	    		 //System.out.println(res);
	    	  }
	      }
	      System.out.println(unfairness);
	}

}
