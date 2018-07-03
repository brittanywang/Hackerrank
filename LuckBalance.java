import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Collections;

/*
Input:

The first line contains two space-separated integers n and k , the number of preliminary 
contests and the maximum number of important contests Lena can lose. 
Each of the next n lines contains two space-separated integers, L[i] and T[i], the contest's
luck balance and its importance rating.

Output: 

Print a single integer denoting the maximum amount of luck Lena can have after all the contests.


*/

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        List<Integer> imp = new ArrayList<>();
        int count = 0;
        
        //puts important into imp[] and adds unimportant to count
        for(int i = 0; i < contests.length; i++){
            if(contests[i][1] == 1){
                imp.add(contests[i][0]);
            }
            else{
                count+=contests[i][0];
            }
        }
        Collections.sort(imp);
        int l = (k < imp.size() ? imp.size() - k : 0);
        for(int i = imp.size()-1; i>=0; i--){
            if(i>=l){
            count = count +imp.get(i);
            }
            else{
                count= count-imp.get(i);
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}