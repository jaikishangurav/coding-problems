package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxRectangleInBinaryMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[][] matrix=new Integer[][]{{1,0,0,1,1,1},{1,0,1,1,0,1},{0,1,1,1,1,1},{0,0,1,1,1,1}};
		ArrayList<ArrayList<Integer>> input=new ArrayList<>();
		for(int i=0;i<matrix.length;i++){
			ArrayList<Integer> temp=new ArrayList<>();
			for(int j=0;j<matrix[0].length;j++){
				temp.add(matrix[i][j]);
			}
			input.add(temp);
		}
		int maxArea=maximalRectangle(input);
		System.out.println("Max Rectangle area:"+maxArea);
	}
	
	public static int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
	    int n=a.size();
	    int m=a.get(0).size();
	    int[] dp=new int[m];
	    Arrays.fill(dp,0);
	    int area=0;
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            if(a.get(i).get(j)==1){
	                dp[j]+=1;
	            }else{
	                dp[j]=0;
	            }
	        }
	        area=Math.max(area,calculateHistogramArea(a.get(i),dp));
	    }
	    return area;
	}
	private static int calculateHistogramArea(ArrayList<Integer> row,int[] input){
	    Deque<Integer> stack = new LinkedList<Integer>();
	    int area=0;
	    int i;
	    int maxArea=0;
	    for(i=0;i<input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
	        }else{
	            int top = stack.pollFirst();
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
	    }
	    while(!stack.isEmpty()){
            int top = stack.pollFirst();
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
	}

}
