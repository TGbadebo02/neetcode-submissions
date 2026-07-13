class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // base case.
        if (nums.length == 0 || nums.length == Math.pow(10, 4)) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        // 1. get the frequencies of the numbers.
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[] {entry.getValue(), entry.getKey()});

                if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] resArray = new int[k];

        for (int i = 0; i < k; i++) {
            resArray[i] = queue.poll()[1];
        }

        return resArray;
    }
}
