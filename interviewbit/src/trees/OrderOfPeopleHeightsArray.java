package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class OrderOfPeopleHeightsArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//O(n^2) approach
	public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
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
	
	private ArrayList<Integer> orderSegmentTree(ArrayList<Integer> heights, ArrayList<Integer> infronts){
		ArrayList<Integer> result=new ArrayList<>();
	    int n=heights.size();
	    Person[] p=new Person[n];
	    for(int i=0;i<n;i++){
	    	Person person=new Person(heights.get(i),infronts.get(i));
	    	p[i]=person;
	    }
	    Arrays.sort(p);
	    Person[] segTree=new Person[n];
	    for(int i=0;i<n;i++)
	    	segTree[i]=null;
	    for(Person person:p){
	    	insert(person,segTree,0);
	    }
	}
	
	private void insert(Person p, Person[] segTree, int pos){
		if(p.infornt<segTree[pos].infornt){
			if(segTree[2*pos+1]==null){
				segTree[2*pos+1]=p;
			}else{
				insert(p,segTree,2*pos+1);
			}
			
		}else{
			if(segTree[2*pos+2]==null){
				segTree[2*pos+2]=p;
			}else{
				insert(p,segTree,2*pos+2);
			}			
		}
	}
	
	private void inorderSegTree(Person[] p, ArrayList<Integer> result, int pos){
		if(pos>p.length){
			return;
		}
		inorderSegTree(p,result,2*pos+1);
		result.add(p[pos].height);
		inorderSegTree(p,result,2*pos+2);
	}

}
