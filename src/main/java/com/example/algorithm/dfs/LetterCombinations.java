package com.example.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiaopeng
 * @Date 2024/7/12 22:58
 */
public class LetterCombinations {
    public static void main(String[] args) {

    }


    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final List<String> res = new ArrayList<>();
    private char[] path, dig;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        dig = digits.toCharArray();
        path = new char[digits.length()];
        dfs(0);
        return res;
    }

    void dfs(int i) {
        if (i == dig.length) {
            res.add(new String(path));
            return;
        }
        for (char c : MAPPING[dig[i] - 'a'].toCharArray()) {
            path[i] = c;
            dfs(i + 1);
        }
    }
}
