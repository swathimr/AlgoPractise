package DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * time complexity O(m*n)
 * add top word to queue
 * end step = if word equals end word
 * find all the transformation of the current word
 * if exists in dictionary add to queue and remove from dictionary
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord,1));

        while(!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(endWord))
                return top.steps;

            char[] arr = word.toCharArray();
            for(int i=0;i<arr.length;i++) {
                for(char c = 'a';c<='z';c++) {
                    char temp = arr[i];

                    if(c!=arr[i])
                        arr[i] =c;

                    String newWord = String.valueOf(arr);
                    if(wordList.contains(newWord)) {
                        queue.add(new WordNode(newWord,top.steps+1));
                        wordList.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }

        return 0;
    }
}

class WordNode {
    String word;
    int steps;

    public WordNode(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}