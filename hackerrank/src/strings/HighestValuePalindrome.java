package strings;

import java.util.Scanner;

/*
 * Problem Statement: https://www.hackerrank.com/challenges/richie-rich/problem
 * */
public class HighestValuePalindrome {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		String s = scanner.nextLine();
		String result = highestValuePalindrome(s, n, k);

		System.out.println(result);

		scanner.close();
	}

	// Complete the highestValuePalindrome function below.
	static String highestValuePalindrome(String s, int n, int k) {
		int l = 0;
		int r = n - 1;
		int diffCount = 0;
		StringBuilder sb = new StringBuilder(s);
		while (l <= r) {
			if (sb.charAt(l) != sb.charAt(r)) {
				diffCount++;
			}
			l++;
			r--;
		}
		if (diffCount > k) {
			return "-1";
		}

		l = 0;
		r = n - 1;
		while (l <= r) {
			if (l == r) {
				if(sb.charAt(l)!='9' && k>0){
						sb.setCharAt(l, '9');
						k--;
				}
			} else {
				if (sb.charAt(l) == sb.charAt(r) && sb.charAt(l) != '9') {
					if (k >= diffCount + 2) {
						sb.setCharAt(l, '9');
						sb.setCharAt(r, '9');
						k = k - 2;
					}
				} else if (sb.charAt(l) != sb.charAt(r)) {
					if (sb.charAt(l) == '9' || sb.charAt(r) == '9') {
						if (sb.charAt(l) == '9') {
							if (k >= diffCount) {
								sb.setCharAt(r, '9');
								k--;
								diffCount--;
							} else
								return "-1";
						} else {
							if (k >= diffCount) {
								sb.setCharAt(l, '9');
								k--;
								diffCount--;
							} else
								return "-1";
						}
					} else {
						if (k >= diffCount + 1) {
							sb.setCharAt(l, '9');
							sb.setCharAt(r, '9');
							k = k - 2;
							diffCount--;
						} else if (k == diffCount) {
							if (sb.charAt(l) < sb.charAt(r)) {
								sb.setCharAt(l, sb.charAt(r));
							} else {
								sb.setCharAt(r, sb.charAt(l));
							}
							k--;
							diffCount--;
						} else
							return "-1";
					}
				}
			}
			l++;
			r--;
		}
		return sb.toString();
	}

}
