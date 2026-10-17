class Pair {
    String value;
    int time;

    public Pair(String value, int time) {
        this.value = value;
        this.time = time;
    }
}
class TimeMap {
    HashMap<String, List<Pair>> timestamps;

    public TimeMap() {
        timestamps = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (timestamps.containsKey(key)) {
            Pair pair = new Pair(value, timestamp);
            timestamps.get(key).add(pair);
        }
        timestamps.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!timestamps.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = timestamps.get(key);
        Collections.sort(pairs, (a,b) -> Integer.compare(a.time, b.time));

        /// timestamp 3 and [1, 2, 3, 4]...
        int max = Integer.MIN_VALUE;
        String value = "";
        int left = 0;
        int right = pairs.size() - 1;

       //0 1 2 3
        //[1 2 3 4] timestap = 3
        //[10, 20, 30]
        while(left <= right){
            int mid = (left + right) / 2;

            if(pairs.get(mid).time > max && pairs.get(mid).time <= timestamp){
                value = pairs.get(mid).value;
                left = mid + 1;
            }
            else if(pairs.get(mid).time > timestamp){
                right = mid - 1;
            }
        }

        return value;
    }
}
