package Interview;

public class Palindrome {
    public static void main(String[] args) {
//		Palindrome is a word, phrase, or sequence that reads the same backward as forward, e.g., madam or nurses run.
//
//		So method isPalindrome checks that and returns true if check is palindrome and false if it is not.
//
//		- make your conditions case insensitive.  ex: Civic and civic are both palindromes
//		- make your conditions space insensitive.  Race car is a palindrome even though there is space in between.
//
//		Examples:
//
//		isPalindrome("Noon") ==> true
//
//		isPalindrome("I am not palindrome") ==> false
//
//		isPalindrome("wooden") ==> false
//
//		isPalindrome("Nurses Run") ==> true



        String check="Nurses Run";
        String reverse="";

        for (int i =check.length()-1; i >=0; i--) {

            reverse+=check.charAt(i);
        }


        System.out.println(check.replace(" ", "").equalsIgnoreCase(reverse.replace(" ", "")));


    }

}
