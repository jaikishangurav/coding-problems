import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagram {
       public static void main(String[] args) {
              // TODO Auto-generated method stu
              Scanner sr = new Scanner(System.in);
              String a = sr.next();             //anagram
              String b = sr.next();             //namagra
              String big;
              String small;
              if(a.length()>=b.length()){
            	  big=a.toLowerCase();
              small=b.toLowerCase();
              }
              else{
            	  big=b.toLowerCase();
              small=a.toLowerCase();
              }
              List <Character> alist = new ArrayList<>();
              for(char i : big.toCharArray()){
                    alist.add(i);
              }
              System.out.println(alist);
              for(char i : small.toCharArray()){
                     if(!alist.remove(new Character(i))){
                           System.out.println(i+" not in "+alist);
                           break;
                     }
                     System.out.println("Removed "+i+" from "+alist);
              }
              if(alist.isEmpty())
                     System.out.println("Anagram");
              else
                     System.out.println("Not Anagram");
       }
}