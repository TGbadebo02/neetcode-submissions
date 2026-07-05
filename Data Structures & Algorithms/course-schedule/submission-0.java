class Solution {
    HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visitedSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++){
            adjMap.put(i, new ArrayList<>());
        }

        for(int [] preq : prerequisites){
            adjMap.get(preq[0]).add(preq[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(int course){
        //set the base case(s).
        if(visitedSet.contains(course)) return false;

        if(adjMap.get(course).isEmpty()) return true;

        visitedSet.add(course);

        for(int preq : adjMap.get(course)){
            if(!dfs(preq)) return false;
        }
        
        visitedSet.remove(course);
        adjMap.put(course,new ArrayList<>());

        return true;
    }
}
