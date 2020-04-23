package strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



/*
 * Problem Statement: https://www.hackerrank.com/challenges/richie-rich/problem
 * */

public class SherlockAndAnagrams {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();
			int result = sherlockAndAnagrams(s);
			System.out.println(result);
		}

		scanner.close();
	}

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
        int n = s.length();
        int substringLen = 1;
        int anagramCount = 0;
        int subCount=0;
        while (substringLen <= n - 1) {
            Set<String> testedString = new HashSet<>();
            for (int i = 0; i < n - substringLen; i++) {
                subCount=0;
                String sub = s.substring(i, i + substringLen);
                char[] sortedSub = sub.toCharArray();
                Arrays.sort(sortedSub);
                sub = new String(sortedSub);
                subCount++;
                if (!testedString.contains(sub)) {
                    testedString.add(sub);
                } else {
                    continue;
                }
                for (int j = i + 1; j <= n - substringLen; j++) {
                    String anagram = s.substring(j, j + substringLen);
                    char[] sortedAnagram = anagram.toCharArray();
                    Arrays.sort(sortedAnagram);
                    anagram = new String(sortedAnagram);
                    if (sub.equals(anagram)) {
                        subCount++;
                    }
                }
                if(subCount>1){
                    anagramCount+=subCount * (subCount-1)/2;
                }
            }
            substringLen++;
        }
        return anagramCount;
	}

}
