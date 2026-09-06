class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //set the base case.
        if(intervals.length == 0 || intervals.length > 1000) return 0;

        Arrays.sort(intervals, (a,b) -> {if(a[0] != b[0]){
          return Integer.compare(a[0],b[0]);
        }
         return Integer.compare(a[1],b[1]);
        });
        
        int eraseCount = 0;
        int [] curInterval = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            int [] nextInterval = intervals[i];

            if(curInterval[1] > nextInterval[0]){
                eraseCount++;
            }else{
                curInterval = nextInterval;
            }
        }

        return eraseCount;
    }
}
