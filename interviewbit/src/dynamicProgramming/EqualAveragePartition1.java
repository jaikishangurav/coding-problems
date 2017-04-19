package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EqualAveragePartition1 {

	static int total_size;
	static boolean[][][] dp;
	static ArrayList<Integer> original;
	static ArrayList<Integer> res=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{1, 7, 15, 29, 11, 9};
		System.out.println(arr.length);
		ArrayList<Integer> A=new ArrayList(Arrays.asList(arr));
		System.out.println(A.size());
		ArrayList<ArrayList<Integer>> result = avgset(A);
		System.out.println(result.size());
		for(ArrayList<Integer> list:result){
			System.out.println(list);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {
		Collections.sort(a);
		original=a;
		int total_sum=0;
		total_size=a.size();
		for(int i=0;i<total_size;i++)
			total_sum+=a.get(i);
		System.out.println("total_sum:"+total_sum);
		dp=new boolean[total_size][total_sum+1][total_size];
		for(int i=0;i<total_size;i++)
			dp[0][0][i]=true;
		ArrayList<Integer> res2=new ArrayList<>();
		for(int i=1;i<total_size;i++){
			System.out.println("Remainder:"+(total_sum*i)%total_size);
			if((total_sum*i)%total_size!=0)
				continue;
			int Sum_of_Set1=(total_sum*i)/total_size;
			System.out.println("Sum_of_Set1:"+Sum_of_Set1);
			if(isPossible(0, Sum_of_Set1, i)){
				System.out.println(res.size()+"||"+res);
				int ptr1=0,ptr2=0;
				ArrayList<Integer> res1=res;
				while(ptr1<a.size() || ptr2<res.size()){
					if(ptr2<res.size() && res.get(ptr2)==a.get(ptr1)){
						ptr1++;
						ptr2++;
						continue;
					}
					res2.add(a.get(ptr1));
					ptr1++;
				}
				ArrayList<ArrayList<Integer>> result=new ArrayList<>();
				result.add(res1);
				result.add(res2);
				return result;
			}
		}
		ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		return result;
        
	}
	
	public static boolean isPossible(int index, int sum, int sz){
		if(sz==0)
			return sum==0;
		System.out.println("total_size:"+total_size+" || original size:"+original.size()+" || index:"+index);
		if(index>=total_size)
			return false;
		System.out.println("dp["+index+"]["+sum+"]["+sz+"]:"+dp[index][sum][sz]);
		if(dp[index][sum][sz]==false)
			return false;
		if(sum>=original.get(index)){
			res.add(original.get(index));
			System.out.println("res:"+res.size()+"||"+res);
			if(isPossible(index+1,sum-original.get(index),sz-1))
				return true;
			res.remove(res.size()-1);
		}
		if(isPossible(index+1,sum,sz))
			return true;
		return dp[index][sum][sz]=false;
	}

}
