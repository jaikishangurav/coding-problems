package string;
/*Find if Given number is power of 2 or not. 
More specifically, find if given number can be expressed as 2^k where k >= 1.
Input:
number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:
return 1 if the number if a power of 2 else return 0

Example:

Input : 128
Output : 1
See Expected Output

*/
public class PowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ispower=power("512");
		if(ispower==1)
			System.out.println("Number is power of 2");
		else System.out.println("Number is not a power of 2");
	}
	
	public static int power(String A) {
	    
	    String dividend = A;
	    StringBuilder str;
	    
	    if (A == null || A.length() == 0)
	        return 0;
	    
	    if (A.length() == 1 && A.charAt(0) == '0')
	        return 0;
	    
	    while (dividend.length() > 0 && !dividend.equalsIgnoreCase("2")) {
	        str = new StringBuilder();
	        int carry = 0;
	        int n = dividend.length();
	        
	        //check if number is not odd
	        if (n > 0) {
    	        int num = dividend.charAt(n - 1) - '0';
    	        
    	        if (num % 2 == 1)	//number is odd return 0
    	            return 0;
	        }
	        System.out.println("Dividend:"+dividend);
	        
	        for (int i = 0; i < n; i++) {
	            System.out.println("For i:"+i+" and char:"+dividend.charAt(i));
	            char c = (char) (dividend.charAt(i) - '0');
	            int res = c + 10 * carry;
	            System.out.println("c:"+String.valueOf(c)+"||res:"+res);
	            c = (char) (res / 2 + '0');
	            carry = res % 2;
	            System.out.println("c:"+c+"||carry:"+carry);
	            str.append(c);
	            System.out.println("str:"+str.toString());
	            System.out.println("*************************");
	        }
	        
	        if (str.charAt(0) == '0')
	            str.deleteCharAt(0);
	            
	        dividend = str.toString();
	    }
	    
	    return 1;
	    
	}

}
