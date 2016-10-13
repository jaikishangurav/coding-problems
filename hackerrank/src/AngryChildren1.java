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
