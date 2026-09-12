class Solution {
    HashSet<Integer> visitedSet = new HashSet<Integer>();
    HashSet<Integer> cycleSet = new HashSet<Integer>();
    HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        for(int i = 0; i < numCourses; i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int [] pre : prerequisites){
            int course = pre[0];
            int preq = pre[1];

            adjMap.get(course).add(preq);
        }

        for(int i = 0; i < numCourses; i++){
            if(dfs(i) == false){
                return new int[0];
            }
        }

        int [] result = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }

    private boolean dfs(int course){
        if(visitedSet.contains(course)) return true;

        if(cycleSet.contains(course)) return false;

        cycleSet.add(course);

        for(int preq : adjMap.get(course)){
            if(dfs(preq) == false){
                return false;
            }
        }
        
        cycleSet.remove(course);
        visitedSet.add(course);
        list.add(course);
        return true;
    }
}
