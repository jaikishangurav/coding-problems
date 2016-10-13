import java.util.Scanner;
import java.util.Stack;


public class ParenthesisStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<Character>();
		Scanner sr = new Scanner(System.in);
		String str = new String();
		//String str = "{}(";
		char c;
		boolean flag = true;
		while(sr.hasNext()){
			str = sr.next();
		for(int i=0;i<str.length();i++){
			c = str.charAt(i);
			if(c == '(' ||c == '{'||c == '[')
				stack.push(c);
			//System.out.println(stack);
			if (c == ')'||c == '}'||c == ']'){
				if(stack.isEmpty())
					flag = false;
				else if(c=='}' && stack.peek()== '{'||c==')' && stack.peek()== '('||c==']' && stack.peek()== '[')
					stack.pop();
			}	
		}
		if(!stack.isEmpty())
		flag=false;
		System.out.println(flag);
		flag=true;
		stack.clear();
		}
	}

}
