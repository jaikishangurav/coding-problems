package dynamicProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LISHackerRank {

    // Complete the longestIncreasingSubsequence function below.
    static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] tail = new int[n];
        int len = 0;
        tail[0] = arr[0];
        len++;
        for (int i = 1; i < n; i++) {
            if (tail[0] > arr[i]) {
                tail[0] = arr[i];
            } else if (tail[len - 1] < arr[i]) {
                tail[len++] = arr[i];
            } else {
                int index = ceilIndex(tail, -1, len-1, arr[i]);
                tail[index] = arr[i];
            }
        }
        return len;
    }

    static int ceilIndex(int[] tail, int l, int r, int key) {
        while ((r - l) > 1) {
            int m = l + (r - l) / 2;
            if (tail[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = longestIncreasingSubsequence(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
