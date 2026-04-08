class TrieNode {
    char ch;
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode('#');
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode(c);
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode node, int start) {
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child: node.children) {
                    if (child != null && dfs(word, child, i + 1))
                        return true;
                }
                return false;
            } else {
                if (node.children[ch - 'a'] == null)
                    return false;
                node = node.children[ch - 'a'];
            }
        }
        return node.isEndOfWord;
    }
}
