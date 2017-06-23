package heapsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node{
	int key;
	int value;
	Node next;
	Node prev;
	
	public Node(int key, int value){
        this.key = key;
        this.value = value;
        next=null;
        prev=null;
    }
}
public class LRUCacheUSingCustomLinkedList {
	
	Map<Integer,Node> cache;
	int capacity;
	Node head;
	Node tail;
	
	public LRUCacheUSingCustomLinkedList(int capacity){
		this.capacity=capacity;
		cache=new HashMap<>();
		head=null;
		tail=null;
	}
	
	public int get(int key){
		if(cache.containsKey(key)){
			Node node=cache.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}
	
	private void remove(Node node){
		if(node.prev!=null){
			node.prev.next = node.next;
        }else{
            head = node.next;
        }
 
        if(node.next!=null){
        	node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }
	}
	
	private void setHead(Node node){
		node.next=head;
		node.prev=null;
		if(head!=null)
			head.prev=node;
		head=node;
		if(tail==null)
			tail=head;
	}
	
	public void set(int key,int value){
		if(cache.containsKey(key)){
			Node old=cache.get(key);
			old.value=value;
			remove(old);
			setHead(old);
		}else{
			Node created=new Node(key,value);
			if(cache.size()==capacity){
				cache.remove(tail.key);
				remove(tail);
				setHead(created);
			}else{
				setHead(created);
			}
			cache.put(key, created);
		}
	}


	public static void main(String[] args) {
		Scanner sr=new Scanner(System.in);
		String[] operations=sr.nextLine().split(" ");
		int tests=Integer.parseInt(operations[0]);
		int capacity=Integer.parseInt(operations[1]);
		LRUCacheUSingCustomLinkedList cache=new LRUCacheUSingCustomLinkedList(capacity);
		int j=2;
		System.out.println("length:"+operations.length);
		while(j<operations.length){
			if("S".equals(operations[j])){
				//System.out.println("1j:"+j);
				j+=1;
				int key=Integer.parseInt(operations[j++]);
				//System.out.println("2j:"+j);
				int value=Integer.parseInt(operations[j++]);
				//System.out.println("3j:"+j);
				cache.set(key, value);
				System.out.println("Put into cache:"+key+"="+value);
				//cache.display();
			}
			if("G".equals(operations[j])){
				//System.out.println("4j:"+j);
				j=j+1;
				int key=Integer.parseInt(operations[j++]);
				//System.out.println("5j:"+j);
				int value=cache.get(key);
				System.out.println("****Got from cache:"+value);
				//cache.display();
			}
		}

	}

}
