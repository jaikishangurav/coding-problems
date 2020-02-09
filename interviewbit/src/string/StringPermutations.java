package string;

public class StringPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutations("sir");
	}
	
	static void permutations(String str){
		permutations(str,"");
	}
	
	static void permutations(String str,String prefix){
		if(str.length()==0){
			System.out.println(prefix);
		}else{
			for(int i=0;i<str.length();i++){
				String rem=str.substring(0, i) + str.substring(i+1);
				permutations(rem, prefix+str.charAt(i));
			}
		}
	}
	
	

}
