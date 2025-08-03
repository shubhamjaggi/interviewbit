public class Solution {
    public int adjacent(int[][] A) {
        int n = A[0].length;
        int[] dp = new int[n];
        dp[0] = Math.max(A[0][0], A[1][0]);
        if(n==1) return dp[0];
        dp[1] = Math.max(dp[0], Math.max(A[0][1], A[1][1]));
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + Math.max(A[0][i], A[1][i]));
        }
        return dp[n-1];
    }
}