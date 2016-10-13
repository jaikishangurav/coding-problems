package trees;

import java.util.ArrayList;
import java.util.Stack;

public class Postorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Iterative approach using stack. Doesnt alter the structure of tree.
	public ArrayList<Integer> postorderTraversal(TreeNode a) {
	    ArrayList<Integer> result=new ArrayList<>();
	    if(a==null)
	        return result;
	    Stack<TreeNode> stack=new Stack<>();
	    TreeNode current,prev;
	    stack.push(a);
	    prev=null;
	    while(!stack.empty()){
	        current=stack.peek();
	        if(prev==null || prev.left==current || prev.right==current){
	            if(current.left!=null){
	                stack.push(current.left);
	            }else if(current.right!=null){
	                stack.push(current.right);
	            }else{
	                stack.pop();
	                result.add(current.val);
	            }
	        }else if(current.left==prev){
	            if(current.right!=null){
	                stack.push(current.right);
	            }else{
	                stack.pop();
	                result.add(current.val);
	            }
	        }else if(current.right==prev){
	            stack.pop();
	            result.add(current.val);
	        }
	        prev=current;
	    }
	    return result;
	}
	
	//Iterative approach using stack. Modifies the current tree structure
	public ArrayList<Integer> postorderTraversalAltersTree(TreeNode a) {
	    ArrayList<Integer> result=new ArrayList<>();
	    if(a==null)
	        return result;
	    Stack<TreeNode> stack=new Stack<>();
	    TreeNode current;
	    stack.push(a);
	    while(!stack.empty()){
	        current=stack.peek();
	        if(current.left==null && current.right==null){
	            TreeNode temp=stack.pop();
	            result.add(temp.val);
	        }else{
	            if(current.right!=null){
	                stack.push(current.right);
	                current.right=null;
	            }if(current.left!=null){
	                stack.push(current.left);
	                current.left=null;
	            }
	        }
	    }
	    return result;
	}

}
