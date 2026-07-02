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
        if (intervals.size() == 0)
            return 0;

        int[] endArray = new int[intervals.size()];
        int[] startArray = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            startArray[i] = intervals.get(i).start;
            endArray[i] = intervals.get(i).end;
        }

        Arrays.sort(startArray);
        Arrays.sort(endArray);

        int start = 0;
        int end = 0;
        int minRoom = 0;
        int result = 0;

        while (start < intervals.size()) {
            if (startArray[start] < endArray[end]) {
                start++;
                minRoom++;
            } else {
                end++;
                minRoom--;
            }
            result = Math.max(result, minRoom);
        }
        return result;
    }
}
