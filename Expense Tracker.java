import java.util.*; 
class Expense { 
    String category; 
    double amount; 
    Expense(String category, double amount) { 
        this.category = category; 
        this.amount = amount; 
    } 
    @Override 
    public String toString() { 
        return category + " : Rs." + amount; 
    } 
} 
public class Main { 
    static ArrayList<Expense> expenses = new ArrayList<>(); 
    static Scanner sc = new Scanner(System.in); 
    static void addExpense() { 
        System.out.print("Enter category: "); 
        String cat = sc.nextLine(); 
        System.out.print("Enter amount: "); 
        double amt = sc.nextDouble(); 
        sc.nextLine();  
        expenses.add(new Expense(cat, amt)); 
        System.out.println("Expense added successfully!"); 
    } 
    static void viewExpenses() { 
        if (expenses.isEmpty()) { 
            System.out.println("No expenses recorded yet."); 
            return; 
        } 
        System.out.println("\nAll Expenses:"); 
        for (Expense e : expenses) { 
            System.out.println(e); 
        } 
    } 
    static void viewTotal() { 
        double total = 0; 
        for (Expense e : expenses) total += e.amount; 
        System.out.println("Total Expenses: Rs." + total); 
    } 
    static void viewByCategory() { 
        if (expenses.isEmpty()) { 
            System.out.println("No expenses recorded yet."); 
            return; 
        } 
        HashMap<String, Double> map = new HashMap<>(); 
        for (Expense e : expenses) { 
            map.put(e.category, map.getOrDefault(e.category, 0.0) + e.amount); 
        } 
        System.out.println("\nExpenses by Category:"); 
        for (String cat : map.keySet()) { 
            System.out.println(cat + " : Rs." + map.get(cat));        } 
    } 
    public static void main(String[] args) { 
        int choice; 
        do { 
            System.out.println("\n=== Expense Tracker Menu ==="); 
            System.out.println("1. Add Expense"); 
            System.out.println("2. View All Expenses"); 
            System.out.println("3. View Total Expenses"); 
            System.out.println("4. View Expenses by Category"); 
            System.out.println("5. Exit"); 
            System.out.print("Enter choice: "); 
            while (!sc.hasNextInt()) { 
                System.out.print("Enter valid number: "); 
                sc.next(); 
            } 
            choice = sc.nextInt(); 
            sc.nextLine(); 
            switch (choice) { 
                case 1 -> addExpense(); 
                case 2 -> viewExpenses(); 
                case 3 -> viewTotal(); 
                case 4 -> viewByCategory(); 
                case 5 -> System.out.println("Exiting... Goodbye!"); 
                default -> System.out.println("Invalid choice!"); 
            } 
        } while (choice != 5); 
} 
}
