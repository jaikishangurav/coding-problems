package algos.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Unfairness {
    
   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
      int K = Integer.parseInt(in.readLine());
      int[] list = new int[N];

      for(int i = 0; i < N; i ++)
         list[i] = Integer.parseInt(in.readLine());
      
      int unfairness = Integer.MAX_VALUE;
      int count = 0;
      Arrays.sort(list);
      int[] klist = new int[K];
      while(count+K<=N){
          for(int i=count;i<K;i++)
              klist[i]=list[i+count];
          unfairness=Math.min(unfairness,max(klist)-min(klist));
          count++;
      }     
      System.out.println(unfairness);
   }
    
    public static int max(int[] a){
	    	int max=a[0];
	        for(int i=1;i<a.length;i++){
	            if(a[i]>max)
	                max=a[i];
	        }
	        return max;
	    }
	    public static int min(int[] a){
	    	int min=a[0];
	        for(int i=1;i<a.length;i++){
	            if(a[i]<min)
	                min=a[i];
	        }
	        return min;
	        
	    }
}