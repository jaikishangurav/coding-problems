package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* Problem Statement
 * Minimum sum
An array X consists of N integers. The indices of any two elements of the array can be swapped with each other.

Write a program to find the minimum contiguous sum of the elements of the array that is obtained by performing a maximum of K swaps in the array.
(The resulting contiguous sub-array that is selected for the optimal answer should not be empty).

Input format
First line: T (Number of test cases)
First line in each test case: 
N and K
Second line in each test case: 
N space-separated integers (denoting the elements of the array X)

Output format 
For each test case, print the minimum contiguous sum of the elements that is obtained by performing at most K swaps.

Constraints

1≤T≤10 
1≤N≤100
1≤K≤100
−100000≤X[i]≤100000(X[i] denotes the ith element of the array X)

Sample Input			Sample Output
2						-5
3 2						-3
1 -5 2
4 1
3 -2 1 -1

Explanation
For second testcase we can perform at most 1 swap and if we swap the position of 1 and -1 then we can get the minimum contiguous sum -3.
 * 
 * */
public class MinimumSum {
    static Scanner scanner;
    public static void main(String args[] ) throws Exception {
		scanner=new Scanner(System.in);
	    int T=scanner.nextInt();
	
	    while(T>0){
	    int N=scanner.nextInt();
	    int K=scanner.nextInt();
	    int[] array=new int[N];
	     for(int i=0;i<array.length;i++)
	     {
	        array[i]=scanner.nextInt();
	    }
	
	
	     System.out.println(findingMinimumSumSubarray(array, K));
	
	        T--;
	    }
}

public static int findingMinimumSumSubarray(int[] values, int k) {
 int N = values.length;
 int res = values[0]; 
 for (int L = 0; L < N; L++) {
     for (int R = L; R < N; R++) {
         List<Integer> A= new ArrayList<Integer>();
         List<Integer> B = new ArrayList<Integer>(); 
         int ashu = 0; 
         for (int i = 0; i < N; i++) {
             if (i >= L && i <= R) {
              A.add(values[i]);
                 ashu += values[i];
             } else {
                 B.add(values[i]);
             }
         }

         Collections.sort(A);

         Collections.sort(B);
         Collections.reverse(B);
         res = Math.min(res, ashu); 
         for (int t = 1; t <= k; t++) {

             if (t > A.size() || t > B.size()) break;

             ashu -= A.get(A.size() - t);
             ashu += B.get(B.size() - t);
             res = Math.min(res, ashu);
         }
     }
 }
 return res;
}
}