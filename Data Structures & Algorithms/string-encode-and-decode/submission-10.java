class Solution {
    private String DELIMITER = "#";
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length()).append(DELIMITER).append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimterIdx = str.indexOf(DELIMITER, i);
            int length = Integer.valueOf(str.substring(i, delimterIdx));
            i = delimterIdx + 1;
            String word = str.substring(i, i + length);
            result.add(word);
            i += length;
        }
        return result;
    }
}
