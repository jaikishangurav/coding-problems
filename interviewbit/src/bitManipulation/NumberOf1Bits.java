package bitManipulation;

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

}
