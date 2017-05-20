package math;

public class PowerOfTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Can be expressed as x^y:"+isPower(125));
	}
	
	//using squareroot approach
	public static boolean isPower(int a) {
        if(a==1)
            return true;
        int sqrt=(int)Math.sqrt(a);
        int num;
        for(int i=2;i<=sqrt;i++){
            num=a;
            while(num%i==0){                
                    num/=i;
            }
            if(num==1){
            	return true;
            }
        }
        return false;
    }
	
	/*Given a number a, we have to find integers x and y, such that:
     a = x^y
	If we take log on both sides, we get:
     log a = log (x^y)
     log a = y log x
     y = log a / log x
	Hence, we have to find an integer x for which RHS gives an integer y.
	Algorithm:
	1: Starting with i = 2, if (log a / log i) is an integer then return true.
	2: Else increment i by 1 till i < sqrt(a).
	3: If no such i is found, return false.*/
	public static boolean isPowerUsingLog(int a) {
        if (a == 1)
            return true;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            double value = Math.log(a) / Math.log(i);
            System.out.println(value);
            if ((value - (int) value) < 0.000000001) {
                return true;
            }
        }
        return false;
	}

}
