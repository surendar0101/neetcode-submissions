class Solution {

    public static final String DELIMITER = "#";
    public String encode(List<String> strs) {  

        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append(DELIMITER).append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i < str.length()) {
            // find the of # from index i
            int delimiterIndex = str.indexOf(DELIMITER, i);
            
            // find the length of current string by computing substring of current index and "#"
            int length = Integer.valueOf(str.substring(i, delimiterIndex));

            // Move current index after "#" to compute string of "length"
            i = delimiterIndex + 1;

            // Add word to the result
            result.add(str.substring(i, i + length));

            // update index to current index + length
            i += length;
        }
        return result;
    }
}
