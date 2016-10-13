/*Little Bob loves chocolate, and he goes to a store with $N$N in his pocket. 
 * The price of each chocolate is $C$C. The store offers a discount: for every MM wrappers he gives to the store, he gets one chocolate for free. 
 * How many chocolates does Bob get to eat?

Input Format:
The first line contains the number of test cases, T.
T lines follow, each of which contains three integers, N, C, and M.

Output Format:
Print the total number of chocolates Bob eats.*/

package algos.hackerrank;

import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
		int t=sr.nextInt();
		for(int i=0;i<t;i++){
		int n=sr.nextInt();
		int c=sr.nextInt();
		int m=sr.nextInt();
		int count=0;
		count=n/c;
		int temp=count;
		count+=wrapper(temp,m);

		
		System.out.println(count);
		}
	}
	
	private static int wrapper(int t,int m){
		int count=0;
		if(t/m>0){
			count = t/m;
			count+=wrapper(count+t%m,m);
		}
		return count;
	}

}
