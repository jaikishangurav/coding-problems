package linkedlist;

class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
  }

public class ReorderList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
 
		printList(n1);
 
		reorderList(n1);
 
		printList(n1);
	}
	
	public static ListNode reorderList(ListNode a) {
	    if(a!=null && a.next!=null){
	    ListNode slow=a;
	    ListNode fast=a;
	    while(fast!=null && fast.next!=null && fast.next.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    System.out.println("11111");
	    ListNode second=slow.next;
	    slow.next=null;
	    second=reverseList(second);
	    ListNode p1=a;
	    ListNode p2=second;
	    System.out.println("222222");
	    while(p2!=null){
	        ListNode temp1=p1.next;
	        ListNode temp2=p2.next;
	        p1.next=p2;
	        p2.next=temp1;
	        p1=temp1;
	        p2=temp2;
	    }
	    }
	    return a;
	}
	public static ListNode reverseList(ListNode b){
	    if(b==null || b.next==null){
	        return b;
	    }
	    ListNode prev=b;
	    ListNode cur=b.next;
	    System.out.println("333333");
	    while(cur!=null){
	        ListNode temp=cur.next;
	        cur.next=prev;
	        prev=cur;
	        cur.next=temp;
	    }
	    System.out.println("4444444");
	    b.next=null;
	    return prev;
	}
	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val+"->");
			n = n.next;
		}
		System.out.println("null");
	}
	
}