package trees;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Preorder morris traversal
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    ArrayList<Integer> result = new ArrayList<>();
	    if(a==null)
	        return null;
	    TreeNode current,node;
	    current=a;
	    while(current!=null){
	        if(current.left==null){
	            result.add(current.val);
	            current=current.right;
	        }else{
	            node=current.left;
	            while(node.right!=null && !current.equals(node.right)){
	                node=node.right;
	            }
	            if(node.right==null){
	                node.right=current;
	                result.add(current.val);
	                current=current.left;
	            }else{
	                node.right=null;
	                current=current.right;
	            }
	        }
	    }
	    return result;
	}
	
	//Iterative approach using stack
	public ArrayList<Integer> preorderTraversalWithStack(TreeNode a) {
	    ArrayList<Integer> result = new ArrayList<>();
	    if(a==null)
	        return null;
	    Stack<TreeNode> stack=new Stack<>();
	    TreeNode current;
	    current=a.left;
	    stack.push(a);
	    while(!stack.empty()){
	        current=stack.pop();
	        result.add(current.val);
	        if(current.right!=null)
	            stack.push(current.right);
	        if(current.left!=null)
	            stack.push(current.left);
	    }
	    return result;
	}

}
