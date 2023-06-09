package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OneTowSeven {

    /*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList
    is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList,
    return the number of words in the shortest transformation sequence from beginWord to endWord,
    or 0 if no such sequence exists.
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < wordList.size(); i++){
            if (wordList.get(i).equals(endWord)){
                queue.add(i);
                visited[i] = true;
                break;
            }
        }
        int counter = 1 ;
        while (!queue.isEmpty()){
            int toPop = queue.size();
            for (int i = 0; i < toPop; i++){
                int cur = queue.pop();
                if (isSingleLtrDiff(wordList.get(cur), beginWord)) return counter + 1;
                for (int j = 0; j < wordList.size(); j++){
                    if (!visited[j] && isSingleLtrDiff(wordList.get(cur),wordList.get(j))){
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
            counter++;
        }
        return 0;
    }

    private static boolean isSingleLtrDiff(String s1, String s2){
        int counter =0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)) counter++;
        }

        return (counter == 1);
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));

    }
}
