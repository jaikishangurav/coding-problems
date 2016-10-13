package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//Uses segment trees
public class OrderOfPeopleHeights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] h=new Integer[]{86,77};
		Integer[] f=new Integer[]{0,1};
		ArrayList<Integer> heights=new ArrayList(Arrays.asList(h));
		ArrayList<Integer> infronts=new ArrayList(Arrays.asList(f));
		ArrayList<Integer> result=orderSegmentTree(heights,infronts);
		//ArrayList<Integer> result=order(heights,infronts);
		for (Integer in : result) {
			System.out.print(in+" ");
		}
	}
	
	//O(n^2) approach
	public static ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
	    ArrayList<Integer> result=new ArrayList<>();
	    Map<Integer,Integer> order=new TreeMap<>();
	    int n=heights.size();
	    for(int i=0;i<n;i++){
	        order.put(heights.get(i),infronts.get(i));
	    }
	    int[] temp=new int[n];
	    for(int i=0;i<n;i++)
	        result.add(-1);
	    for(Map.Entry<Integer,Integer> entry : order.entrySet()){
	        int h=entry.getKey();
	        int f=entry.getValue();
	        for(int i=0;i<n;i++){
	            if(f==0){
	                if(result.get(i)==-1){
	                    result.set(i,h);
	                    break;
	                }
	            }else if(result.get(i)==-1){
	                f--;
	            }
	        }
	    }
	    return result;
	}
	
	private static ArrayList<Integer> orderSegmentTree(ArrayList<Integer> heights, ArrayList<Integer> infronts){
		ArrayList<Integer> result=new ArrayList<>();
	    int n=heights.size();
	    Person[] p=new Person[n];
	    for(int i=0;i<n;i++){
	    	Person person=new Person(heights.get(i),infronts.get(i));
	    	p[i]=person;
	    }
	    Arrays.sort(p,(p1,p2)->{
	    	return Integer.compare(p2.height, p1.height);
	    });
	    Node root=new Node(p[0]);
	    for(int i=1;i<n;i++){
	    	insert(root,p[i]);
	    }
	    inorderSegTree(root, result);
	    return result;
	}
	
	private static void insert(Node root, Person p){
		insert(root, p,p.infornt);
	}
	
	private static void insert(Node root, Person p, int infront){
		if(infront<root.value){//insert in left subtree
			if(root.left==null){
				root.left=new Node(p);
			}else{
				insert(root.left,p,infront);
			}
			root.value++;
		}else{
			if(root.right==null){
				root.right=new Node(p);
			}else{
				insert(root.right,p,infront-root.value);
			}
		}
	}
	
	private static void inorderSegTree(Node root, ArrayList<Integer> result){
		if(root==null){
			return;
		}
		inorderSegTree(root.left,result);
		result.add(root.person.height);
		inorderSegTree(root.right,result);
	}

}

class Person{
	int height;
	int infornt;
	
	Person(int height, int infront){
		this.height=height;
		this.infornt=infront;
	}


}

 class Node{
	 Node left,right;
	int value;
	Person person;
	
	Node(Person p){
		this.value=1;
		this.person=p;
	}
}
