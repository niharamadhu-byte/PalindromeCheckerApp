import java.util.*;

// Reuse the Strategy Interface from UC12
interface PalindromeStrategy {
    boolean isValid(String input);
    String getName();
}

// 1. Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {
    public String getName() { return "Stack-Based (LIFO)"; }
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// 2. Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {
    public String getName() { return "Deque-Based (Two-Ended)"; }
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 3. Simple Two-Pointer Strategy (Control Group)
class TwoPointerStrategy implements PalindromeStrategy {
    public String getName() { return "Two-Pointer (Standard)"; }
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        }
        return true;
    }
}

public class UseCase13PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        System.out.println("--- Palindrome Performance Benchmarking ---");
        System.out.print("Enter a string to test: ");
        String input = scanner.nextLine();

        System.out.println("\nResults:");
        System.out.printf("%-25s | %-10s | %-15s%n", "Algorithm", "Result", "Time (nanos)");
        System.out.println("-------------------------------------------------------------");

        for (PalindromeStrategy strategy : strategies) {
            // Start Timer
            long startTime = System.nanoTime();

            boolean result = strategy.isValid(input);

            // End Timer
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%-25s | %-10s | %-15d%n",
                    strategy.getName(),
                    (result ? "PASS" : "FAIL"),
                    duration);
        }

        scanner.close();
    }
}