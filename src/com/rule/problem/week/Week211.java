package com.rule.problem.week;

import java.util.*;

/**
 * @description:
 * @author: rule
 * @date: 2020-10-20 10:07
 **/
public class Week211 {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int ans = -1;
        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);
            if (integer != null) {
                int a = i - integer;
                ans = Math.max(ans, a - 1);
            }else {
                map.put(chars[i], i);
            }
        }
        return ans;
    }

    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> set = new TreeSet<>();
        add(s, a, b);
        return set.iterator().next();
    }


    private String move(String s, int b, Set<String> set) {
        int len = s.length();
        while (!set.contains(s)) {
            String temp = s.substring(b, len) + s.substring(0, b);
            set.add(temp);
            s = temp;
        }
        return set.iterator().next();
    }

    private void add(String s, int a, int b) {
        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();
        StringBuilder temp = new StringBuilder();
        while (!set2.contains(s) || !set1.contains(s)) {
            temp.delete(0, temp.length());
            s = move(s, b, set1);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 1) {
                    temp.append((Character.getNumericValue(chars[i]) + a) % 10);
                }else {
                    temp.append(chars[i]);
                }
            }
            s = temp.toString();
            set2.add(s);
        }
    }

    public static void main(String[] args) {
        Week211 w = new Week211();
        System.out.println(w.findLexSmallestString("74", 5, 1));
    }
}
