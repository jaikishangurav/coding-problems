package trees;

public class NextGreaterNumberBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 // Definition for binary tree
	  class TreeNode {
	      int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	public class Solution {
		public TreeNode getSuccessor(TreeNode a, int b) {
		    TreeNode current=find(a,b);
		    if (current==null)
		        return null;
		    if(current.right!=null)
		        return findMin(current);
		    else{
		        TreeNode successor=null;
		        TreeNode ancestor=a;
		        while(ancestor!=current){
		            if(current.val<ancestor.val){
		                successor=ancestor;
		                ancestor=ancestor.left;
		            }else{
		                ancestor=ancestor.right;
		            }
		        }
		        return successor;
		    }
		}
		
		public TreeNode find(TreeNode root, int data){
		    if(root==null)
		        return null;
		    else if(root.val==data)
		        return root;
		    else if(root.val<data) return find(root.right,data);
		    else return find(root.left,data);
		}
		public TreeNode findMin(TreeNode root){
		    if (root==null) return null;
		    while(root.left!=null)
		        root=root.left;
		    return root;     
		}
	}

}
