package arrays;

import java.util.ArrayList;
import java.util.Stack;

public class FindPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="DIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDID";
		int B=s.length()+1;
		ArrayList<Integer> res;
		res=findPerm(s, B);
		System.out.println(res);
		res=findPerm2(s, B);
		System.out.println(res);
		res=findPerm3(s, B);
		System.out.println(res);
	}
	public static ArrayList<Integer> findPerm(final String s, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int start=1;
        int upto=B;
        for(int i=0;i<B && start<upto;i++){
            if(s.charAt(i)=='D')
                res.add(upto--);
            else res.add(start++);
        }
        res.add(start);
        return res;
    }

	 public static ArrayList<Integer> findPerm2(final String s, int B) {
	        ArrayList<Integer> res = new ArrayList<>();
	        Stack <Integer> stack = new Stack<>();
	        int j = 0;
	        for (int i = 1; i <= s.length(); i++) {
	            if (s.charAt(i - 1) == 'I') {
	                stack.push(i);
	                while (!stack.isEmpty())
	                    res.add(stack.pop());
	            } else
	                stack.push(i);
	        }
	        stack.push(s.length() + 1);
	        while (!stack.isEmpty())
	            res.add(stack.pop());
	        return res;
	    }
	
	 public static ArrayList<Integer> findPerm3(final String A, int B) {
	        int[] val=new int[B];
	        int d_count=0;
	        int i_count=0;
	        for(int i=0;i<A.length();i++){
	            if(A.charAt(i)=='I')
	                i_count++;
	            else d_count++;
	            val[i]=i+1;
	        }
	        ArrayList<Integer> result=new ArrayList<>();
	        if(i_count==0){
	            for(int i=B;i>=1;i--){
	                result.add(i);
	            }
	            System.out.println("ASDF");
	            return result;
	        }else if(d_count==0){
	            for(int i=1;i<=B;i++){
	                result.add(i);
	            }
	            return result;
	        }
	        val[B-1]=B;
	        int j=B-i_count;
	        int i=j-1;
	        if(A.charAt(0)=='I'){
	            result.add(val[i]);
	            i--;
	        }else{
	            result.add(val[j]);
	            j++;
	        }
	        int k=0;
	        while(i>=0 && j<=B-1){
	            if(A.charAt(k)=='I'){
	                result.add(val[j]);
	                j++;
	            }else{
	                result.add(val[i]);
	                i--;
	            }
	            k++;
	        }
	        while(i>=0){
	            result.add(val[i]);
	            i--;
	        }
	        while(j<=B-1){
	            result.add(val[j]);
	            j++;    
	        }
	        return result;
	    }
}
