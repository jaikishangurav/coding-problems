import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        sr.nextLine();
        List<int[]> lineList = new ArrayList<int[]>();
        int x,y=0;
        int d=0;
        int q=0;
        int lineArray[];
        for(int j=0;j<n;j++){
        d=sr.nextInt();
        lineArray = new int[d];
        for(int i=0;i<d;i++){       	
        	lineArray[i]=sr.nextInt();
        }
        lineList.add(lineArray);
        sr.nextLine();
        }
        q=sr.nextInt();
        for(int i=0;i<q;i++){
        	x=sr.nextInt();
        	y=sr.nextInt();
        	if(y<=(lineList.get(x-1)).length)
        		System.out.println(lineList.get(x-1)[y-1]);
        	else
        		System.out.println("ERROR!");
        	sr.nextLine();
        }
	}

}
