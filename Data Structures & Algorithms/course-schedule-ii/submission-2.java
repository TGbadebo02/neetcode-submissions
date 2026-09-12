class Solution {
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
    HashSet<Integer> cycleSet = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int preq = pre[1];

            adjMap.get(course).add(preq);
        }

        for(int i = 0; i < numCourses; i++){
            if(dfs(i) == false){
                return new int[0];
            }
        }

        int [] array = new int[result.size()];
        for(int i = 0; i < result.size();i++){
            array[i] = result.get(i);
        }

        return array;
    }


    private boolean dfs(int course){
        if(cycleSet.contains(course)) return false;

        if(set.contains(course)) return true;

        cycleSet.add(course);

        for(int nghbr : adjMap.get(course)){
            if(dfs(nghbr) == false){
                return false;
            }
        }

        cycleSet.remove(course);
        set.add(course);
        result.add(course);

        return true;
    }
}
