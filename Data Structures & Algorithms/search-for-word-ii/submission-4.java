class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false; // to store if the node forms end of a word
    int ref = 0; // to store the level of the word, ref < 1 indigates that we've reached root 

    public void addWord(String word) {
        TrieNode curr = this;
        for(char c: word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                // if the character is not present in the tree then add it to the children
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
            curr.ref++;
        }
        curr.isWord = true;
    }

    public void removeWord(String word) {
        TrieNode curr = this;
        curr.ref--; // remove the last ref of the word
        for(char c: word.toCharArray()) {
            // check if children of curr pointer has char c of word
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                curr.ref--;
            }
        }
    }
}
class Solution {
    int ROWS, COLS;
    TrieNode root;
    Set<String> result;
    Set<String> visit;
    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        visit = new HashSet<>();
        root = new TrieNode();

        for(String word: words) {
            // add all words to the trie data structure
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        for(int r = 0; r< ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                // check for all the possibilites in the board using dfs
                dfs(r, c, root, "", board);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int r, int c, TrieNode node, String word, char[][] board) {
        /** Base case condition 
        * if 0 > r >= ROWS or 0 > c >= COLS then r or c is out of bound
        * if char at r,c is already visited
        * if children doesn't have board[r][c] character
        * if ref < 1 then we've reached root node
        * if any of the above is true then we've reached base condition and return the flow
        **/
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visit.contains( r + "," + c) ||
            !node.children.containsKey(board[r][c]) || node.children.get(board[r][c]).ref < 1) {
            return;
        }

        visit.add(r + "," + c); // Marking r'th row and c'th column as visited
        node = node.children.get(board[r][c]); // get the TrieNode of character board[r][c]
        word += board[r][c]; // append character board[r][c] to the word
        if (node.isWord) {
            /* 
            * if the word is found then add the word to result
            * remove the word by setting node.isWord as false and calling removeWord method
            */
            node.isWord = false;
            result.add(word);
            root.removeWord(word);
        }

        dfs(r + 1, c, node, word, board); // Traverse down
        dfs(r - 1, c, node, word, board); // Traverse up
        dfs(r, c + 1, node, word, board); // Traverse right
        dfs(r, c - 1, node, word, board); // Traverse left

        // unmark r'th row and c'th column as unvisited so that we can find any other possibile path
        visit.remove( r + "," + c); 
    }
}
