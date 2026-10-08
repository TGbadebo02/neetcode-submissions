class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] array = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c - 'a'] = i;
        }

        int size = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //size++;

            end = Math.max(end, array[c - 'a']);
            size++;
            
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
