package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> data=new ArrayList<>();
		data.add(new Interval(1,7));
		data.add(new Interval(1,5));
		data.add(new Interval(11,20));
		data.add(new Interval(2,10));
		System.out.println(merge(data));
	}
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.size()==1){
            return intervals;
        }
        Collections.sort(intervals,(i1,i2)->{
            return i1.start-i2.start;
            });
        System.out.println(intervals);
        ArrayList<Interval> result=new ArrayList<>();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            int temps=intervals.get(i).start;
            int tempe=intervals.get(i).end;
            if(temps<=end){
                end=Math.max(end,tempe);
            }else{
            	System.out.println("Inside else");
            	Interval interval=new Interval(start,end);
                result.add(interval);
                start=temps;
                end=tempe;
            }
            if(i==intervals.size()-1){
            	System.out.println("Inside if");
                Interval interval=new Interval(start,end);
                result.add(interval);
            }
        }
        return result;
    }
	
}

class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
		@Override
		public String toString() {
			return "Interval ["+start + ", " + end + "]";
		}
	      
}

