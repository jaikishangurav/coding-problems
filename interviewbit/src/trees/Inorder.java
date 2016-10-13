package trees;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
	      int val;
	      TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }

public class Inorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Integer> inorderTraversalWithoutRecursion(TreeNode a) {
	    if(a==null)
	        return null;
	    ArrayList<Integer> result=new ArrayList<>();
	    Stack<TreeNode> stack=new Stack<>();
	    stack.push(a);
	    TreeNode cur=null;
	    cur=a.left;
	    while(!stack.empty()){
	        if(cur!=null){
	            stack.push(a.left);
	            cur=cur.left;
	        }else{
	            cur=(TreeNode)stack.pop();
	            result.add(cur.val);
	            cur=cur.right;
	        }
	    }
	    return result;
	}
	
	//Without Stack without recursion|| Morris Traversal
	public ArrayList<Integer> inorderMorrisTraversal(TreeNode a) {
	    if(a==null)
	        return null;
	    ArrayList<Integer> result=new ArrayList<>();
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
	                current=current.left;
	            }else{
	                node.right=null;
	                result.add(current.val);
	                current=current.right;
	            }
	        }
	    }
	    return result;
	}
	

}
