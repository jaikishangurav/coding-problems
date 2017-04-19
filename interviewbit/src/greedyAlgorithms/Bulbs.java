package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] state=new Integer[]{0, 1, 0, 1};
		ArrayList<Integer> stateList=new ArrayList<>(Arrays.asList(state));
		int ans=bulbs(stateList);
		System.out.println(ans);
		ans=bulbs2(stateList);
		System.out.println(ans);
	}

	public static int bulbs(ArrayList<Integer> a) {
        if(a.size()==0)
            return 0;
        int n=a.size();
        int ans=0;
        boolean flipped=false;
        for(int i=0;i<n;i++){
            if(flipped==false){
                if(a.get(i)==0){
                    ans++;
                    flipped=true;
                }
            }else{
                if(a.get(i)==1){
                    ans++;
                    flipped=false;
                }
            }
        }
        return ans;
    }
	
	public static int bulbs2(ArrayList<Integer> a){
		int state=0;
		int ans=0;
		for(int i=0;i<a.size();i++){
			if(a.get(i)==state){
				ans++;
				state=1-state;
			}
		}
		return ans;
	}
}
