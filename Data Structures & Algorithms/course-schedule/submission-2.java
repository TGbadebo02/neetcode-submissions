class Solution {
    private HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    private HashSet<Integer> set = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // base case

        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList());
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];

            adjMap.get(course).add(pre);
        }

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i) == false) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (set.contains(course))
            return false;

        if(adjMap.get(course).isEmpty()){
            return true;
        }

        set.add(course);

        List<Integer> prereq = adjMap.get(course);

        for (int pre : prereq) {
            if (dfs(pre) == false) {
                return false;
            }
        }

        set.remove(course);
        prereq.clear();
        return true;
    }
}
