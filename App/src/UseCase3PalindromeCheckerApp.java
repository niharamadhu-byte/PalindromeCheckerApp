/*
 * Application Name: PalindromeChecker App
 * Version: 1.0
 * Use Case 3: Palindrome Check Using String Reverse
 */

public class UseCase3PalindromeCheckerApp {

    // Main method - Entry point of the application
    public static void main(String[] args) {

        // Original string (can be modified for testing)
        String original = "level";

        // Variable to store reversed string
        String reversed = "";

        // Reverse string using for loop
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        // Compare original and reversed string using equals()
        if (original.equals(reversed)) {
            System.out.println("The word \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + original + "\" is NOT a Palindrome.");
        }
    }
}