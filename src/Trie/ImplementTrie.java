package Trie;

public class ImplementTrie {

    TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(char c:word.toCharArray()) {
            int i = c-'a';
            if(p.next[i] == null) {
                p.next[i] = new TrieNode();
            }
            p = p.next[i];
        }
        p.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for(char c:word.toCharArray()) {
            int i = c-'a';
            if(p.next[i] == null)
                return false;
            p = p.next[i];
        }
        return p.word!=null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(char c:prefix.toCharArray()) {
            int i = c-'a';
            if(p.next[i] == null)
                return false;
            p = p.next[i];
        }
        return true;
    }

}
class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

