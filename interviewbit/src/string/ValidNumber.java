package string;
/* Problem Statement:https://www.interviewbit.com/problems/valid-number/ 
 * */
public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans=isNumber("1.e1");
		System.out.println(ans);
	}
	
	public static int isNumber(final String a) {
	    String number=a.trim();
	    if(number.length()==0)
	        return 0;
	    if(number.length()==1)
	        return isDigit(number.charAt(0))?1:0;
	    int i=0;
	    if(number.charAt(i)=='+' || number.charAt(i)=='-')	//if first character is '+' or '-' then skip it
	        i++;
	    int num_count, decimal_count;
	    //count number of digits and decimal points before 'e'
	    for(num_count=0,decimal_count=0;(i<number.length() && (isDigit(number.charAt(i)) || number.charAt(i)=='.'));i++){
	        if(isDigit(number.charAt(i)))
	            num_count++;
	        else decimal_count++;
	    }
	    if(num_count<1 || decimal_count>1 || number.charAt(i-1)=='.')
	        return 0;
	    
	    //if exponent 'e' is present
	    if(i<number.length() && number.charAt(i)=='e'){
	        i++;
	        if(number.charAt(i)=='+' || number.charAt(i)=='-')		//if first character is '+' or '-' then skip it
	            i++;
	        num_count=0;
	        //check if there are only digits after exponent character 'e'
	        while(i<number.length() && isDigit(number.charAt(i))){		
	            i++;
	            num_count++;
	        }
	        if(num_count<1)
	            return 0;
	    }
	    return i==number.length()?1:0;
	}
	
	public static int isNumber2(final String a) {
	    String number=a.trim();
	    //System.out.println(number.length()+"::"+a.length());
	    if(number.length()==0)
	        return 11;
	    if(number.length()==1)
	        return isDigit(number.charAt(0))?1:0;
	    char prev=number.charAt(0);
	    if(prev!='+' && prev!='-' && prev!='.' && !isDigit(prev)){
	        System.out.println("Condition 3");
	    	return 12;
	    }
	    char curr;
	    for(int i=1;i<number.length();i++){
	        curr=number.charAt(i);
	        System.out.println("Current char: "+curr);
	        if(i==number.length()-1 && curr=='.')
	            return 13;
	        if(i==1 && (prev=='-' || prev=='+' || prev!='.') && !isDigit(curr) && curr!='.' && curr!='e'){
	            System.out.println(isDigit(curr));
	        	return 14;
	        }
	        if(!isDigit(curr) && curr!='e' && curr!='.')
	            return 15;
	        if(curr=='e'){
	            if(prev=='.' || !isDigit(prev))
	            	return 0;
	        	return checkExponent(a.substring(i+1));
	        }
	        prev=curr;
	    }
	    return 1;
	}
	
	private static int checkExponent(String exp){
	    for(int i=0;i<exp.length();i++){
	        char curr=exp.charAt(i);
	        if(i==0 && !isDigit(curr) && curr!='+' && curr!='-')
	            return 17;
	        if(i>0 && !isDigit(curr))
	            return 18;
	    }
	    return 1;
	}
	
	private static boolean isDigit(char c){
	    if(c>='0' && c<='9')
	        return true;
	    return false;
	}

}
