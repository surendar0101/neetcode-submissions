class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String word: strs) {
            int[] counter = new int[26];
            for(char c: word.toCharArray()) {
                counter[c - 'a']++;
            }
            // The following will convert ascii char[] into string
            String key = Arrays.toString(counter);
            
            // Start grouping the words based on key
            if(!result.containsKey(key)) {
                // If the key is not present then add an empty list with key
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(word);
            
        }
        return new ArrayList<>(result.values());
    }
}
