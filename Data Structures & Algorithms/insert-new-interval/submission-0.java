class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       
        List<int[]> result = new ArrayList<>();

        //iterate through the intervals.
        for(int i = 0; i < intervals.length; i++){

            int [] curinterval = intervals[i];
            //first check - if its smallest from beginning.
            if(newInterval[1] < curinterval[0]){
                result.add(newInterval);

                for(int j = i; j < intervals.length; j++){
                 result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            }
            //second check if its bigger than current interval
            else if(newInterval[0] > curinterval[1]){
                result.add(curinterval);
            }

            //final check - if it merges with an interval.
            else{
                newInterval = new int[]{
                   Math.min(newInterval[0],curinterval[0]),
                   Math.max(newInterval[1],curinterval[1])
                };
            }
        }
        result.add(newInterval);
        
        return result.toArray(new int[result.size()][]);
    }
}
