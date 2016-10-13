package backtracking;

import java.util.ArrayList;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result=grayCode(3);
		System.out.println("*****Result****");
		System.out.println(result);
		result=grayCode1(3);
		System.out.println("*****Result1****");
		System.out.println(result);
	}
	
	public static ArrayList<Integer> grayCode(int n) {
	    if(n==0){
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        //display(result,0);
        return result;
    }
 
    ArrayList<Integer> result = grayCode(n-1);
    //display(result,1);
    int numToAdd = 1<<(n-1);
    //System.out.println("numToAdd"+numToAdd);
 
    for(int i=result.size()-1; i>=0; i--){
        result.add(numToAdd+result.get(i));
        //display(result,2);
    }
 
    return result;
	}

	//Approach 2
	public static ArrayList<Integer> grayCode1(int n) {
		int size=1<<n;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<size;i++){
			int num=(i>>1)^i;
			result.add(num);
		}
		
		return result;
	}
	public static void display(ArrayList<Integer> temp,int i){
		System.out.println(i+":"+temp);
	}
}
