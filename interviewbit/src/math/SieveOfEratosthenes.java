package math;

import java.util.ArrayList;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n =100;
		ArrayList<Integer> ans =getPrimeNos(n);
		for(Integer a: ans)
				System.out.print(a+" ");
		
	}
	
	public static ArrayList<Integer> getPrimeNos(int a){
		int[] prime =new int[a+1];
		for(int i=2;i<a+1;i++)
			prime[i]=1;
		prime[0]=0;
		prime[1]=0;
		for(int i=2;i*i<=a;i++){
			if(prime[i]==0)
				continue;
			for(int j=i*2;j<=a;j+=i){
				prime[j]=0;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=2;i<a+1;i++){
			if(prime[i]==1)
				ans.add(i);
		}
		return ans;
	}

}
