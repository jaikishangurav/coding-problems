package string;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(3));
	}
	
	public static String countAndSay(int a) {
	    String x="1";
	    if(a==1)
	        return x;
	    StringBuffer temp=new StringBuffer();
	    for(int i=1;i<a;i++){
	        int j=0;
	        int count=0;
	        char c=x.charAt(j);
	        boolean flag=false;
	        while(j<x.length()){
	            char n=x.charAt(j);
	            if(c==n){
	                count++;
	                flag=true;
	            }else{
	                temp.append(String.valueOf(count)).append(c);
	                c=n;
	                count=0;
	                flag=false;
	            }
	            if(flag){
	            	temp.append(String.valueOf(count)).append(c);
	            }
	            j++;
	        }
	        x=temp.toString();
	        System.out.println(x);
	        temp=new StringBuffer();
	    }
	    return x;
	}
}
