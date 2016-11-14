package trees;

public class RangeMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//build segment tree containing minimun for range
	private void buildSegmentTree(int[] input, int[] segTree, int lo, int hi, int pos){
		if(lo==hi){
			segTree[pos]=input[lo];
			return;
		}
		int mid=lo+(hi-lo)/2;
		buildSegmentTree(input,segTree,lo,mid,2*pos+1);
		buildSegmentTree(input,segTree,mid+1,hi,2*pos+2);
		segTree[pos]=Math.min(segTree[2*pos+1],segTree[2*pos+2]);
	}
	
	private int getRangeMin(int[] segTree,int rlow,int rhigh,int low,int high,int pos){
		if(rlow<=low && rhigh>=high){
			return segTree[pos];
		}
		if(rlow>high || rhigh<low){
			return Integer.MAX_VALUE;
		}
		int mid=low+(high-low)/2;
		return Math.min(getRangeMin(segTree,rlow,rhigh,low,mid,2*pos+1), getRangeMin(segTree,rlow,rhigh,mid+1,high,2*pos+2));				
	}
	

}
