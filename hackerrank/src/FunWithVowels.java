import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FunWithVowels {

	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 */
		// BufferedReader aeiaaioooaauuaeiu

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine(); // Reading input from STDIN
		// System.out.println("Hi, " + name + "."); // Writing output to STDOUT
		/*
		 * //Scanner Scanner s = new Scanner(System.in); String name = s.nextLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); // Writing
		 * output to STDOUT
		 * 
		 */

		// Write your code here
		if (containsAllVowels(name)) {

			int[] dp = new int[name.length()];
			boolean firstOccurenceOfA = false;
			int indexOfFirstA = 0;
//			for (int i = 0; i < dp.length; i++) {
//				dp[i] = 1;
//			}
			for (int i = 0; i < name.length(); i++) {
				if (name.charAt(i) == 'a' && !firstOccurenceOfA) {
					indexOfFirstA = i;
					firstOccurenceOfA = true;
//					break;
				}
				if (!firstOccurenceOfA) {
					dp[i] = 0;
				} else {
					dp[i] = 1;
				}
			}
			for (int i = indexOfFirstA + 1; i < name.length(); i++) {
				if (validChar(name.charAt(i))) {
					for (int j = indexOfFirstA; j < i; j++) {
						if (validChar(name.charAt(j)) && isCharInSeq(name.charAt(i), name.charAt(j))
								&& name.charAt(i) >= name.charAt(j)) {
							dp[i] = Math.max(dp[i], dp[j] + 1);
						}
					}
				}
			}
//			Arrays.stream(dp).forEach(i -> System.out.print(i + ", "));
//			System.out.println();
			int maxLen = Integer.MIN_VALUE;
			for (int i = 0; i < dp.length; i++) {
				if (name.charAt(i) == 'u') {
					maxLen = Math.max(maxLen, dp[i]);
				}
			}
			System.out.println("Output : " + maxLen);
		} else {
			System.out.println(0);
		}

	}

	private static boolean containsAllVowels(String s) {
		return s.contains("a") && s.contains("e") && s.contains("i") && s.contains("o") && s.contains("u");
	}

	private static boolean validChar(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

	// a=97, e=101, i=105, o=111, u=117
	private static boolean isCharInSeq(char i, char j) {
		if (i - j == 4 || i - j == 4 || i - j == 6 || i - j == 6 || i - j == 0)
			return true;
		else
			return false;
	}
}

/*
 * Inputs aaaeeeeegjbodnodfnboidnbooofksdvipsfvifbondfbonfklkvssifuu 16
 * aeiaaioooaauuaeiu 10 aaejkioou 7
 */
