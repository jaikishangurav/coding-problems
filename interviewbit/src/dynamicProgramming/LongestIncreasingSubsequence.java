package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15);
		System.out.println(lis(a));
		System.out.println(lis2(a));
		System.out.println(lis3(a));
	}

	public static int lis(final List<Integer> a) {
		List<Integer> b = new ArrayList<>(a);
		Collections.sort(b);
		int[][] mem = new int[a.size() + 1][a.size() + 1];
		for (int i = 0; i < mem.length; i++) {
			mem[i][0] = 0;
			mem[0][i] = 0;
		}
		int n = a.size();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.get(i - 1) == b.get(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1] + 1;
				} else {
					mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
				}
				//System.out.print(mem[i][j] + " ");
			}
			//System.out.println();
		}
		return mem[n][n];
	}

	public static int lis2(final List<Integer> a) {
		if (a.size() == 1)
			return 1;
		int n = a.size();
		int[] mem = new int[n];
		for (int i = 0; i < n; i++)
			mem[i] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a.get(i) > a.get(j) && mem[i] < mem[j] + 1)
					mem[i] = mem[j] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++)
			if (max < mem[i])
				max = mem[i];
		return max;
	}

	/**
	 * O(nlogn) approach
	 * 
	 * Case 1. If A[i] is smallest among all end candidates of active lists, we will
	 * start new active list of length 1. Case 2. If A[i] is largest among all end
	 * candidates of active lists, we will clone the largest active list, and extend
	 * it by A[i]. Case 3. If A[i] is in between, we will find a list with largest
	 * end element that is smaller than A[i]. Clone and extend this list by A[i]. We
	 * will discard all other lists of same length as that of this modified list.
	 */
	public static int lis3(final List<Integer> a) {
		int n = a.size();
		int[] tail = new int[n];
		int len = 0;
		tail[0] = a.get(0);
		len++;
		for (int i = 1; i < n; i++) {
			if (tail[0] > a.get(i)) {
				tail[0] = a.get(i);
			} else if (tail[len - 1] < a.get(i)) {
				tail[len++] = a.get(i);
			} else {
				int index = ceilIndex(tail, -1, len-1, a.get(i)); // left index sent to ceilIndex method is -1 instead of 0 as it failed for 1 hackerrank test case for index sent as 0. 
				tail[index]=a.get(i);
			}
		}
		return len;
	}

	private static int ceilIndex(int[] tail, int l, int r, int key) {
		while ((r - l) > 1) {
			int m = l + (r - l) / 2;
			if (tail[m] >= key) {
				r = m;
			} else {
				l = m;
			}
		}
		return r;
	}
}
