package twopointers;

public class MaxSubArrayLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,9,6,8,5,6,3,4,12,6,5,6,4,2,0,3,6,9,1,3,1,1,5,2,6,7};
		int k=7;
		int maxlen=maxSubArrayLength(a, k);
		System.out.println("Max length of subarray:"+maxlen);
	}
	
	public static int maxSubArrayLength(int[] a,int k){
		int start=0;
		int n=a.length;
		int end=0;
		int cursum=0;
		int maxstart=start;
		int maxend=0;
		int maxlen=-1;
		while(end<n){
			cursum+=a[end++];
			if(cursum<k){								
				if(maxlen<end-start){
					maxlen=end-start;
					maxend=end;
					maxstart=start;
				}
			}else{
				while(cursum>=k){
					cursum-=a[start];
					start++;
				}				
				if(end<start)
					end=start;
			}
		}
		//if(maxlen<maxend-maxstart)
		//	maxlen=maxend-maxstart;
		System.out.println("Maximum length subarray is from index "+maxstart+" to "+(maxend-1));
		System.out.println("Max Subarray:");
		for(int i=maxstart;i<maxend;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		return maxlen;
		
	}

}
