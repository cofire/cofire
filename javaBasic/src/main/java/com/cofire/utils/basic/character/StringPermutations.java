package com.cofire.utils.basic.character;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    public static void main(String args[]) {
        permutation("12344");
    }

    /*
     * A method exposed to client to calculate permutation of String in Java.
     */
    public static void permutation(String input) {
        permutation("", input);
    }

    /*
     * Recursive method which actually prints all permutations of given String, but since we are passing an empty String
     * as current permutation to start with, I have made this method private and didn't exposed it to client.
     */
    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm + word);

        } else {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    set.add(word.charAt(i));
                    permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
                }
            }
        }

    }
}
