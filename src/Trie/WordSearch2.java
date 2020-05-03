package Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Word search 2
 */
public class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int m = 0; m< board.length;m++) {
            for(int n = 0; n< board[0].length; n++) {
                dfs(board, root, m, n, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board,TrieNode p, int i, int j, List<String> res) {
        char c = board[i][j];
        if(c == '#' || p.next[c -'a'] == null) return;
        p = p.next[c - 'a'];
        if(p.word!= null) { // found add to result
            res.add(p.word);
            p.word = null;
        }

        board[i][j] = '#'; // visited
        if(i>0) {
            dfs(board,p,i-1,j,res);
        }
        if(j>0) {
            dfs(board,p,i,j-1, res);
        }
        if( i < board.length-1) {
            dfs(board,p,i+1,j, res);
        }
        if(j < board[0].length -1) {
            dfs(board,p,i,j+1,res);
        }
        board[i][j] = c;

    }

    // add words to the trie
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode p = root;
            for(char c : word.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = word;
        }
        return root;

    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
