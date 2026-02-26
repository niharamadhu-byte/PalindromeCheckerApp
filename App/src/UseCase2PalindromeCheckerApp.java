/*
 * Application Name: PalindromeChecker App
 * Version: 1.0
 * Use Case 2: Print Hardcoded Palindrome Result
 */

public class UseCase2PalindromeCheckerApp {

    // Main method - Entry point of the application
    public static void main(String[] args) {

        // Hardcoded string literal
        String word = "madam";

        // Reverse the string
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check if palindrome using conditional statement
        if (word.equals(reversed)) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }

        // Program exits
    }
}