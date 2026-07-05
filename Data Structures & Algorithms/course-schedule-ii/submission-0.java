class Solution {
    HashSet<Integer> visitedSet = new HashSet<>();
    HashSet<Integer> cycleSet = new HashSet<>();
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> list = new ArrayList<>();
        
        for(int course = 0; course < numCourses; course++){
            adjMap.put(course,new ArrayList<>());
        }

        for(int [] preq : prerequisites){
            int course = preq[0];
            int preqs = preq[1];

            adjMap.get(course).add(preqs);
        }

        for(int course = 0; course < numCourses; course++){
            if(dfs(course,list) == false)
            return new int[0];
        }

        int [] resultArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }

    public boolean dfs(int course, List<Integer> list){
        //base case(s)
        if(visitedSet.contains(course)){
            return true;
        }

        if(cycleSet.contains(course)){
            return false;
        }

        cycleSet.add(course);
         
        for (int preq : adjMap.get(course)) {
    if (dfs(preq, list) == false) return false;
}

        cycleSet.remove(course);
        visitedSet.add(course);
        list.add(course);

        return true;
    }
}
