/*
 * Application Name: PalindromeChecker App
 * Version: 1.0
 * Use Case 5: Stack-Based Palindrome Checker
 */

import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    // Main method - Entry point of the application
    public static void main(String[] args) {

        // Original string (can be changed for testing)
        String original = "madam";

        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push characters into the stack
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        // Pop characters and build reversed string
        String reversed = "";

        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        // Compare original and reversed string
        if (original.equals(reversed)) {
            System.out.println("The word \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + original + "\" is NOT a Palindrome.");
        }
    }
}