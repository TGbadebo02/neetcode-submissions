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

        List<Pair> values = timestamps.get(key);
        Collections.sort(values, (a,b) -> Integer.compare(a.time, b.time));

        /// timestamp 3 and [1, 2, 3, 4]...
        int max = Integer.MIN_VALUE;

        for (Pair pair : values) {
            if (pair.time > max && pair.time <= timestamp) {
                max = pair.time;
            }
        }

        for (Pair pair : values) {
            if (pair.time == max) {
                return pair.value;
            }
        }

        return "";
    }
}
