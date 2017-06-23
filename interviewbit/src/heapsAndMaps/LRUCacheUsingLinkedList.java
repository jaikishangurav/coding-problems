package heapsAndMaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LRUCacheUsingLinkedList {
	LinkedList<Integer> link;
    Map<Integer,Integer> cache;
    Map<Integer,Integer> addressMap;
    int capacity;
    
    public LRUCacheUsingLinkedList(int capacity) {
        link=new LinkedList<>();
        cache=new HashMap<>();
        addressMap=new HashMap<>();
        this.capacity=capacity;    
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int value=cache.get(key);
        int index=addressMap.get(key);
        link.remove(new Integer(key));
        link.addFirst(key);
        addressMap.put(key,0);
        return value;
    }
    
    public void set(int key, int value) {
       if(link.size()==capacity && !cache.containsKey(key)){
            int removeKey=link.pollLast();
            cache.remove(removeKey);
            addressMap.remove(removeKey);
        }
        if(cache.containsKey(key)){
        	cache.put(key,value);
        	link.remove(new Integer(key));
        	link.addFirst(key);
        	addressMap.put(key,0);
        }else{
        	cache.put(key,value);
        	link.addFirst(key);
        	addressMap.put(key,0);
        }
    }
    
    public void display(){
		System.out.println("Map:"+cache);
		System.out.println("accessList:"+link);
		System.out.println("addressMap:"+addressMap);
    }
    
	public static void main(String[] args) {
		Scanner sr=new Scanner(System.in);
		String[] operations=sr.nextLine().split(" ");
		int tests=Integer.parseInt(operations[0]);
		int capacity=Integer.parseInt(operations[1]);
		LRUCacheUsingLinkedList cache=new LRUCacheUsingLinkedList(capacity);
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
				cache.display();
			}
			if("G".equals(operations[j])){
				//System.out.println("4j:"+j);
				j=j+1;
				int key=Integer.parseInt(operations[j++]);
				//System.out.println("5j:"+j);
				int value=cache.get(key);
				System.out.println("****Got from cache:"+value);
				cache.display();
			}
		}

	}

}
