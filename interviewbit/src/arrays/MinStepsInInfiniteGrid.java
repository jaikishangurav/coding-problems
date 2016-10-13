package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MinStepsInInfiniteGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
		ArrayList<Integer> X =new ArrayList<>();
		ArrayList<Integer> Y =new ArrayList<>();
		int n=sr.nextInt();
		for(int i=0;i<n;i++)
			X.add(sr.nextInt());
		int r=Integer.MAX_VALUE;
		n=sr.nextInt();
		for(int i=0;i<n;i++)
			Y.add(sr.nextInt());
		System.out.println(coverPoints(X,Y));	
	}
	
	public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int n = X.size();
        int step=0;
        int x0=0;
        int y0=0;
        int x1=0;
        int y1=0;
        for(int i=0;i<n-1;i++){
         {   x1=X.get(i+1);
            y1=Y.get(i+1);
            x0=X.get(i);
            y0=Y.get(i);           
            int a=Math.abs(x0-x1);
            int b=Math.abs(y0-y1);
            step+=Math.max(a, b);
        }
    }
    return step;
}

}

//8 4 8 -7 -5 -13 9 -7 8 
//8 4 -15 -10 -3 -13 12 8 -8 
