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
        // empty list case.
        if (intervals.size() == 0)
            return 0;

        // sort the list.
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int minRoom = 1;
        Interval curIntrvl = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nxtIntrvl = intervals.get(i);
            // first check.
            if (curIntrvl.end <= nxtIntrvl.start) {
                minRoom++;
                curIntrvl = nxtIntrvl;
            } else {
                curIntrvl = nxtIntrvl;
            }
        }

        return minRoom;
    }
}
