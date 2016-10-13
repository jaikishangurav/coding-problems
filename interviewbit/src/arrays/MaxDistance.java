package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{3,5,4,2};
		List<Integer> a = new ArrayList(Arrays.asList(arr));
		System.out.println(maximumGap(a));
	}
	
	public static int maximumGap(final List<Integer> a) {
	    int max=0;
	    int n=a.size();
	    if(n==1)
	        return 0;
	    Index[] indexes=new Index[n];
	    for(int i=0;i<n;i++){
	        indexes[i]=new Index(i,a.get(i));
	    }
	    Arrays.sort(indexes, new Comparator<Index>(){
	        @Override
			public int compare(Index arg0, Index arg1) {
				// TODO Auto-generated method stub
				return arg0.value-arg1.value;
			}
	    });
	    int min=indexes[0].index;
        for(int i=1;i<n;i++){
            int temp=indexes[i].index-min;
            if(min>indexes[i].index)
                min=indexes[i].index;
            if(max<temp)
                max=temp;
        }
	    
	    return max;
	}
}

class Index{
    int index;
    int value;
    public Index(int index,int value){
        this.index=index;
        this.value=value;
    }
}
