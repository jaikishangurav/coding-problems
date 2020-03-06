package math;

public class ReverseInteger {

	public static void main(String[] args) {
		int num=-123;
		int reversed = reverse(num);
		System.out.println("Reverse using iteration : "+reversed);
		reversed = reverseRec(num);
		System.out.println("Reverse using recursion : "+reversed);
		int ans = -27/-5;		
		System.out.println(ans);
		ans = -27%5;		
		System.out.println(ans);

	}
	
	public static int reverse(int num) {
		long reverse=0;
		while(num!=0) {
			reverse = reverse*10 + num%10;
			num /=10;
			if(reverse>Integer.MAX_VALUE || reverse<Integer.MIN_VALUE) {
				return 0;
			}			
		}
		return (int)reverse;
	}
	
	public static int reverseRec(int num) {
		long reversed=0;
		return reverseRecursive(num, reversed);
		
	}
	
	private static int reverseRecursive(int num, long reversed) {
		if(num==0) {
			return (int)reversed;
		}
		int mod = num%10;
		reversed = reversed*10 + mod;
		if(reversed>Integer.MAX_VALUE || reversed<Integer.MIN_VALUE) {
			return 0;
		}
		return reverseRecursive(num/10, reversed);
	}

}
