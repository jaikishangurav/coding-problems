package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[] arr = new Integer[] {0, 0, -1, 0};
        ArrayList<Integer> a=new ArrayList<>(Arrays.asList(arr));
        System.out.println(maxset(a));

	}
	
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    long maxSum=0;
	    long curSum=0;
	    int maxStart=-1,maxEnd=-1;
	    int curStart=0,curEnd=0;
	    int len=a.size();
	    ArrayList<Integer> maxList=new ArrayList<>();
	    while(curEnd<len){
	    	Integer val=a.get(curEnd);
	        if(val>=0){
	            curSum+=val;
	            if(curSum>maxSum){
	            	maxSum=curSum;
	            	maxStart=curStart;
	            	maxEnd=curEnd+1;
	            }else if(curSum==maxSum){
	            	if(curEnd+1-curStart>maxEnd-maxStart){
	            		maxStart=curStart;
	            		maxEnd=curEnd+1;
	            	}
	            }
	        }else{
	        	curStart=curEnd+1;
	        	curSum=0;
	        }
	        curEnd++;
	    }
	    System.out.println(maxStart+" "+maxEnd);
	    if(maxStart==-1 || maxEnd==-1){
	    	maxList.clear();
	    	return maxList;
	    }
	    for(int j=maxStart;j<maxEnd;j++){
	    	maxList.add(a.get(j));
	    }
	    return maxList;
	}

}
