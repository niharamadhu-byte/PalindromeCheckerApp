/*
 * Application Name: PalindromeChecker App
 * Version: 1.0
 * Use Case 4: Character Array Based Palindrome Check
 */

public class UseCase4PalindromeCheckerApp {

    // Main method - Entry point of the application
    public static void main(String[] args) {

        // Original string (can be changed for testing)
        String original = "radar";

        // Convert string to character array
        char[] characters = original.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The word \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + original + "\" is NOT a Palindrome.");
        }
    }
}