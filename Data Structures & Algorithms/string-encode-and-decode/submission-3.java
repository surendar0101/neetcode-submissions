class Solution {

    public static final String DELIMITER = "#";
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String word: strs) {
            encodedString.append(word.length()).append(DELIMITER).append(word);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i < str.length()) {
            int delimiterIndex = str.indexOf(DELIMITER, i);
            int length = Integer.valueOf(str.substring(i, delimiterIndex));
            i = delimiterIndex + 1;
            result.add(str.substring(i, i + length));
            i+=length;
        }
        return result;
    }
}
