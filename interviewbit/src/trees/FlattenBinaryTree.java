package trees;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Recursive solution
	public TreeNode flattenRecusrsion(TreeNode a) {
	    if(a==null)
	        return null;
	    TreeNode cur=a;
	    getFlatten(cur);
	    return a;
    }
    private void getFlatten(TreeNode root){
        if(root==null)
            return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        getFlatten(left);
        getFlatten(right);
        root.right=left;
        TreeNode current = root;
        while(current.right !=null) 
            current = current.right;
        current.right =right;
    }
    
    //Non recursive solution
    public TreeNode flatten(TreeNode a) {
	    if(a==null)
	        return null;
	    TreeNode current=a;
	    while(current!=null){
	        if(current.left!=null){
	            if(current.right!=null){
	                TreeNode next=current.left;
	                while(next.right!=null)
	                    next=next.right;
	                next.right=current.right;
	            }
	            current.right=current.left;
	            current.left=null;
	        }
	        current=current.right;
	    }
	    return a;
    }
}
