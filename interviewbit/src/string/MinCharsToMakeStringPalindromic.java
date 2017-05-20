package string;
/*Minimum Characters required to make a String Palindromic
 * You are given a string. The only operation allowed is to insert characters in the beginning of the string. 
 * How many minimum characters are needed to be inserted to make the string a palindrome string

Example:
Input: ABC
Output: 2
Input: AACECAAAA
Output: 2
*/
public class MinCharsToMakeStringPalindromic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int charReq=minCharRequired("ACECAAA");
		System.out.println("Minimum character to be added at front to make string palindromic:"+charReq);
	}
	
	public static int minCharRequired(String a){
		String rev=new StringBuilder(a).reverse().toString();
		if(a.equals(rev))
			return 0;
		String str=a+"$"+rev;
		int m=str.length();
		int[] lps=new int[m];
		lps[0]=0;
		int i=1;
		int j=0;
		while(i<m){
			if(str.charAt(i)==str.charAt(j)){
				j++;
				lps[i]=j;
				i++;
			}else{
				if(j!=0){
					j=lps[j-1];
				}else{
					lps[i]=0;
					i++;
				}
			}
		}
		System.out.println("Longest proper prefix suffix array:");
		for(i=0;i<m;i++)
			System.out.print(str.charAt(i)+",");
		System.out.println();
		for(i=0;i<lps.length;i++)
			System.out.print(lps[i]+",");
		System.out.println();
		return a.length()-lps[m-1];
	}

}
