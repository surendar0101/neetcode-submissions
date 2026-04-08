class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    char character;
    public TrieNode(char character) {
        this.character = character;
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode('#');
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode(c);
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    private boolean searchHelper(String word, TrieNode node, int start) {
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child: node.children) {
                    if ( child != null && searchHelper(word, child, i + 1))
                        return true;
                }
                return false;
            } else {
                if (node.children[c - 'a'] == null)
                    return false;
                node = node.children[c - 'a'];
            }
        }
        return node.isEndOfWord;
    }
}
