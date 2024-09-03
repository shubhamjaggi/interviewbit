public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        long n = A.length;
        long naturalSum = prod(n, n+1)/2;
        long diff = Arrays.stream(A).mapToLong(a->(long)a).sum() - naturalSum;
        long sqNaturalSum=0L;
        for (int i=1; i<=n; i++) sqNaturalSum+=prod(i,i);
        long sqDiff = Arrays.stream(A).mapToLong(a->prod(a,a)).sum() - sqNaturalSum;
        long sum = sqDiff/diff;
        int[] ans = {(int)((sum+diff)/2), (int)((sum-diff)/2)};
        return ans;
    }
    
    private long prod(long i, long j) { return i*j;}
}