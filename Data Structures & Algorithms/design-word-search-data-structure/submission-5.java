class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null)
                curr.children[i] = new TrieNode();
            curr = curr.children[i];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, root, 0);
    }

    private boolean searchInNode(String word, TrieNode node, int start) {
        for (int i=start; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j=0; j < 26; j++) {
                    if (node.children[j] != null && searchInNode(word, node.children[j], i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = ch - 'a';
                if (node.children[idx] == null)
                    return false;
                node = node.children[idx];
            }
        }
        return node.isWord;
    }
}
