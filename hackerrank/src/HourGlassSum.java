import java.util.Scanner;


public class HourGlassSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
		int i=0;
		String line;
		int maxSum=Integer.MIN_VALUE;
		int sum=0;
		int[][] a = new int[6][6];
		String[] lineValues = new String[6]; 
		while(i<6){
			line = sr.nextLine();
			lineValues = line.split(" ");
			for(int j=0; j<6; j++)
				a[i][j] = Integer.parseInt(lineValues[j]);
			i++;
		}
		for(i=0;i<4;i++){
			for(int j=0;j<4;j++){
				sum=a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
				System.out.println(sum);
				if(sum>maxSum)
					maxSum=sum;
			}
		}
		System.out.println(maxSum);
	}

}
