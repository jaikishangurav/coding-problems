package iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * [1,2,3,-1,4] -> [1,2,3,3,4]
 */

public class RewindableIterator implements Iterator<Integer>{

    private Iterator<Integer> iterator;
    private Integer prevVal;

    public RewindableIterator(Iterator<Integer> iterator){
        this.iterator = iterator;
        this.prevVal = null;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        //throw exception if no elements in iterator
        if(!iterator.hasNext()){
            throw new NoSuchElementException(); 
        }
        //fetch next value from the iterator
        int val = iterator.next();
        //If value fetched from iterator is not -1 then return the value
        //Update the prevVal to current value
        if(val != -1){
            prevVal = val;
            return val;
        }

        //Value returned by iterator is -1.
        //If the first value returned by iteraror is -1
        if(prevVal == null){
            //Skip all the consecutive -1s till we get a value which is non zero and not -1. For i/p [-1, -1, -1, -1, -1, 4] or [-1, -1, -1, -1, -1]
            while(iterator.hasNext()){
                int curVal = iterator.next();
                //If the next value is not -1 then update prevVal to curVal and return curVal
                if(curVal != -1){
                    prevVal = curVal;
                    return curVal;
                }
            }
            //Check after skipping all the consecutive -1s if we have exhausted the iterator
            if(!iterator.hasNext()){
                throw new NoSuchElementException();
            }
        }else{
            return prevVal;  //return prevVal in case of current value returned is -1 and prevVal is not null
        }
        return null;
    }

    public static void main(String[] args){
        // List<Integer> list = Arrays.asList(new Integer[] {-1,1,2,3,-1,4});
        // List<Integer> list = Arrays.asList(new Integer[] {-1,-1,-1,-1,-1});
        List<Integer> list = Arrays.asList(new Integer[] {-1});
        
        RewindableIterator iterator = new RewindableIterator(list.iterator());
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
    
}