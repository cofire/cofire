package com.cofire.utils.basic.character;

import java.util.Arrays;

public class AnagramCheck {
    /*
     * One way to find if two Strings are anagram in Java. This method assumes both arguments are not null and in
     * lowercase.
     * @return true, if both String are anagram
     */
    public static boolean isAnagram(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;
        }

        char[] chars = word.toCharArray();

        for (char c : chars) {
            int index = anagram.indexOf(c);
            if (index != -1) {
                anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
            } else {
                return false;
            }
        }

        return anagram.isEmpty();
    }

    /*
     * Another way to check if two Strings are anagram or not in Java This method assumes that both word and anagram are
     * not null and lowercase
     * @return true, if both Strings are anagram.
     */
    public static boolean iAnagram(String word, String anagram) {
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);

        return Arrays.equals(charFromWord, charFromAnagram);
    }

    public static boolean checkAnagram(String first, String second) {
        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);

        for (char ch : characters) {
            int index = sbSecond.indexOf("" + ch);
            if (index != -1) {
                sbSecond.deleteCharAt(index);
            } else {
                return false;
            }
        }

        return sbSecond.length() == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(AnagramCheck.isAnagram("word", "wrdo"));
        System.out.println(AnagramCheck.isAnagram("mary", "army"));
        System.out.println(AnagramCheck.isAnagram("stop", "tops"));
        System.out.println(AnagramCheck.isAnagram("boat", "btoa"));
        System.out.println(AnagramCheck.isAnagram("pure", "in"));
        System.out.println(AnagramCheck.isAnagram("fill", "fil"));
        System.out.println(AnagramCheck.isAnagram("b", "bbb"));
        System.out.println(AnagramCheck.isAnagram("ccc", "ccccccc"));
        System.out.println(AnagramCheck.isAnagram("a", "a"));
        System.out.println(AnagramCheck.isAnagram("sleep", "slep"));
        System.out.println(AnagramCheck.iAnagram("word", "wrdo"));
        System.out.println(AnagramCheck.iAnagram("boat", "btoa"));
        System.out.println(AnagramCheck.iAnagram("pure", "in"));
        System.out.println(AnagramCheck.iAnagram("fill", "fil"));
        System.out.println(AnagramCheck.iAnagram("a", "a"));
        System.out.println(AnagramCheck.iAnagram("b", "bbb"));
        System.out.println(AnagramCheck.iAnagram("ccc", "ccccccc"));
        System.out.println(AnagramCheck.iAnagram("sleep", "slep"));
        System.out.println(AnagramCheck.checkAnagram("word", "wrdo"));
        System.out.println(AnagramCheck.checkAnagram("b", "bbb"));
        System.out.println(AnagramCheck.checkAnagram("ccc", "ccccccc"));
        System.out.println(AnagramCheck.checkAnagram("a", "a"));
        System.out.println(AnagramCheck.checkAnagram("sleep", "slep"));
        System.out.println(AnagramCheck.checkAnagram("boat", "btoa"));
        System.out.println(AnagramCheck.checkAnagram("pure", "in"));
        System.out.println(AnagramCheck.checkAnagram("fill", "fil"));
    }
}
