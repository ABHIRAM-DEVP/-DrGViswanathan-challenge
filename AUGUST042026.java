import java.util.ArrayList;
import java.util.List;

public class AUGUST042026{
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words){
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();

        for(String w : words){
            TrieNode node = root;
            for(char c : w.toCharArray()){
                if (node.children[c -= 'a'] == null) node.children[c] = new TrieNode();
                node = node.children[c];
            }
            node.word = w;
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    private void dfs(char[][] b, int r, int c, TrieNode node, List<String> res) {
        char ch = b[r][c];
        if (ch == '#' || (node = node.children[ch - 'a']) == null) return;

        if (node.word != null) {
            res.add(node.word);
            node.word = null; 
        }

        b[r][c] = '#'; 
        
        int[] d = {-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + d[i], nc = c + d[i + 1];
            if (nr >= 0 && nr < b.length && nc >= 0 && nc < b[0].length) {
                dfs(b, nr, nc, node, res);
            }
        }
        
        b[r][c] = ch; 
    }
}

//Time Complexity: O(M * N * 4^L)
//Space Complexity: O(sum {length of all words})