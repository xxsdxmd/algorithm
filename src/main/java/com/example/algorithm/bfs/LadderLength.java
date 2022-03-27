package com.example.algorithm.bfs;

import java.util.*;

/**
 * @author xxs
 * @create 2022/3/27 18:35
 * 单词接龙
 * 链接: https://leetcode-cn.com/problems/word-ladder/
 */
public class LadderLength {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        int res = ladderLength(beginWord,endWord,wordList);
        System.out.println(res);

    }

    /**
     * bfs
     * @param beginWord
     * @param endWord
     * @param wordList
     */
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 1, N = beginWord.length();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                assert cur != null;
                if (cur.equals(endWord)) {
                    return step;
                }
                for (int j = 0; j < N; j++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder sb = new StringBuilder(cur);
                        sb.setCharAt(j,letter);
                        String nextWord = sb.toString();
                        if (set.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            set.remove(nextWord);
                            queue.add(nextWord);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
