import java.util.Scanner;
import java.util.Stack;

/**
 * UC11: Object-Oriented Palindrome Service
 * This class encapsulates the logic for palindrome validation.
 */
class PalindromeChecker {

    public boolean checkPalindrome(String input) {
        // Sanitize input: remove non-alphanumeric and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanInput.isEmpty()) return false;

        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }

        // Pop characters and compare with the original clean string
        for (char c : cleanInput.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the Service Object
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("--- Palindrome Checker (OOPS Version) ---");
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Use the service method
        boolean isPalindrome = checker.checkPalindrome(userInput);

        if (isPalindrome) {
            System.out.println("Result: '" + userInput + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}