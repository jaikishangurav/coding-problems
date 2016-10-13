package trees;

import java.util.LinkedList;

public class LeastCommonAncestor {
	boolean flag1,flag2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public int lca(TreeNode a, int val1, int val2) {
        LinkedList<Integer> path1=new LinkedList<>();
        LinkedList<Integer> path2=new LinkedList<>();
        int result=-1;
	    if(findPath(a,path1,val1) && findPath(a,path2,val2)){
	        int i=0;
	        for(;i<path1.size() && i<path2.size();i++){
	            if(path1.get(i)!=path2.get(i)){
	                result=path1.get(i-1);
	                break;
	            }
	        }
	    }else result=-1;
	    return result;
	}
	private boolean findPath(TreeNode root, LinkedList<Integer> path,int val){
	    if(root==null)
	        return false;
	    path.push(root.val);
	    if(root.val==val){
	        return true;
	    }
	    if(root.left!=null && findPath(root.left, path, val))
	        return true;
	    if(root.right!=null && findPath(root.right, path, val))
	        return true;
	    path.pop();
	    return false;
	}
	public int lca1(TreeNode a, int val1, int val2) {
        flag1 = flag2 = false;
	    if(a==null) return -1;
	    if(a.left == null && a.right == null)
	    {
	        return (a.val == val1 && val1==val2) ? a.val : -1;
	    }
	    
	    TreeNode temp = find_lca(a,val1,val2);
	    if(flag1 && flag2) return temp.val; 
	    else return -1;
	}
	public TreeNode find_lca(TreeNode node,int val1,int val2)
	{
	    TreeNode lca=null;
	    if(node == null) return null;
	    
	    if(node.val == val1) 
	    {
	        this.flag1 = true;
	        lca = node;
	        //return node;
	    }
	    if(node.val == val2)
	    {
	        this.flag2 = true;
	        lca = node;
	      //  return node;
	    }
	    
	    TreeNode l = find_lca(node.left,val1,val2);
	    TreeNode r = find_lca(node.right,val1,val2);
	    
	    if((l != null && r!=null) || (lca != null)) return node;
	    
	  return l!=null ? l:r;
	}
}
