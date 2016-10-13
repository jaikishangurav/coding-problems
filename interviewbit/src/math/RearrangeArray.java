package math;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{4,0,2,1,3}; 
		ArrayList<Integer> a=new ArrayList(Arrays.asList(arr));
		arrange(a);
	}
	
	public static void arrange(ArrayList<Integer> a){
		int n=a.size();
		for(int i=0;i<n;i++){
			int temp=a.get(a.get(i))%n*n;
			a.set(i, a.get(i)+temp);
			display(a);
		}
		for(int i=0;i<n;i++)
			System.out.println("a["+i+"]="+a.get(i));
	}
	public static void display(ArrayList<Integer> a){
		for(int i=0;i<a.size();i++)
			System.out.print(a.get(i)+" ");
		System.out.println();
	}

}
