package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestAreaOfRectangleWithPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr={{1,0,1},{1,0,1},{1,0,1}};
		ArrayList<ArrayList<Integer>> a=new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			ArrayList<Integer> arrList=new ArrayList<>();
			for(int j=0;j<arr[0].length;j++){
				arrList.add(arr[i][j]);
			}
			a.add(arrList);
		}
		int area=solve(a);
		System.out.println(area);
	}
	public static int solve(ArrayList<ArrayList<Integer>> a) {
        int maxRow=0;
        int m=a.size();
        int n=a.get(0).size();
        int[][] aux=new int[m][n];
        for(int i=0;i<n;i++){
            aux[0][i]=a.get(0).get(i);
        }
        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
            	aux[i][j]=(a.get(i).get(j)==0)?0:aux[i-1][j]+1;                
            }
        }
        for (int i=0; i<m; i++)
        {
            int[] count = new int[m+1];
            for (int j=0; j<n; j++)
                count[aux[i][j]]++;     
            int col_no = 0;
            for (int j=m; j>=0; j--)
            {
                if (count[j] > 0)
                {
                    for (int k=0; k<count[j]; k++)
                    {
                        aux[i][col_no] = j;
                        col_no++;
                    }
                }
            }
        }
        int curr_area, max_area = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                curr_area=(j+1)*aux[i][j];
                max_area=Math.max(max_area,curr_area);
            }
        }
        return max_area;
    }
    
    private static void sort(int[][] aux,int rowIndex,int col){
        int[] count=new int[col+1];
        for (int i=0; i<col; ++i)
            count[i] = 0;
        for (int i=0; i<col; ++i)
            ++count[aux[rowIndex][i]];
        for (int i=1; i<=col; ++i)
            count[i] += count[i-1];
        int output[] = new int[col];
        for (int i = 0; i<col; ++i)
        {
            output[count[aux[rowIndex][i]]-1] = aux[rowIndex][i];
            --count[aux[rowIndex][i]];
        }
        System.out.println("for row :"+rowIndex);
        for (int i = 0; i<col; ++i){
            aux[rowIndex][col-i-1] = output[i];
            System.out.print(aux[rowIndex][col-i-1]+" ");        
        }
        System.out.println();
    }
}
