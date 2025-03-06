import java.util.*;
import java.text.*;

class Task {
    String name;
    String description;
    Date createdAt;

    Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.createdAt = new Date();
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Task Name: " + name + "\nDescription: " + description + "\nCreated At: " + sdf.format(createdAt);
    }
}

public class Main {
    static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSelect a command:");
            System.out.println("1. Create Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Read Task");
            System.out.println("4. Update Task");
            System.out.println("5. Search Task");
            System.out.println("6. Sort Tasks");
            System.out.println("7. Exit");

            String command = scanner.nextLine();

            switch (command) {
                case "1": // Create Task
                    System.out.println("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String description = scanner.nextLine();
                    tasks.add(new Task(name, description));
                    System.out.println("Task created successfully!");
                    break;
                case "2": // Delete Task
                    System.out.println("Enter task name to delete: ");
                    String taskToDelete = scanner.nextLine();
                    tasks.removeIf(task -> task.name.equalsIgnoreCase(taskToDelete));
                    System.out.println("Task deleted successfully!");
                    break;
                case "3": // Read Task
                    System.out.println("Enter task name to read: ");
                    String taskToRead = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.name.equalsIgnoreCase(taskToRead)) {
                            System.out.println(task);
                        }
                    }
                    break;
                case "4": // Update Task
                    System.out.println("Enter task name to update: ");
                    String taskToUpdate = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.name.equalsIgnoreCase(taskToUpdate)) {
                            System.out.println("Enter new task description: ");
                            task.description = scanner.nextLine();
                            System.out.println("Task updated successfully!");
                        }
                    }
                    break;
                case "5": // Search Task
                    System.out.println("Enter keyword to search tasks: ");
                    String keyword = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.name.contains(keyword) || task.description.contains(keyword)) {
                            System.out.println(task);
                        }
                    }
                    break;
                case "6": // Sort Tasks
                    tasks.sort(Comparator.comparing(task -> task.createdAt));
                    System.out.println("Tasks sorted by creation date.");
                    break;
                case "7": // Exit
                    System.out.println("Application closed");
                    running = false;
                    break;
                default:
                    System.out.println("Command not recognized!");
            }
        }
        scanner.close();
    }
}