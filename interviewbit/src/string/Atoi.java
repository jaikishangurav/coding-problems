package string;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(atoi("12365+6541"));
	}
	public static int atoi(final String a) {
	    int n=a.length();
	    int space=0;
	    if(a==null||a.isEmpty())
	        return 0;
	    while(space<n){
	        if(a.charAt(space)==' ')
	            space++;
	        else
	            break;
	    }
	    if(space==n)
	        return 0;
	    StringBuffer sb=new StringBuffer();
	    boolean isNegative=false;
	    if(a.charAt(space)=='+' || a.charAt(space)=='-' && isValid(a.charAt(space+1))){
	    	sb.append(a.charAt(space++));
	    }
	    while(space<n){
	        char c=a.charAt(space);
	        if(isValid(c)){
	        	sb.append(c);
	        	if(sb.length()>=10){
	        		if(isOverflow(Long.parseLong(sb.toString()))){
	        			
	        		}
	        	}
	        	space++;  
	        }else{
	            break;
	        }
	    }
	    if(sb.length()==0)
	    	return 0;
	    StringBuffer temp=new StringBuffer();
	    temp=sb;
	    if(isNegative){
	    	sb=new StringBuffer();
	    	sb.append("-").append(temp);
	    }
	    int ans=0;
	    try{
	    ans=Integer.parseInt(sb.toString());
	    }catch(NumberFormatException e){
	    	if(sb.toString().startsWith("-"))
	    		return Integer.MIN_VALUE;
	    	else
	    		return Integer.MAX_VALUE;
	    }
	    
	   return (int)ans;
	}
	public static boolean isValid(char c){
	    if(c>='0'&&c<='9'){
	        return true;
	    }
	    return false;
	}
	
	public static boolean isOverflow(long a){
		if(a>)
	}

}
