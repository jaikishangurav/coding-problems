package hashing;
/* Problem Statement:https://www.interviewbit.com/problems/copy-list/
 * */
import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//using hashmap to store mapping from nodes in original list to nodes in copy list
	//Time Complexity=O(n) Space Complexity=O(n)
	public RandomListNode copyRandomListHM(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode root=null;
        RandomListNode current=null;
        RandomListNode p=head;
        while(p!=null){
            current=new RandomListNode(p.label);
            map.put(p,current);
            if(p==head){
                root=current;
            }
            p=p.next;
        }
        p=head;
        while(p!=null){
            current=map.get(p);
            RandomListNode nextNode=p.next;
            RandomListNode randomNode=p.random;
            current.next=map.get(nextNode);
            current.random=map.get(randomNode);
            p=p.next;
        }
        return root;
	}
	
	//Approach without using hashmap. Time Complexity=O(n) Space Complexity=O(1)
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode copyNode=null;
		RandomListNode node=head;
		// Step 1: create a new node for each existing node and join them together 
        // eg: A->B->C will be A->A'->B->B'->C->C'
		while(node!=null){
			copyNode=new RandomListNode(node.label);
			RandomListNode nextNode=node.next;
			node.next=copyNode;
			copyNode.next=nextNode;
			node=nextNode;
		}
		// Step2: copy the random links: for each new node n', 
        // n'.random = n.random.next
		node=head;
		while(node!=null){
			copyNode=node.next;
			if(node.random!=null)
			    copyNode.random=node.random.next;
			node=copyNode.next;
		}
		// Step3: detach the list: 
        // basically n.next = n.next.next; n'.next = n'.next.next
		RandomListNode copyHead=head.next;
		copyNode=copyHead;
		node=head;
		while(node!=null){
			RandomListNode nextNode=node.next.next;
			if(copyNode.next!=null){
			    RandomListNode nextCopyNode=copyNode.next.next;
			    copyNode.next=nextCopyNode;
			    copyNode=nextCopyNode;
			}
			node.next=nextNode;
			node=nextNode;
		}
		return copyHead;
    }
}

 class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
}
 
