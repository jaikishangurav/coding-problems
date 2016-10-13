package algos.hackerrank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt(); //size of set e.g. {1,2,3} n=3
		int[] set = new int[n];
		for(int i =0;i<n;i++)
			set[i]=sr.nextInt();
		List<List<Integer>> list = powerSet(set);
		System.out.println(list);
	}
	
	public static List<List<Integer>> powerSet(int[] s){
		List<List<Integer>> res = new ArrayList<>();
		if(s.length==0){
			res.add(new ArrayList<Integer>()); //returns empty list to add to powerset
			return res;
		}
		//Arrays.sort(s);
		int head = s[0];
		int[] rest = new int[s.length-1];   //new array to store relative complement of head in s
		System.arraycopy(s, 1, rest, 0, s.length-1); //copies  element in s present after head
		for(List<Integer> list : powerSet(rest)){
			//System.out.println("list:"+list);
			List<Integer> tempList = new ArrayList<>();
			//System.out.println("head:"+head);
			tempList.add(head); 			//adds head to list
			tempList.addAll(list);			//adds one element of final powerset to temp list 
			//System.out.println("powerset:"+tempList);
			res.add(list);					//add list to final result
			res.add(tempList);				//adds templist to final result
			//System.out.println("res:"+res);
		}
		return res;
	}
	
	 
}
