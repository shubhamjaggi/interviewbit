public class Solution {
    public int solve(int[][] A) {
        
        Queue<Integer> startTimes = new PriorityQueue<>();
        Queue<Integer> endTimes = new PriorityQueue<>();
        
        for(int i = 0; i < A.length; i++){
            startTimes.offer(A[i][0]);
            endTimes.offer(A[i][1]);
        }
        
        int numOngoingMeetings = 0;
        int minNumOfMeetings = 0;
        while(!startTimes.isEmpty()) {
            if(startTimes.peek() < endTimes.peek()){
                numOngoingMeetings ++;
                if(numOngoingMeetings > minNumOfMeetings) minNumOfMeetings = numOngoingMeetings;
                startTimes.poll();
            }else{
                numOngoingMeetings--;
                endTimes.poll();
            }
        }
        
        return minNumOfMeetings;
    }
}
