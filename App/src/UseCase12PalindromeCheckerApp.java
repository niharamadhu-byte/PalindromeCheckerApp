import java.util.*;

// 1. Define the Strategy Interface
interface PalindromeStrategy {
    boolean isValid(String input);
}

// 2. Implementation using a Stack (LIFO)
class StackStrategy implements PalindromeStrategy {
    @Override
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

// 3. Implementation using a Deque (Double-Ended Queue)
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char c : clean.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            // Compare front and back simultaneously
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// 4. The Context class that uses the strategy
class PalindromeService {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        if (strategy == null) throw new IllegalStateException("Strategy not set!");
        return strategy.isValid(text);
    }
}

public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeService service = new PalindromeService();

        System.out.println("--- Advanced Palindrome Checker (Strategy Pattern) ---");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        System.out.println("Select Algorithm: 1. Stack (LIFO) | 2. Deque (Head/Tail)");
        int choice = scanner.nextInt();

        // Polymorphism in action: Injecting the strategy at runtime
        if (choice == 1) {
            service.setStrategy(new StackStrategy());
            System.out.println("Using Stack Strategy...");
        } else {
            service.setStrategy(new DequeStrategy());
            System.out.println("Using Deque Strategy...");
        }

        boolean result = service.check(input);
        System.out.println("Result: Is Palindrome? " + result);

        scanner.close();
    }
}