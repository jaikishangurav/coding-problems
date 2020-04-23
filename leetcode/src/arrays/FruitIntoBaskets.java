package arrays;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
	
	public int totalFruit(int[] tree) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen=0;
        for(int start=0, end=0; end<tree.length;end++){
            if(map.size()<2 || (map.get(tree[end])!=null && map.get(tree[end])>=start)){
                map.put(tree[end],end);
                maxLen = Math.max(maxLen, end-start+1);
            }else if(map.size()==2){
                while(map.size()==2){
                    int lasPos = map.get(tree[start]);
                    if(lasPos == start){
                        map.remove(tree[start]);
                    }
                    start++;
                }
                map.put(tree[end],end);
                maxLen = Math.max(maxLen, end-start+1);
            }
        }
        return maxLen;
    }

}
