import java.util.Scanner;


public class Array1D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
		int t = sr.nextInt();
		sr.nextLine();
		int i=0;
		
		String result;
		while(i<t){
		int n = sr.nextInt();
		int m = sr.nextInt();
		//System.out.println("t:"+t+" n:"+n+" m:"+m);
		sr.nextLine();
		String line = sr.nextLine();
		String lineArray[] = line.split(" ");	
		//System.out.println(lineArray.length);
		result = getResult(lineArray,m);
		System.out.println(result);
		i++;
	}
	}
	
	private static String getResult(String[] val,int m){
		int trace = 0;
		int i=0;
		boolean back = false;
		boolean ahead = false;
		while(true){
			//System.out.println(val[trace+1]+" "+val[trace+m]);
				if(trace+1>=val.length){
					System.out.println("2.Trace+1>length:"+trace);
					return "YES";} 
				else if(val[trace+1].equals("0") && !back){
					trace +=1;
					ahead = true;
					back  = false;
				System.out.println("3.Move ahead by 1:"+trace);
					}
				else if(trace+m>=val.length){
					System.out.println("4.Trace+m>length :"+trace);
					return "YES";}
				else if(val[trace+m].equals("0")){
					trace+=m;
					back = false;
					ahead = false;
				System.out.println("5.Move ahead by m:"+trace);
					}
				else if(trace-1<0 && val[trace].equals("1")){
					System.out.println("6.Trace-1<0:"+trace);
					return "NO";}
				else if(trace !=0 && val[trace-1].equals("0")){
					trace-=1;
					back = true;
					ahead = false;
				System.out.println("7.Move back by 1:"+trace);
					}
				else {
					System.out.println("8.Return No:"+trace);
					return "NO";}
				i++;
				if(i>val.length && trace<val.length)
					return "NO";
				}
				
			}
		}
	
