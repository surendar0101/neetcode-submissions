class TrieNode {
    boolean word;
    Map<Character, TrieNode> childern = new HashMap<>();
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        // Iterate through the entire word 
        // and create a path for the word
        for (char c: word.toCharArray()) {
            if (!curr.childern.containsKey(c)) {
                // if there is no char present in path then create one
                curr.childern.put(c, new TrieNode());
            }
            // move curr pointer to the char c
            curr = curr.childern.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(char c: word.toCharArray()) {
            // if there is no child with char 'c' then word doesn't exist and return false
            if (!curr.childern.containsKey(c)) {
                return false;
            }
            // else move the pointer to char 'c'
            curr = curr.childern.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(char c: prefix.toCharArray()) {
            if(!curr.childern.containsKey(c)) {
                return false;
            }
            curr = curr.childern.get(c);
        }
        return true;
    }
}
