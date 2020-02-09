package stacksAndQueues;

import java.util.Stack;

/*Problem statement:This is not from interviewbit.
 * Given a string pattern consisting only of 'I's and 'D's generate number such that if I is encountered the number in pattern should greater than previous and 
 * if D is encounter then number in the pattern should be less than previous. The number should minimum number that follows the pattern
 * Constraints:
 * There can be maximum 8 characters in string pattern.
 * Digits in the interger pattern should repeat. Digits can range from 1-9.
 * 
 * For example
 *   Input: D        Output: 21
 *   Input: I        Output: 12
 *   Input: DD       Output: 321
 *   Input: II       Output: 123
 *   Input: DIDI     Output: 21435
 *   Input: IIDDD    Output: 126543
 *   Input: DDIDDIID Output: 321654798
 *   For input D 32 is also a solution that follows the pattern but it is not minimum number possible.
 * */

public class NumberPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input=new String[]{"D","I","DD","II","DIDI","IIDDD","DDIDDIID"};
		for(int i=0;i<input.length;i++){
			int ans=minimumNumberPattern(input[i]);
			System.out.println("Input :"+input[i]+" Output :"+ans);
		}
	}
	
	public static int minimumNumberPattern(String pattern){
		int n=pattern.length();
		Stack<Integer> stack=new Stack<>();
		StringBuilder result=new StringBuilder();
		
		for(int i=0;i<=n;i++){
			
			// push number i+1 into the stack
			stack.push(i+1);
			
			 // if all characters of the input sequence are
	        // processed or current character is 'I'
	        // (increasing)
			if(i==n || pattern.charAt(i)=='I' ){	//i==n condition should be first otherwise IndexOutOfBounds exception will be thrown when i becomes = to n.
				
				// run till stack is empty
				while(!stack.isEmpty()){
					
					// remove top element from the stack and
	                // add it to solution
					result.append(String.valueOf(stack.peek()));
					stack.pop();
				}
			}
		}
		//System.out.println(result.toString());
		return Integer.parseInt(result.toString());
		
	}

}
