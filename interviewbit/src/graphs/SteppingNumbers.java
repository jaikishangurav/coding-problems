package graphs;

import java.util.ArrayList;
import java.util.Collections;

/* Problem Statement:https://www.interviewbit.com/problems/stepping-numbers/
 * */
public class SteppingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Brute Force Approach
	public ArrayList<Integer> stepnum(int a, int b) {
	    ArrayList<Integer> result=new ArrayList<>();
	    if(b<=10){
	        for(int i=a;i<=b;i++)
	            result.add(i);
	        return result;
	    }
	    if(b<a)
	        return result;
	    for(int i=a;i<=b;i++){
	        if(isSteppingNumber(i)){
	            result.add(i);
	        }
	    }
	    return result;
	}
	
	private boolean isSteppingNumber(int num){
	    int prev=num%10;
	    num=num/10;
	    while(num>0){
	        int cur=num%10;
	        if(Math.abs(cur-prev)!=1)
	            return false;
	        num=num/10;
	        prev=cur;
	    }
	    return true;
	}
	
	//Solution using DFS
	public ArrayList<Integer> stepnumDFS(int a, int b) {
	    ArrayList<Integer> result=new ArrayList<>();
	    int len=0;
	    int num=b;
	    while(num>0){
	        num/=10;
	        len++;
	    }
	    dfs(result,a,b,len,0);
	    Collections.sort(result);
	    return result;
	}
	
	private void dfs(ArrayList<Integer> result, int a, int b, int len, int num){
	    if(num>=a && num<=b)
	        result.add(num);
	    if(len==0)
	        return;
	  //we start from num=0. from 0 we can move to 1,2,3,4,5,6,7,8,9. 
	  //From 1 we can get 10 and 12. From 2 we can get 21 and 23. So we iterate for each value from 1 to 9 and call dfs method for each value. 
	    if(num==0){		
	        for(int i=1;i<=9;i++){
	            dfs(result,a,b,len-1,i);
	        }
	        return;
	    }
	    int cur=num%10;
	    if(cur==0){				//for example if current value of num is 10 then next number will be (10*10)+0+1=101
	        dfs(result,a,b,len-1,(num*10)+(cur+1));
	    }else if(cur==9){		//for example if current value of num is 19 then next number will be (19*10)+9-1)=198
	        dfs(result,a,b,len-1,(num*10)+(cur-1));
	    }else{					//if last digit in current value of num is neither 0 or 9. for example num is 12
	        dfs(result,a,b,len-1,(num*10)+(cur+1));		//next value will be (12*10)+2+1=123
	        dfs(result,a,b,len-1,(num*10)+(cur-1));		//next value will be (12*10)+2-1=121
	    }
	    
	}
	
}
