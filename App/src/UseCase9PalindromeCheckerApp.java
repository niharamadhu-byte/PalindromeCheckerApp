/*
 * Application Name: PalindromeChecker App
 * Version: 1.0
 * Use Case 9: Recursive Palindrome Checker
 */

public class UseCase9PalindromeCheckerApp {

    // Main method - Entry point of the application
    public static void main(String[] args) {

        // Original string (can be modified for testing)
        String original = "rotator";

        // Call recursive method
        boolean isPalindrome = isPalindrome(original, 0, original.length() - 1);

        // Display result
        if (isPalindrome) {
            System.out.println("The word \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + original + "\" is NOT a Palindrome.");
        }
    }

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition: if pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters at start and end are not equal
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call moving towards center
        return isPalindrome(str, start + 1, end - 1);
    }
}