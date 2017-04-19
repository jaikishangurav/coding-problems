package graphs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//using bfs for getting nodes present at each level
	public ArrayList<ArrayList<Integer>> levelOrder1(TreeNode a) {
	    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	    if(a==null)
	        return result;
	    Deque<TreeNode> queue=new LinkedList<>();
	    queue.offer(a);
	    ArrayList<Integer> temp=new ArrayList<>();
	    int h=getHeight(a);
	    while(!queue.isEmpty()){
	    	int size=queue.size();
	    	int i=0;
	    	while(i<size){
	    		TreeNode node=queue.poll();
	    		temp.add(node.val);
	    		queue.offer(node.left);
	    		queue.offer(node.right);
	    		i++;
	    	}
	    	result.add(temp);
	    	temp=new ArrayList<>();	    	
	    }
	    return result;
	}
	
	//traversing each level by calculating height of tree
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
	    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	    if(a==null)
	        return result;
	    int h=getHeight(a);
	    ArrayList<Integer> temp=new ArrayList<>();
	    for(int i=0;i<h;i++){
	        getLevelOrderNodes(a,i,temp);
	        result.add(temp);
	        temp=new ArrayList<>();
	    }
	    return result;
	}
	public void getLevelOrderNodes(TreeNode a, int level,ArrayList<Integer> temp){
	    if(level==0){
	        temp.add(a.val);
	    }
	    if(a.left!=null){
	        getLevelOrderNodes(a.left,level-1,temp);
	    }
	    if(a.right!=null){
	        getLevelOrderNodes(a.right,level-1,temp);
	    }
	    return;
	}
	public int getHeight(TreeNode a){
	    if(a==null){
	        return 0;
	    }
	    if(a.right==null && a.left==null)
	        return 1;
	    return 1+Math.max(getHeight(a.left),getHeight(a.right));
	}
}
