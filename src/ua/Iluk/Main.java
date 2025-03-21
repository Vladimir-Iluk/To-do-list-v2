package ua.Iluk;
import java.io.*;
import java.util.*;


public class Main {
    static List<Task> tasks = new ArrayList<>();
    public static void main(String[] args) {
        JsonStorage.readFromFile(tasks);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSelect a command:");
            System.out.println("1. Create ua.Iluk.Task");
            System.out.println("2. Delete ua.Iluk.Task");
            System.out.println("3. Read ua.Iluk.Task");
            System.out.println("4. Update ua.Iluk.Task");
            System.out.println("5. Search ua.Iluk.Task");
            System.out.println("6. Sort Tasks");
            System.out.println("7. Reversed sort tasks");
            System.out.println("8. Search ua.Iluk.Task by description");
            System.out.println("0. Exit");

            String command = scanner.nextLine();

            switch (command) {
                case "1": // Create Task
                    System.out.println("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String description = scanner.nextLine();
                    ToDoRepository.CreateTask(tasks,name,description);
                    System.out.println("Task created successfully!");
                    break;
                case "2": // Delete Task
                    System.out.println("Enter task name to delete: ");
                    String taskToDelete = scanner.nextLine();
                    ToDoRepository.DeleteTask(tasks,taskToDelete);
                    System.out.println("Task deleted successfully!");
                    break;
                case "3": // Read Task
                    System.out.println("Enter task name to read: ");
                    String taskToRead = scanner.nextLine();
                    ToDoRepository.ReadTask(tasks,taskToRead);
                    break;
                case "4": // Update Task
                    System.out.println("Enter task name to update: ");
                    String taskToUpdate = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String descriptionForUpdate = scanner.nextLine();
                    ToDoRepository.UpdateTask(tasks, taskToUpdate, descriptionForUpdate);

                    break;
                case "5": // Search ua.Iluk.Task by name
                    System.out.println("Enter keyword to search tasks by name: ");
                    String keyword = scanner.nextLine();
                    ToDoRepository.SearchTask(tasks,keyword);
                    break;
                case "6": // Sort Tasks
                    ToDoRepository.SortTask(tasks);
                    System.out.println("Tasks sorted by creation date.");
                    break;
                case "7": // Reversed sort Tasks
                    ToDoRepository.ReversedSortTask(tasks);
                    System.out.println("Tasks reversed sorted .");
                    break;
                case "8": // Search Task by description
                    System.out.println("Enter keyword to search tasks by description: ");
                    String keywordToSearch = scanner.nextLine();
                    ToDoRepository.SearchTaskByDescription(tasks,keywordToSearch);
                    break;
                case "0": // Exit
                    JsonStorage.writeToFile(tasks);
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


