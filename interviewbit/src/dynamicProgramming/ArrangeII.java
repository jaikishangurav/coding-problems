package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/arrange-ii/
 * Recurrence Relation:
 * R(currentHorse,currentStable)= min(Rec(i+1,nextStable)+(White_Horses * Black Horses in Current_Stable)) for i=currentHorse to number of horses
 * */

public class ArrangeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="WBWB";
		int b=2;
		int ans=arrangeRec(a, b);
		System.out.println("Ans using recursion:"+ans);
		ans=arrangeDP1(a, b);
		System.out.println("Ans using DP:"+ans);
	}
	
	public static int arrangeRec(String a, int b){
		if(a.length()<b)
			return -1;
		return arrangeRec(0,0,a,b);
	}
	
	private static int arrangeRec(int currentHorse, int currentStable, String a, int b){
		if(currentHorse==a.length()){
			if(currentStable==b)
				return 0;
			return -1;
		}
		if(currentStable==b)
			return -1;
		int W=0;
		int B=0;
		int ans=Integer.MAX_VALUE;
		for(int i=currentHorse;i<a.length();i++){
			if(a.charAt(i)=='W')
				W++;
			else B++;
			if(W*B>ans) 
				break;
			int temp=arrangeRec(i+1,currentStable+1,a,b);
			if(temp!=-1)
				ans=Math.min(ans, temp+(W*B));
		}
		return ans;
		
	}
	
	//Dynamic Programming approach
	//dp[i][j]=min{dp[k][j-1]+whiteCount*blackCount} where 0<=k<=(i-1)
	//Explanation: https://codevillage.wordpress.com/2016/09/06/mastering-dynamic-programming-2/
	public static int arrangeDP1(String A, int B) {
        int N = A.length();
        int[][] dp = new int[N][B];
        
        if(A.length() < B) return -1;
        int whiteCount=0;
        int blackCount=0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i)=='W')
                whiteCount++;
                else blackCount++;
            dp[i][0] = whiteCount*blackCount;
        }
        
        for(int j=1;j<B;j++){   //iterate over stables
            for(int i=0;i<A.length();i++){  //iterates over horses count
                if(j>i){
                    dp[i][j]=Integer.MAX_VALUE;
                }else{
                    whiteCount=0;
                    blackCount=0;
                    int minValue=Integer.MAX_VALUE;
                    for(int k=i-1;k>=0;k--){	//calculates minimum value in (j-1)th stable and for each horse
                        if(A.charAt(k+1)=='W')
                            whiteCount++;
                        else blackCount++;
                        if(dp[k][j-1]+whiteCount*blackCount>=0){
                            minValue=Math.min(minValue, dp[k][j-1]+whiteCount*blackCount);
                        }
                    }
                    dp[i][j]=minValue;
                }
            }
        }
        return dp[A.length()-1][B-1];
    }
	
	//Dynamic Programming approach
	public static int arrangeDP2(String A, int B) {
        int N = A.length();
        int[][] dp = new int[N + 1][B + 1];
        
        if(A.length() < B) return -1;
        
        for(int i = 1; i <= A.length(); i++){
            dp[i][1] = product(A, 0, i - 1);
        }
        
        // Product
            for(int k = 2; k <= B; k++){
                for(int j = k; j <= N; j++){
                    int min = Integer.MAX_VALUE;
                    for(int i = k - 1; i <= j - 1; i++){
                        dp[j][k] =  Math.min((dp[i][k - 1] + product(A, i, j - 1)), min);//i = 2 j = 4
                        min = dp[j][k];
                    }
                }
            }
        return dp[A.length()][B];
    }
    
    private static int product(String A, int start, int end){
        int W = 0, B = 0;
        for(int i = start; i <= end; i++){
            if(A.charAt(i) == 'W') W++;
            else if(A.charAt(i) == 'B') B++;
        }
        return W * B;
    }

}
