import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Arrays;

/*
Greedy Florist

Complete the getMinimumCost function in the editor below. It should return the minimum cost to purchase all of the flowers.
getMinimumCost has the following parameter(s):
    c: an array of integers representing the original 
    k: an integer, the number of friends


Input: the firs line contains two space separated integer n and k, the number 
of flowers and the number of friends. the second line contains n space separated
positive integers c[i], the original price of each flower.

Output: print the min cost to buy all n flowers
*/

public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int cost = 0;
        int n=c.length;
        Arrays.sort(c);
        if(n <= k){
            for (int i = 0; i < n; i++){
                cost += c[i];
            }
        }
        else{
            //if a person has to buy more than 1
            int mult = 1;
            while (n > 0){
                for (int i = 0; i < k; i++){
                    cost += c[n-1]*mult;
                    n--;
                
                if (n==0){
                    break;
                }}
                mult++;
            }
            
        }
        return cost;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
