import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinMaxString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "welcometojava";
        int subLength = 3;
        int count = 0;
        String max = line.substring(0,0+subLength);
        String min = max;
        while(count<=line.length()-subLength) {
            String inQuestion = line.substring(count,count+subLength);
            System.out.println(inQuestion);
            if(max.compareTo(inQuestion)<0){
                max = inQuestion;
            }
            if(min.compareTo(inQuestion)>0){
                min = inQuestion;
            }
            count++;
        }  
        System.out.println("Min:"+min);
        System.out.println("Max:"+max);

    }
}