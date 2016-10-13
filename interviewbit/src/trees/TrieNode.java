package trees;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Map<Character,TrieNode> children=new HashMap<>();
	int freq;
	
	//insert ith character of String s in Trie data structure
	public void insert(String s, int i){
		freq++;
		if(i<s.length()){
			Character ch=s.charAt(i);
			if(!children.containsKey(ch)){
				children.put(ch, new TrieNode());
			}
			TrieNode child=children.get(ch);
			child.insert(s,i+1);
		}
	}
	
	//return prefix till ith character of String s in Trie data structure
	public String returnPrefix(String s, int i){
		String prefix=null;
		if(i==0 && freq==1){
			prefix=s.substring(0,i);
		}else{
			Character ch=s.charAt(i);
			TrieNode child=children.get(ch);
			prefix=child.returnPrefix(s, i+1);
		}
		return prefix;
	}
	
	public boolean search(String s, int i){
		if(i>s.length())
			return false;
		if(i==s.length())
			return true;
		
		
	}
}
