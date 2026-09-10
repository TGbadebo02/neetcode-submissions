class Solution {
    HashMap<Integer,List<Integer>> adjMap = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(n == 0) return true;

        for(int i = 0; i < n; i++){
            adjMap.put(i,new ArrayList<>());
        }

        for(int [] edge : edges){
            int edge1 = edge[0];
            int edge2 = edge[1];

            adjMap.get(edge1).add(edge2);
            adjMap.get(edge2).add(edge1);
        }

        return dfs(0,-1) && set.size() == n;
    }

    public boolean dfs(int i, int prev){
        if(set.contains(i)) return false;

        set.add(i);

        for(int nghbr : adjMap.get(i)){
            if(nghbr == prev){
                continue;
            }

            if(dfs(nghbr,i) == false){
                return false;
            }
        }
        return true;
    }
}
