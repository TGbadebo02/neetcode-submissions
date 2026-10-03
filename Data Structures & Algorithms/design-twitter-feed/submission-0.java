
class Twitter {
    public int count;
    public HashMap<Integer, HashSet<Integer>> followMap;
    public HashMap<Integer, List<int[]>> tweetMap;
    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        // using a hash map, map userId-tweetId as the key-value pair
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[] {count++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // use double Linked List, traverse through and get the 10 most
        // recent
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
       
        if(!followMap.containsKey(userId)){
            followMap.put(userId,new HashSet<>());
        }followMap.get(userId).add(userId);

        Set<Integer> followers = followMap.get(userId);
        for (int follower : followers) {
            if (tweetMap.containsKey(follower)) {
                List<int[]> tweets = tweetMap.get(follower);
                int index = tweets.size() - 1;
                int [] tweet = tweets.get(index);
                maxHeap.offer(new int[]{tweet[0],tweet[1],follower, index});
            }
        }

        while(!maxHeap.isEmpty() && res.size() < 10){
            int [] cur = maxHeap.poll();
            res.add(cur[1]);
            int index = cur[3];
            if(index > 0){
               int[] tweet = tweetMap.get(cur[2]).get(index - 1);
               maxHeap.offer(new int[]{tweet[0],tweet[1],cur[2], index - 1});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        // add followee to the list of the follwerId list.
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // remove the followee from the list of the followerId list.
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
