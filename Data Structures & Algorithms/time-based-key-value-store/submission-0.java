class Value {
    String value;
    int timestamp;
    public Value(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    private Map<String, List<Value>> keyStore;
    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Value(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Value> values = keyStore.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid).timestamp <= timestamp) {
                result = values.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
