class TimeMap {

    private Map<String, List<Pair<Integer, String>>> timeStore;
    public TimeMap() {
        this.timeStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!this.timeStore.containsKey(key))
            this.timeStore.put(key, new ArrayList<>());
        this.timeStore.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = this.timeStore.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid).getKey() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
