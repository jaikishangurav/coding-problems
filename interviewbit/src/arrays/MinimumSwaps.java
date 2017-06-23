package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwaps {


    public static void main(String[] args) {
        Scanner sr=new Scanner(System.in);
        int n=sr.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sr.nextInt();
        int[] sorted=Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        int ans=minSwaps(a,sorted);
        reverse(sorted);
        int ansRev=minSwaps(a,sorted);
        System.out.println(Math.min(ans, ansRev));
    }
    
    private static int minSwaps(int[] a, int[] sorted){
    	int n=a.length;
    	int ans=0;
    	Map<Integer,Integer> map=new HashMap<>();
    	for(int i=0;i<n;i++){
    		map.put(a[i], i);
    	}
    	for(int i=0;i<n;i++){
    		if(a[i]!=sorted[i]){
    			int pos=map.get(sorted[i]);
    			swap(a,i,pos);
    			map.put(a[pos], pos);
    			ans++;
    		}
    	}
    	return ans;
    }
    
    private static void swap(int[] a,int i, int j){
    	int temp=a[i];
    	a[i]=a[j];
    	a[j]=temp;
    }
    
    public static void reverse(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n/2; i++) {
            swap(arr,i,n-i-1);
        }
    }
    
}
