package dynamicProgramming;

public class EqualAveragePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2, 4, 4, 5, 6, 6, 7, 8, 9, 12};
		partitionEqualAvg(A);
	}
	
	public static void partitionEqualAvg(int [] A) {
		  int n = A.length;
		  int s = sumOfArray(A);
		  //double avg = (double)S/(double)n;
		  double avg = s/n;
		  int subsetLen = n/2;
		  int x=0;
		  int [][][] T = new int[s+1][n+1][n+1];
		   
		  for (int i=0; i<=n; i++) {
		   T[0][0][i] = 1;
		  }
		  int[][] res=new int[s+1][n+1];
		  for(int i=0;i<=s;i++)
			  for(int j=0;j<=n;j++)
				  res[i][j]=-1;
		  T[0][0][0]=1;
		  for(int i=0;i<=s;i++){
			  for(int j=1;j<=n;j++){
				  for(int k=1;k<=n;k++){
					  if((x=i-A[k-1])>=0){
						  if(T[x][j-1][k-1]==1){
						  if(res[i][j]==-1)
							  res[i][j]=A[k-1];
						  }
						  T[i][j][k]=T[i][j][k-1] | T[x][j-1][k-1];
					  }else T[i][j][k]=T[i][j][k-1];
				  }
			  }
		  }
		  double min=Double.MAX_VALUE;
		  int mark_i=0,mark_j=0;
		  double temp_avg=0.0,diff=0.0;
		  for(int i=0;i<=s;i++){
			  for(int j=1;j<=n/2;j++){
				  if(T[i][j][n]==1){
					  temp_avg=i*1.0/j;
					  if((diff=Math.abs(avg-temp_avg))<min){
						  min=diff;
						  mark_i=i;
						  mark_j=j;
					  }
				  }
			  }
		  }
		  while(mark_j!=0){
			  System.out.println(res[mark_i][mark_j]);
			  mark_i=mark_i-res[mark_i][mark_j--];
		  }
		 }
	
	public static int sumOfArray(int [] A) {
		  int len = A.length;
		  int sum = 0;
		  for (int i=0; i<len; i++) {
		   sum += A[i];
		  }
		  return sum;
		 }

}
