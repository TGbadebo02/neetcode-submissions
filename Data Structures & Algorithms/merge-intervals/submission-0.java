class Solution {
    public int[][] merge(int[][] intervals) {
        // set the base case.
        if (intervals.length == 0 || intervals.length > 1000)
            return new int[0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> intrvList = new ArrayList<>();

        int[] curInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nxtInterval = intervals[i];

            if (curInterval[1] >= nxtInterval[0]) {
                curInterval[1] = Math.max(curInterval[1], nxtInterval[1]);
               // intrvList.add(curInterval);
            } else {
                intrvList.add(curInterval);
                curInterval = nxtInterval;
            }
        }
        intrvList.add(curInterval);

        int[][] result = new int[intrvList.size()][2];

        for (int i = 0; i < result.length; i++) {
            result[i] = intrvList.get(i);
        }

        return result;
    }
}
