public class Solution {
    public int candy(int[] A) {
        int left[] = new int[A.length];
        int right[] = new int[A.length];
        
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        for(int i = 1; i < A.length; i++){
            if (A[i] > A[i-1]){
                left[i] = left[i-1] + 1;
            }
            
            int j = A.length - i;
            
            if(A[j-1] > A[j]){
                right[j-1] = right[j] + 1;
            }
        }
        
        int numCandies = 0;
        for(int i = 0; i < A.length; i++){
            numCandies += Math.max(left[i], right[i]);
        }
        
        return numCandies;
    }
}
