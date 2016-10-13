import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Bigdecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
        /*int len = sr.nextInt();
        int i=0;
        List <BigDecimal> bd = new ArrayList<BigDecimal> ();
        while(i<len){
        	bd.add(sr.nextBigDecimal());
        	i++;
        }
        Collections.sort(bd);
        Collections.reverse(bd);
        String nos[] = new String[2];
        String plainString = new String();
        for(BigDecimal b : bd){
        	plainString = b.toPlainString();
        	if(plainString.contains(".")){
        		nos = plainString.split("\\.");
        		if((nos[0]).matches("0+")){
        			System.out.println("."+nos[1]);
        		}
        		else
        			System.out.println(b.toPlainString());
        	}
        	else	
        		System.out.println(b.toPlainString());
        }*/
		
		//Scanner sr = new Scanner(System.in);
        BigDecimal a = new BigDecimal(sr.next());
        BigDecimal b = new BigDecimal(sr.next());
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
	}

}
