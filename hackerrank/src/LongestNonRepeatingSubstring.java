import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubstring {
	
	 public static String longestSequenceMap(String input){
		 Map<Character, Integer> visited = new HashMap<>();
		 String output="";
		 for(int start=0, end=0; end<input.length();end++){
			 char curChar = input.charAt(end);
			 if(visited.containsKey(curChar)){
				start = Math.max(visited.get(input.charAt(end))+1, start);
			 }
			 if(output.length()<end-start+1){
				 output = input.substring(start,end+1);
			 }
			 visited.put(curChar, end);
		 }
		 return output;
	 }
	
    public static String longestSequence(String input){
        int start=0;
        int end=1;
        int curStart=0;
        int curEnd=1;
        for(int i=1;i<input.length();i++){
            String sub = input.substring(curStart,curEnd);
            if(!sub.contains(String.valueOf(input.charAt(i)))){
                curEnd=i+1;
                if(input.substring(curStart,curEnd).length()>input.substring(start,end).length()){
                    start=curStart;
                    end=curEnd;
                }
            }else{
            	
                int index = input.substring(0, i).lastIndexOf(input.charAt(i));
//                System.out.println("In else for i: "+i+" "+input.charAt(i)+" || "+index);
                if(curStart<=index){
                	curStart = index+1;
                	curEnd = i+1;
                }
            }
//            System.out.println("i:"+i+" || "+input.substring(0,i+1)+" || "+input.substring(curStart,curEnd)+" || "+input.substring(start,end)+ " || " +start +" || "+end+" || "+" || "+curStart+" || "+curEnd);
        }
        return input.substring(start,end);
    }
    
    public static void main(String args[]){
    	String input = "aabcbcdahef";
    	String output = longestSequence(input);
    	System.out.println(output);
    	output = longestSequenceMap(input);
    	System.out.println(output);
    }

}
