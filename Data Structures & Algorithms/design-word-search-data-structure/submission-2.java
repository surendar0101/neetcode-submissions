class TrieNode {
    Map<Character, TrieNode> childern = new HashMap<>();
    boolean word;
}

class WordDictionary {

   private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];  // 26 letters in the English alphabet
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Method to add a word into the Trie
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Method to search a word in the Trie
    public boolean search(String word) {
        return searchInNode(word, root, 0);
    }

    // Helper method to search with support for '.' wildcards
    private boolean searchInNode(String word, TrieNode node, int start) {
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                // If the current character is '.', check all possible children nodes
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null && searchInNode(word, node.children[j], i + 1)) {
                        return true;
                    }
                }
                return false;  // No valid path found
            } else {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return false;  // The path doesn't exist
                }
                node = node.children[index];
            }
        }
        return node.isEndOfWord;
    }
}
