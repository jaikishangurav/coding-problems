package greedyAlgorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class Seats {
	private static final int MOD = 10000003;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="....x..xx...x..";
		System.out.println("Input String");
		for(int i=0;i<a.length();i++)
			System.out.print(a.charAt(i)+" ");
		System.out.println();
		System.out.println(seats1(a));
	}
	
	//Time complexity:O(n) Space Complexity:O(n)
	public int seats(String a) {
	    int n=a.length();
        int i=0,j=0;
        Deque<int[]> dq=new ArrayDeque<>();
        while(j<n){
        	while(j<n && a.charAt(j)=='.')
        		j++;
        	if(j==n)
        		break;
        	for(i=j;j<n && a.charAt(j)=='x';j++){
        	}
        	dq.add(new int[]{i,j-1});        		
        }
        int count=0;
        while(dq.size()>1){
        	int[] left=dq.peekFirst();
        	int[] right=dq.peekLast();
        	int lenLeft=left[1]-left[0]+1;
        	int lenRight=right[1]-right[0]+1;
        	
        	if(lenLeft<=lenRight){
        		left=dq.pollFirst();
        		count+=lenLeft*(dq.peekFirst()[0]-left[1]-1);
        		dq.peekFirst()[0]-=lenLeft;
        	}else{
        		right=dq.pollLast();
        		count+=lenRight*(right[0]-dq.peekLast()[1]-1);
        		dq.peekLast()[1]+=lenRight;
        	}
        }
        return count;
        
	}
	
    //interviewbit solution
	////Time complexity:O(n) Space Complexity:O(1)
	public static int seats1(String A) {
	    int n;
	    int i;
	    int first, last;
	    int countLeft[];
	    int total = 0;
	    int midVal;
	    
	    if (A == null || A.length() == 0)
	        return 0;
	    
	    n = A.length();
	    countLeft = new int[n];
	    first = last = -1;
	    
	    for (i = 0; i < n; i++) {
	        countLeft[i] = i > 0 ? countLeft[i - 1] : 0;
	        
	        if (A.charAt(i) == 'x') {
	            if (first == -1)
	                first = i;
	            last = i;
	            countLeft[i]++;
	            total++;
	        }
	    }
	    System.out.println("First:"+first+"||Last:"+last+"||Total:"+total);
	    display(countLeft,"countLeft");
	    midVal = (total + 1) / 2;
	    System.out.println("MidVal:"+midVal);
        if (first == -1 || first == last)
            return 0;
	    
	    int mid;
	    
	    for (i = first; i <= last; i++) {
	        if (countLeft[i] == midVal)
	            break;
	    }
	    
	    mid = i;
	    System.out.println("Mid:"+mid);
	    long res = 0;
	    int count = 0;
	    
	    for (i = mid; i >= first; i--) {
	        if (A.charAt(i) == 'x') {
	            res += (mid - i - count);
	            res %= MOD;
	            count++;
	        }
	    }
	    
	    count = 0;
	    
	    mid++;
	    for (i = mid; i <= last; i++) {
	        if (A.charAt(i) == 'x') {
	            res += (i - mid - count);
	            res %= MOD;
	            count++;
	        }
	    }
	    
	    return (int) res;
    }
	public static void display(int[] a,String des){
		System.out.println(des+":");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
