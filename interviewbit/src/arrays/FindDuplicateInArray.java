package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateInArray {

    private static int[] buckets;

    private static int AVG_BUCKET_SIZE = 0;

    private static int LAST_BUCKET_SIZE = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[] {3,4,1,5,1,5};
		List<Integer> list=Arrays.asList(arr);
		System.out.println("size:"+list.size());
		System.out.println("repeatedNumber:"+repeatedNumber(list));
	}

	public static int repeatedNumber(final List<Integer> A) {
		int n = A.size() - 1; // [1 : n] for (n + 1) number
        if (n < 1) {
            // no way to find duplicates
            return -1;
        }
        int nBuckets = (int) Math.ceil(Math.sqrt(n)); // ceiling of sqrt(n)
        int range = (int) Math.sqrt(n); // floor of sqrt(n)
        
        System.out.println("nBuckets:"+nBuckets);
        System.out.println("Range:"+range);

        buckets = new int[nBuckets];
        if (range * nBuckets < n) {
            // enlarge range of each bucket to contain all elements
            range++;
        }
        System.out.println("Range:"+range);
        LAST_BUCKET_SIZE = n - (nBuckets - 1) * range;

        AVG_BUCKET_SIZE = range;
        System.out.println("LAST_BUCKET_SIZE:"+LAST_BUCKET_SIZE);
        System.out.println("AVG_BUCKET_SIZE:"+AVG_BUCKET_SIZE);
        

        int targetBucket = -1;
        for (int num : A) {
            int iBucket = (num - 1) / range;
            System.out.println(num+"::"+iBucket);
            buckets[iBucket]++;
            if (moreThanExpected(iBucket)) {
                // once we found a bucket holding more elements than expected
                targetBucket = iBucket;
                break;
            }
        }
        System.out.println("TargetBucket:"+targetBucket);
        if (targetBucket != -1) {
            Set<Integer> targetSet = new HashSet<>();
            int lower = targetBucket * range + 1;
            int upper = lower + range - 1;
            System.out.println("lower:"+lower);
            System.out.println("upper:"+upper);
            for (int num : A) {
                if (num >= lower && num <= upper && !targetSet.add(num)) {
                    // duplicate found
                    return num;
                }
            }
        }
        return -1;
	}
	
	// whether bucket[n] has more than expected elements
    private static boolean moreThanExpected(int nBucket) {
        if (nBucket == buckets.length - 1) {
            return buckets[nBucket] > LAST_BUCKET_SIZE;
        } else {
            return buckets[nBucket] > AVG_BUCKET_SIZE;
        }
    }
	
}
