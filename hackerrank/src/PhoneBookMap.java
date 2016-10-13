import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PhoneBookMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
        int n = Integer.parseInt(sr.nextLine());
        Map<String,String> phoneBook = new HashMap<String,String>();
        for(int i=0;i<n;i++){
        	phoneBook.put(sr.nextLine(), sr.nextLine());
        }
        while(sr.hasNext()){
        	String query = sr.nextLine();
        if(phoneBook.containsKey(query))
        	System.out.println(query+"="+phoneBook.get(query));
        else
        	System.out.println("Not found");
        }
	}

}
