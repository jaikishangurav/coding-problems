package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{3,5,4,2,1};
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
		System.out.println(wave(a));
	}
	
	public static ArrayList<Integer> wave(ArrayList<Integer> a) {
	    Collections.sort(a);
	    int n=a.size();
	    int count=0;
	    for(int i=2;i<n;i=i+2){
	        int temp=a.get(i-2);
	        a.set(i-2, a.get(i-1));
	        a.set(i-1, temp);
	    }

	    return a;     
	}

}
