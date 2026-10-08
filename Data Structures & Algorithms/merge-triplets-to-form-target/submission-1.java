class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        /*
           Edge case 2 :
            1 - > (2,1),(5,4),(6,5) max = [2 5 4]
            2 - > (2,5),(5,7),(6,5) max = [5 7 6]
        */

        int curMerged [] = new int [3];

        for(int [] triplet : triplets){

            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                curMerged[0] = Math.max(triplet[0], curMerged[0]);
                curMerged[1] = Math.max(triplet[1], curMerged[1]);
                curMerged[2] = Math.max(triplet[2], curMerged[2]);
            }

            if(Arrays.equals(curMerged,target)){
                return true;
            }
        }
        return false;
    }
}
