/*
 * Application Name: PalindromeChecker App
 * Version: 1.0
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome Checker
 */

public class UseCase10PalindromeCheckerApp {

    // Main method - Entry point of the application
    public static void main(String[] args) {

        // Original string with spaces and mixed case
        String original = "A man a plan a canal Panama";

        // Step 1: Normalize string
        // Convert to lowercase and remove all spaces using regular expression
        String normalized = original.toLowerCase().replaceAll("\\s+", "");

        // Step 2: Apply palindrome logic (Two-pointer approach)
        boolean isPalindrome = isPalindrome(normalized);

        // Display result
        if (isPalindrome) {
            System.out.println("The sentence \"" + original + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The sentence \"" + original + "\" is NOT a Palindrome.");
        }
    }

    // Method to check palindrome using two-pointer technique
    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}