package bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
		ArrayList<Integer> a=new ArrayList<>(Arrays.asList(arr));
		System.out.println("Ans:"+singleNumber(a));
	}
	public static int singleNumber(final List<Integer> a) {
	    int ones = 0, twos = 0, threes = 0;
	    for(Integer x:a){
	    System.out.println("XXXXXXXX:"+Integer.toBinaryString(x)+":"+x);
	    twos |= ones & x;
	    System.out.println("1.twos:"+Integer.toBinaryString(twos)+":"+twos);
        ones ^= x;
        System.out.println("2.ones:"+Integer.toBinaryString(ones)+":"+ones);
        threes = ones & twos;
        System.out.println("3.threes:"+Integer.toBinaryString(threes)+":"+threes);
        ones &= ~threes;
	    System.out.println("4.ones:"+Integer.toBinaryString(ones)+":"+ones);
        twos &= ~threes;
	    System.out.println("5.twos:"+Integer.toBinaryString(twos)+":"+twos);
	    }
	    //System.out.println(num);
	    return ones;
	}
}
