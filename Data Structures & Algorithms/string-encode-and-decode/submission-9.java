class Solution {

    private static final String HASH = "#";
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs)
            sb.append(str.length()).append(HASH).append(str);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int delimiterIndex = str.indexOf(HASH, i);
            int length = Integer.valueOf(str.substring(i, delimiterIndex));
            i = delimiterIndex + 1;
            result.add(str.substring(i, i + length));
            i += length;
        }
        return result;
    }
}
