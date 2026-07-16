class Solution {
    HashSet<Integer> visitedSet = new HashSet<>();
    HashSet<Integer> cycleSet = new HashSet<>();
    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for(int [] preq : prerequisites){
            int course1 = preq[0];
            int course2 = preq[1];

            adjMap.get(course1).add(course2);
        }

        for(int i = 0; i < numCourses; i++){
               if(dfs(i,result) ==  false)
                return new int[0];
               
        }

        int [] resArray = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            resArray[i] = result.get(i);
        }

        return resArray;
    }

   public boolean dfs(int course, List<Integer> result){
      if(visitedSet.contains(course)) return true;

      if(cycleSet.contains(course)) return false;

      cycleSet.add(course);

      for(int preq : adjMap.get(course)){
         if(dfs(preq,result) ==  false) return false;
      }

      cycleSet.remove(course);
      visitedSet.add(course);
      result.add(course);

      return true;
   }
}
