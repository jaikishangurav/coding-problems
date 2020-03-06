package arrays;

public class SecondHighestValue {

	public static void main(String[] args) {
		int[] nos= {54,32,10,58,69,32,67,41,6,91,12,89,10,1,5};
		int secondMax=findSecondHighestValue(nos);
		System.out.println("Second Highest Value : "+secondMax);

	}
	
	private static int findSecondHighestValue(int[] nos) {
		int max=Integer.MIN_VALUE;
		int secondMax=Integer.MIN_VALUE;
		for(int i=0;i<nos.length;i++) {
			if(nos[i]>max) {
				secondMax=max;
				max=nos[i];
			}else {
				if(nos[i]>secondMax && nos[i]!=max) {
					secondMax=nos[i];
				}
			}
		}
		return secondMax;
	}
}
