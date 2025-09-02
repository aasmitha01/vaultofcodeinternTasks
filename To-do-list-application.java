import java.util.ArrayList; 
import java.util.Scanner; 
// Class to represent a Task 
class Task { 
String description; 
boolean isCompleted; 
Task(String description) { 
this.description = description; 
this.isCompleted = false; 
} 
@Override 
public String toString() { 
return (isCompleted ? "[✔] " : "[ ] ") + description; 
} 
} 
public class Main { 
    static ArrayList<Task> tasks = new ArrayList<>(); 
    static Scanner sc = new Scanner(System.in); 
    static void showMenu() { 
        System.out.println("\n=== To-Do List Menu ==="); 
        System.out.println("1. Add Task"); 
        System.out.println("2. Delete Task"); 
        System.out.println("3. Display Tasks"); 
        System.out.println("4. Mark Task as Complete"); 
        System.out.println("5. Exit"); 
        System.out.print("Enter your choice: "); 
    } 
    static void addTask() { 
        System.out.print("Enter task description: "); 
        String desc = sc.nextLine(); 
        tasks.add(new Task(desc)); 
        System.out.println("Task added successfully!"); 
    } 
    static void displayTasks() { 
        if (tasks.isEmpty()) { 
            System.out.println("No tasks in the list."); 
            return; 
        } 
        System.out.println("\nYour To-Do List:"); 
        for (int i = 0; i < tasks.size(); i++) { 
            System.out.println((i + 1) + ". " + tasks.get(i)); 
        } 
} 
    static void deleteTask() { 
        displayTasks(); 
        if (tasks.isEmpty()) return; 
        System.out.print("Enter task number to delete: "); 
        int idx = readInt(); 
        if (idx >= 1 && idx <= tasks.size()) { 
            tasks.remove(idx - 1); 
            System.out.println("Task deleted successfully!"); 
        } else { 
            System.out.println("Invalid task number!"); 
        } 
    } 
    static void markComplete() { 
        displayTasks(); 
        if (tasks.isEmpty()) return; 
        System.out.print("Enter task number to mark complete: "); 
        int idx = readInt(); 
        if (idx >= 1 && idx <= tasks.size()) { 
            tasks.get(idx - 1).isCompleted = true; 
            System.out.println("Task marked as complete!"); 
        } else { 
            System.out.println("Invalid task number!"); 
        } 
    } 
static int readInt() { 
        while (!sc.hasNextInt()) { 
            System.out.print("Please enter a number: "); 
            sc.next(); 
        } 
        int val = sc.nextInt(); 
        sc.nextLine(); 
        return val; 
    } 
public static void main(String[] args) { 
        int choice; 
        do { 
            showMenu(); 
            choice = readInt(); 
            switch (choice) { 
                case 1: addTask(); break; 
                case 2: deleteTask(); break; 
                case 3: displayTasks(); break; 
                case 4: markComplete(); break; 
                case 5: System.out.println("Exiting... Goodbye!"); break; 
                default: System.out.println("Invalid choice! Try again."); 
            } 
        } while (choice != 5); 
    } 
}
