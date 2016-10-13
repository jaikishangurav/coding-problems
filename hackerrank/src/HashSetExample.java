import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
		int t = sr.nextInt();
		sr.nextLine();
		Set<String> lineSet = new HashSet<String>();
		lineSet.clear();
		for(int i=0;i<t;i++){
		String line = sr.nextLine();
		lineSet.add(line);
		//System.out.println(lineSet);
		System.out.println(lineSet.size());
		}
	}

}
