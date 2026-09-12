class Solution {
    HashSet<Integer> visitedSet = new HashSet<Integer>();
    HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {

        if(n == 0) return true;
        
        for(int i = 0; i < n; i++){
            adjMap.put(i, new ArrayList<>());
        }

        for(int [] edge : edges){
            int edgeA = edge[0];
            int edgeB = edge[1];

            adjMap.get(edgeA).add(edgeB);
            adjMap.get(edgeB).add(edgeA);
        }
        
        return dfs(0,-1) && n == visitedSet.size();
    }


    public boolean dfs(int i, int prev){
        if(visitedSet.contains(i)) return false;

        //if(adjMap.get(i).isEmpty()) return true;

        visitedSet.add(i);

        List<Integer> list = adjMap.get(i);

        for(int nghbr : list){

            // if(nghbr == i){ WRONG CHECK! XXXX
            //     continue; 
            // } 
            //SHOULD BE CHECKING IF THE NEIGHBOUR IS GOING BACK TO PREV NODE, SO WE DONT GET A FALSE POSITIVE.
            if(nghbr == prev) {
                continue;
            }
            if(dfs(nghbr,i) == false) {
                return false;
            }
        }
        return true;
    }
}
