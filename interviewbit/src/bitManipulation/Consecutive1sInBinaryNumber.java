package bitManipulation;

import java.util.Scanner;

public class Consecutive1sInBinaryNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr=new Scanner(System.in);
        int a=sr.nextInt();
        int ans=0;
        while(a>0){
            a&=(a<<1);
            ans++;
        }
        System.out.println(ans);
	}

}
