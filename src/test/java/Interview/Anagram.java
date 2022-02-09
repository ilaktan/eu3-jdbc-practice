package Interview;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
//		Anagram is a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.
//
//		isAnagram method checks if word1 and word2 are anagram to each other then return a boolean.
//
//		each letter in word1 should appear in word2 exact number of times
//		ignore empty spaces
//		make your code case insensitive
//
//		Examples:
//
//		isAnagram("listen", "Silent") ==> true
//
//		isAnagram("earth", "heart") ==> true
//
//		isAnagram("star", "rats") ==> true
//
//		isAnagram("hi", "bye") ==> false
//
//		isAnagram("java", "cava") ==> false


        String word1="star",word2= "rats";

        if(word1.length()!=word2.length())
            System.out.println(false);


        char[]word1Chars=word1.replace(" ","").toUpperCase().toCharArray();
        char[]word2Chars=word2.replace(" ","").toUpperCase().toCharArray();

        Arrays.sort(word1Chars);
        Arrays.sort(word2Chars);

        Arrays.equals(word1Chars, word2Chars);
        System.out.println(Arrays.equals(word1Chars, word2Chars));
    }

}
