class Solution {
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preqs = pre[1];

            adjMap.get(course).add(preqs);
        }

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int course) {
        if (set.contains(course))
            return false;

        if(adjMap.get(course).isEmpty()) {
            return true;
        }

        set.add(course);

        for (int pre : adjMap.get(course)) {
            if (dfs(pre) == false) {
                return false;
            }
        adjMap.get(course).clear();
        }
        return true;
    }
}
