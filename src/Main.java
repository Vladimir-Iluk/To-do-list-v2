import java.util.*;
import java.text.*;

1
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
            System.out.println("7. Reversed sort tasks");
            System.out.println("8. Search Task by description");
            System.out.println("0. Exit");

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
                case "5": // Search Task by name
                    System.out.println("Enter keyword to search tasks by name: ");
                    String keyword = scanner.nextLine();
                    for (Task task : tasks) {
                        if (task.name.contains(keyword)) {
                            System.out.println(task);
                        } else {
                            System.out.println("Task not found!");
                        }
                    }
                    break;
                case "6": // Sort Tasks
                    tasks.sort(Comparator.comparing(task -> task.createdAt));
                    System.out.println("Tasks sorted by creation date.");
                    break;
                case "7": // Reversed sort Tasks
                    tasks.sort(Comparator.comparing((Task task) -> task.createdAt).reversed());
                    System.out.println("Tasks sorted by description.");
                    break;
                case "8": // Search Task by description
                    System.out.println("Enter keyword to search tasks by description: ");
                    String keywordToSearch = scanner.nextLine();
                    for (Task task : tasks) {
                        if(task.description.contains(keywordToSearch)) {
                            System.out.println(task);
                        }else{
                            System.out.println("Task not found!");
                        }
                    }
                    break;
                case "0": // Exit
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