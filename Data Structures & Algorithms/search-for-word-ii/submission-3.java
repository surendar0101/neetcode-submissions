class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
    int ref = 0;

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
        curr.ref--;
        for(char c: word.toCharArray()) {
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
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        for(int r = 0; r< ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                dfs(r, c, root, "", board);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int r, int c, TrieNode node, String word, char[][] board) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visit.contains( r + "," + c) ||
            !node.children.containsKey(board[r][c]) || node.children.get(board[r][c]).ref < 1) {
            return;
        }

        visit.add(r + "," + c);
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.isWord) {
            node.isWord = false;
            result.add(word);
            root.removeWord(word);
        }

        dfs(r + 1, c, node, word, board);
        dfs(r - 1, c, node, word, board);
        dfs(r, c + 1, node, word, board);
        dfs(r, c - 1, node, word, board);
        visit.remove( r + "," + c);
    }
}
