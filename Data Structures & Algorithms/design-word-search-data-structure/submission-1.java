class TrieNode {
    Map<Character, TrieNode> childern = new HashMap<>();
    boolean word;
}

class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;
        for(char c: word.toCharArray()) {
           if (!curr.childern.containsKey(c)) {
                curr.childern.put(c, new TrieNode());
           }
           curr = curr.childern.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

     private boolean dfs(String word, int j, TrieNode root) {
        TrieNode curr = root;

        for(int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for(TrieNode child: curr.childern.values()) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(!curr.childern.containsKey(c)) {
                    return false;
                }
                curr = curr.childern.get(c);
            }
        }
        return curr.word;
     }
}
