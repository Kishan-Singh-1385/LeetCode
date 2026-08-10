class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1 , arr2) -> Integer.compare(arr1[1] , arr2[1]));
        for(int i = 0 ; i < intervals.length ; i++){
            pq.add(intervals[i]);
        }

        int minRemove = 0 ;
        int currInterval[] = pq.poll() ;
        while(!pq.isEmpty()){
            int nextInterval[] = pq.poll() ;
            if(currInterval[1] > nextInterval[0]) minRemove++ ;
            else currInterval = nextInterval ;
        }

        return minRemove;
        
    }
}