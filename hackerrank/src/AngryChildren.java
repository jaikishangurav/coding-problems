import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AngryChildren {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   static StringBuilder out = new StringBuilder();

	   public static void main(String[] args) throws NumberFormatException, IOException {
	      int numPackets = Integer.parseInt(in.readLine());
	      int numKids = Integer.parseInt(in.readLine());
	      long[] packets = new long[numPackets];
	      long[] solPackets = new long[numKids];
	      for(int i = 0; i < numPackets; i ++)
	      {
	         packets[i] = Long.parseLong(in.readLine());
	      }
	      
	      long unfairness = Long.MAX_VALUE;
	      
	      //sort to ascend order
	      Arrays.sort(packets);
	      System.out.println("Packets");
	      displayArray(packets);
	      
	      //bucket to put candy for the number of kids
	      long[] sample = new long[numKids];
	      
	      //start element for each loop
	      int count=0;
	      //current position
	      int pos=0;

	      //until array is not out of bound from current position
	      while(count<=(numPackets-numKids)){
	      
	      //mark current starting position
	      pos=count;

	      //put the candy to the bucket
	      for(int i=0;i<numKids;i++){
	      sample[i]=packets[pos++];
	      }
	       displayArray(sample);
	       System.out.println(max(sample) - min(sample));
	      //compare the minimum unfairness
	      if(unfairness > max(sample) - min(sample) ){
	    	  unfairness = max(sample) - min(sample) ;
	    	  for(int i=0;i<sample.length;i++){
	    		  solPackets[i]=sample[i];
	    		  //System.out.print(solPackets[i]+" ");
	    	  }
	      }
	       count++;	           
	      }
	      displayArray(solPackets);
	      unfairness=0;
	      long[] arraySum = new long[numKids+1];
	      arraySum[0]=0;
	      for(int i=1;i<=solPackets.length;i++){
	    	  unfairness+=solPackets[i-1]*(i-1)-arraySum[i-1];
	    	  arraySum[i]=Math.abs(arraySum[i-1]+solPackets[i-1]);
	      }
	      /*
	      for(int i=0;i<solPackets.length;i++)
	    	  for(int j=i;j<solPackets.length;j++){
	    		  if(solPackets[i]!=solPackets[j])
	    			  unfairness+=Math.abs(solPackets[i]-solPackets[j]);
	    		  //System.out.println(solPackets[i]+"-"+solPackets[j]+"="+Math.abs(solPackets[i]-solPackets[j]));
	    	  }*/
	      System.out.println(unfairness);
	   }
	    
	    public static long max(long[] a){
	    	long max=a[0];
	        for(int i=1;i<a.length;i++){
	            if(a[i]>max)
	                max=a[i];
	        }
	        return max;
	    }
	    public static long min(long[] a){
	    	long min=a[0];
	        for(int i=1;i<a.length;i++){
	            if(a[i]<min)
	                min=a[i];
	        }
	        return min;
	        
	    }
	    
	    private static void displayArray(long[] array){
	    	for(int i=0;i<array.length;i++)
	    		System.out.print(array[i]+" ");
	    	System.out.println();
	    }
	    
}