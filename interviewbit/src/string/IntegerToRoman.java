package string;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String intToRoman(int a) {
		if(a<=0||a>=4000)
			return "";
		StringBuilder sb=new StringBuilder();
		String temp;
		while(a>0){
			temp=romanValue(a);
			sb.append(temp);
			a-=getInteger(temp);
		}
		return sb.toString();
	}
	public int getInteger(String a){
		if(a.equals("M"))
	        return 1000;
	    else if(a.equals("CM"))
	        return 900;
	    else if(a.equals("D")){
	        return 500;
	    }else if(a.equals("CD")){
	        return 400;
	    }else if(a.equals("C")){
	        return 100;
	    }else if(a.equals("XC")){
	        return 90;
	    }else if(a.equals("L")){
	        return 50;
	    }else if(a.equals("XL")){
	        return 40;
	    }else if(a.equals("X")){
	        return 10;
	    }else if(a.equals("IX")){
	        return 9;
	    }else if(a.equals("V")){
	        return 5;
	    }else if(a.equals("IV")){
	        return 4;
	    }else if(a.equals("I")){
	        return 1;
	    }
	    return 0;
	}
	public String romanValue(int a){
	    if(a>=1000)
	        return "M";
	    else if(a<1000 && a>=900)
	        return "CM";
	    else if(a<900 && a>=500){
	        return "D";
	    }else if(a<500 && a>=400){
	        return "CD";
	    }else if(a<400 && a>=100){
	        return "C";
	    }else if(a<100 && a>=90){
	        return "XC";
	    }else if(a<90 && a>=50){
	        return "L";
	    }else if(a<50 && a>=40){
	        return "XL";
	    }else if(a<40 && a>=10){
	        return "X";
	    }else if(a==9){
	        return "IX";
	    }else if(a<9 && a>=5){
	        return "V";
	    }else if(a==4){
	        return "IV";
	    }else if(a<4 && a>=1){
	        return "I";
	    }
	    return "";
	}
}
