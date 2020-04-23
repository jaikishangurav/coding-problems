package greedyAlgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * Problem Statement : https://www.hackerrank.com/challenges/morgan-and-a-string/problem
 * */

public class MorganAndString {

	// Complete the morganAndString function below.
	static String morganAndString(String a, String b) {
		int i = 0;
		int j = 0;
		StringBuilder s1 = new StringBuilder(a).append('z');
		StringBuilder s2 = new StringBuilder(b).append('z');
		StringBuilder output = new StringBuilder();
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) < s2.charAt(j)) {
				output.append(s1.charAt(i));
				i++;
			} else if (s1.charAt(i) > s2.charAt(j)) {
				output.append(s2.charAt(j));
				j++;
			} else {
				// reached end of string
				if (s1.charAt(i) == 'z' && s2.charAt(j) == 'z') {
					i++;
					j++;
					continue;
				}

				int startingI = i;
				int startingJ = j;

				// Find the point where the equality of 2 string diverges
				while (s1.charAt(i) == s2.charAt(j)) {
					i++;
					j++;

					// They are the same string
					if (i >= s1.length() && j >= s2.length()) {
						i = startingI;
						j = startingJ;
						break;
					}

					// String 1 is shorter than string 2
					if (i >= s1.length()) {
						char prev = s2.charAt(startingJ);
						while (prev >= s2.charAt(startingJ)) {
							output.append(s2.charAt(startingJ));
							prev = s2.charAt(startingJ);
							startingJ++;
						}
						i = startingI;
						j = startingJ;
					}

					// String 2 is shorter than string 1
					if (j >= s2.length()) {
						char prev = s1.charAt(startingI);
						while (prev >= s1.charAt(startingI)) {
							output.append(s1.charAt(startingI));
							prev = s1.charAt(startingI);
							startingI++;
						}
						i = startingI;
						j = startingJ;
					}
				}

				// the two string are different

				// String 1 is lexicographically smaller than string 2
				if (s1.charAt(i) <= s2.charAt(j)) {
					char prev = s1.charAt(startingI);
					while (s1.charAt(startingI) <= prev) {
						output.append(s1.charAt(startingI));
						prev = s1.charAt(startingI);
						startingI++;
					}
					i = startingI;
					j = startingJ;
				}

				if (s2.charAt(j) < s1.charAt(i)) {
					char prev = s2.charAt(startingJ);
					while (s2.charAt(startingJ) <= prev) {
						output.append(s2.charAt(startingJ));
						prev = s2.charAt(startingJ);
						startingJ++;
					}
					i = startingI;
					j = startingJ;
				}

			}
		}

		// reached end of 1 string
		if (i < s1.length()) {
			output.append(s1.substring(i, s1.length()));
		} else if (j < s2.length()) {
			output.append(s2.substring(j, s2.length()));
		}
		return output.toString();

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String a = scanner.nextLine();

			String b = scanner.nextLine();

			String result = morganAndString(a, b);
			System.out.println(result);
			// bufferedWriter.write(result);
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}
