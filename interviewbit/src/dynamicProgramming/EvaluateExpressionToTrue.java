package dynamicProgramming;
/* Problem statement:https://www.interviewbit.com/problems/evaluate-expression-to-true/
 * Explanation:
 * We have these & | and ^ operators
 * & operator evaluates to true if left and right expression evaluates to true.
 * | operator evaluates to true in all cases except when left and right expression both evaluate to false.
 * ^ operator evaluates to true if and only if left and right expression have opposite values.
 * 
 * Recurrence Relation:
 * Let T[i][j] be # of ways to parenthesize symbols i to j such that sub-expression evaluates to true.
 * Let F[i][j] be # of ways to parenthesize symbols i to j such that sub-expression evaluates to false.
 * Let Total[i][j] be the # of ways to parenthesize symbols i to j. Total[i][j]=T[i][j]+F[i][j].
 * T[i][j]=Sum of all k=i to j-1 for
 * 			{T[i][k] * T[k+1][j]										when operator is '&'
 * 			 Total[i][k] * Total[k+1][j] - F[i][k] * F[k+1][j]			when operator is '|'
 * 			 T[i][k] * F[k+1][j] + F[i][k] * T[k+1][j]					when operator is '^'
 * 			}
 * Total[i][j]=T[i][j] + F[i][j]
 * 
 * F[i][j]=Sum of all k=i to j-1 for
 * 			{Total[i][k] * Total[k+1][j] - T[i][k] * T[k+1][j]			when operator is '&'
 * 			 F[i][k] * F[k+1][j]										when operator is '|'
 * 			 T[i][k] * T[k+1][j] + F[i][k] * F[k+1][j]					when operator is '^'
 * 			}
 * Total[i][j]=T[i][j] + F[i][j]
 * 
 * Base Cases:
 * T[i][i] = 1 if symbol[i] = 'T' 
 * T[i][i] = 0 if symbol[i] = 'F' 
 * F[i][i] = 1 if symbol[i] = 'F' 
 * F[i][i] = 0 if symbol[i] = 'T'
 * 
 * */
import java.util.ArrayList;
import java.util.List;

public class EvaluateExpressionToTrue {

	private static final int MOD=1003;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression="T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
		int ways=cnttrue(expression);
		System.out.println(expression);
		System.out.println("No of ways in which above expression evaluates to true : "+ways);
	}

	public static int cnttrue(String a) {
		List<Character> symb=new ArrayList<>();
	    List<Character> oper=new ArrayList<>();
	    for(int i=0;i<a.length();i++){
	        if(a.charAt(i)=='T' || a.charAt(i)=='F')
	            symb.add(a.charAt(i));
	        else oper.add(a.charAt(i));
	    }
	    int n=symb.size();
	    int[][] F=new int[n][n];
	    int[][] T=new int[n][n];
	    
	    for(int i=0;i<n;i++){
	        F[i][i]=(symb.get(i)=='F')?1:0;
	        T[i][i]=(symb.get(i)=='T')?1:0;
	    }
	    for(int gap=1;gap<n;gap++){
	        for(int i=0,j=gap;j<n;i++,j++){
	            T[i][j]=F[i][j]=0;
	            for(int k=i;k<j;k++){
	                int tik=T[i][k] + F[i][k];  //calculate Total[i][k]
                    int tkj=T[k+1][j] + F[k+1][j];  //calculate Total[k+1][j]
                    
                    if(oper.get(k)=='&'){
                        T[i][j]+=T[i][k]*T[k+1][j];
                        F[i][j] += (tik*tkj - T[i][k]*T[k+1][j]);
                    }
                    if (oper.get(k) == '|')
                    {
                        F[i][j] += F[i][k]*F[k+1][j];
                        T[i][j] += (tik*tkj - F[i][k]*F[k+1][j]);
                    }
                    if (oper.get(k) == '^')
                    {
                        T[i][j] += F[i][k]*T[k+1][j] + T[i][k]*F[k+1][j];
                        F[i][j] += T[i][k]*T[k+1][j] + F[i][k]*F[k+1][j];
                    }
                    T[i][j]%=MOD;
                    F[i][j]%=MOD;
	            }
	        }
	    }
	    return T[0][n-1];
	}


}
