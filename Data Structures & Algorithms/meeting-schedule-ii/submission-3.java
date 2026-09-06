/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // set the base case(s).
        if (intervals.size() == 0 || intervals.size() > 10000)
            return 0;

        if (intervals.size() == 1)
            return 1;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int roomCount = 0;

        Interval curInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            
            Interval nxtInterval = intervals.get(i);

            if (curInterval.end > nxtInterval.start){
                roomCount++;
            }else{
                curInterval = nxtInterval;
            }
        }

        return roomCount;
    }
}
