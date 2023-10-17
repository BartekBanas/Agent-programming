// lab01, task 4
public class PalindromeChecker {
    public static void main(String[] args) {
        String word = "racecar";
        boolean isPalindrome = isPalindrome(word);

        System.out.println("Original: " + word);
        System.out.println("Reversed: " + reverseString(word));

        if (isPalindrome) {
            System.out.println("It's a palindrome!");
        } else {
            System.out.println("It's not a palindrome.");
        }
    }

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        String reversed = reverseString(input);
        return input.equals(reversed);
    }
}