package binarysearch;

import java.util.ArrayList;

public class MatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    int[] arr=new int[2*a.size()];
	    ArrayList<Integer> temp;
	    int ans=0;
	    for(int i=0;i<a.size();i++){
	        temp=a.get(i);
	        arr[i]=temp.get(0);
	        arr[i+1]=temp.get(temp.size()-1);
	        System.out.print(arr[i]+" "+arr[i+1]+" ");
	    }
	     System.out.println();
	    int row=getRow(arr,b);
	    System.out.println("Row:"+row);
	    if(row==-1){
	        return 0;
	    }else{
	        temp=a.get(row);
	        ans=binarySearch(temp,b);
	    }
	    return ans;
	}
	public int binarySearch(ArrayList<Integer> a,int b){
	    int low=0;
	    int high=a.size()-1;
	    while(low<=high){
	        int mid=low+(high-low)/2;
	        //System.out.println("mid:"+mid+" a[mid]:"+a.get(mid));
	        if(b==a.get(mid)){
	            return 1;
	        }else if(b>a.get(mid)){
	            low=mid+1;
	        }else{
	            high=mid-1;
	        }
	    }
	    return 0;
	}
	public int getRow(int[] a, int b){
	    int low=0;
	    int high=a.length-1;
	    while(high-low>=1){
	        int mid=low+1+(high-low)/2;
	        System.out.println("mid:"+mid+" a[mid]:"+a[mid]);
	        if(b<=a[mid]&&b>=a[mid-1]){
	            return mid/2;
	        }else if(b>a[mid]){
	            low=mid+1;
	        }else{
	            high=mid-2;
	        }
	    }
	    return -1;
	}

}

/*
 * 7 5 3 3 11 12 14 16 17 30 34 35 45 48 49 50 52 56 59 63 63 65 67 71 72 73 79 80 84 85 85 88 88 91 92 93 94
  [3, 3, 11, 12, 14]
  [16, 17, 30, 34, 35]
  [45, 48, 49, 50, 52]
  [56, 59, 63, 63, 65]
  [67, 71, 72, 73, 79]
  [80, 84, 85, 85, 88]
  [88, 91, 92, 93, 94]
 * */
