class Solution {

    private static final String DELIMITER = "#";
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String word: strs) {
            sb.append(word.length()).append(DELIMITER).append(word);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i < str.length()) {
            // compute i'th index of delimiter 
            int delimiterIndex = str.indexOf(DELIMITER, i);
            
            // compute length of the word
            int length = Integer.valueOf(str.substring(i, delimiterIndex));

            // move the current index after "#"
            i = delimiterIndex + 1; 

            result.add(str.substring(i, i+length));
            i+=length;
        }
        return result;
    }
}
