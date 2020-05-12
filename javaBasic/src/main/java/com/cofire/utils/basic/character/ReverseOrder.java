package com.cofire.utils.basic.character;

public class ReverseOrder {

    public static boolean isReverseOrder(String word, String anagram) {
        if (word == null || anagram == null) {
            return false;
        }
        if (word.length() != anagram.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != anagram.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isReverseOrder("qwert", "qwert"));
        System.out.println(isReverseOrder("qwert", "trewq"));
        System.out.println(isReverseOrder(null, "trewq"));
    }
}
