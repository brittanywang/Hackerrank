import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*Max Min
You will be given a list of integers, arr, and a single integer k. 
You must create an array of length from elements of arr such that 
its unfairness is minimized. Call that array subarr. Unfairness of 
an array is calculated as max(subarr) - min(subarr).

Input: The first line contains an integer n, the numbers of elements
in array arr. The second lines contains an integer k. Each of the next
n lines contains an integer arr[i] where 0<i<n.

Output: An integer that denotes the minimum possible value of unfairness.
*/


public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int[] kArr = new int[k];
        for (int i = 0; i < arr.length -k+1; i++){
            //kArr += ;
            //if(min > (kArr.max - kArr.min)){
            //    min = kArr.max - kArr.min;
            //}
            int m = arr[i+k-1] - arr[i];
            min = (m < min ? m : min);
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
