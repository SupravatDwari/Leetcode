//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int fillingBucket(int N) {
        // code here
        return totalWays(N,new int[N+1])%100000000;

    }

    private static int totalWays(int n,int memo[])

    {

        if(n==0)

            return 1;

        if(n<0)

            return 0;

        

        int currentKey = n;

        if(memo[currentKey]!=0)

            return memo[currentKey];

        int take1lit = totalWays(currentKey-1,memo);

        int take2lit =0;

        if(currentKey>=2)

            take2lit = totalWays(currentKey-2,memo);

        memo[currentKey] = (take1lit+take2lit)%100000000;

        return memo[currentKey];
    }
};