import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    public static int sol(int[] a){
        int unique = 39876543;
        for (int i = 0; i <a.length; i++){
            boolean b = true;
            for (int j = i+1; j <a.length; j++){
                //if the element doesn't exist more than once
                if (a[i] == a[j]){
                    b = false;
                }
            }
            if (b == true){
                unique = a[i];
            }
        }
        return unique;
    } 



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        System.out.println(sol(a));

        scanner.close();
    }
}