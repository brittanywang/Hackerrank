import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Complete the function twoStrings in the editor below. It should return a string, either  or based on whether the strings share a common substring.

twoStrings has the following parameter(s): s1, s2: two strings to analyze

Input Format: The first line contains a single integer , the number of test cases.

The following  pairs of lines are as follows: 1) the first line contains string s1, 
second line contains string s2.

Output:
For each pair of strings, return YES or NO.




 */

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i =0; i <s1.length(); i++){
            map.put(s1.charAt(i), 1);
        }
        
        for(int i=0; i<s2.length(); i++){
            if(map.get(s2.charAt(i)) != null){
                return "YES";
            }
        }
        return "NO";
        
        
        
        }
        
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
