package bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DifferentBitsSumPairwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] arr=new Integer[]{3,5,4,2,456,3698,52147,85632,665555,99665555,9965222,988555};
		ArrayList<Integer> a =new ArrayList();
		//ArrayList<Integer> a = new ArrayList(Arrays.asList(arr));
		Random r=new Random();
		for(int i=0;i<10000;i++)
			a.add(r.nextInt(Integer.MAX_VALUE));
		System.out.println("calling");
		int ans=cntBits(a);
		System.out.println(ans);
	}
	public static int cntBits(ArrayList<Integer> A) {
        int n=A.size();
        long count=0;
        int ans=0;
        long x=1000000007l;
        for(int i=0;i<32;i++){
            count=0;
            for(int j=0;j<n;j++){
                if((A.get(j)&(1<<i))>0)
                    count++;
            }
            ans+=(count*(n-count)*2)%x;
            if(ans>=x)
            	ans-=x;
        }
        return ans;
    }
}
