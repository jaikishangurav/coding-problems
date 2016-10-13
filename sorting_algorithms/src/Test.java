
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6};
		int i=6;
		int lo=0;
		while (a[lo]<a[--i]){
			//System.out.println("i : "+i+" a["+i+"] : "+a[i]);
			System.out.println(a[lo]+"<"+a[i]);
			System.out.println("i : "+i);
			
		}
	}

}
