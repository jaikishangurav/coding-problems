package bitManipulation;
/* Problem Statement:https://www.interviewbit.com/problems/number-of-1-bits/
 * */
public class NumberOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(11&1);
		System.out.println(numSetBits(11));
	}
	public static int numSetBits(long A) {
	    
	    int count = 0;
	    
	    while (A > 0) {
	        if ( (A & 1) != 0)
	            count++;
	        A >>= 1;
	    }
	    
	    return count;
	    
	}
	
	//Brian Kernighan’s Algorithm
	//Time Complexity:O(log(n))
	/*Subtraction of 1 from a number toggles all the bits (from right to left) till the rightmost set bit(including the righmost set bit). 
	 * So if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), we unset the righmost set bit. 
	 * If we do n & (n-1) in a loop and count the no of times loop executes we get the set bit count.
	   Beauty of the this solution is number of times it loops is equal to the number of set bits in a given integer.
	 * */
	public int numSetBits2(long a) {
	    int count=0;
	    while(a>0){
            a&=(a-1);
            count++;
        }
	    return count;
	}

}
