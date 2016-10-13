package algos.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HackerX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int[] t=new int[n];
		int[] m=new int[n];
		List<Integer> hm = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			t[i]=sr.nextInt();
			m[i]=sr.nextInt();
			if(hm.isEmpty())
				hm.add(m[i]);
			
		}
	}

}
