import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DataType {

    public static void main(String[] args)  {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br;
        String m = new String();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
		
        //int T = Integer.parseInt(in.readLine());
        int T;
		try {
			T = Integer.parseInt(br.readLine());
		
       // BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        long n;
        while (T>0){
        	try{
        		m = br.readLine();
            n=Long.parseLong(m);
        	
            //if(n<(-(Math.pow(2,63))) && n>Math.pow(2,63)-1)
              //  System.out.println(n+" can't be fitted anywhere.");
            
            	System.out.println(n+" can be fitted in:");
            if(n>=-128 && n<=127)
            	System.out.println("* byte");
            if(n>=-32768 && n<=32767)
            	System.out.println("* short");
            if(n>=(-(Math.pow(2,31))) && n<=Math.pow(2,31)-1)
            	System.out.println("* int");
            if(n>=(-(Math.pow(2,63))) && n<=Math.pow(2,63)-1)
            	System.out.println("* long");
            }
        
    	catch(NumberFormatException e){
    		 System.out.println(m+" can't be fitted anywhere.");
    	}
            //log.flush();
            T--;
        }
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
		 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        
    }
}