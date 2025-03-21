package ua.Iluk;
import java.util.List;
import java.io.*;
import java.util.*;

public class ToDoRepository {
    public static void CreateTask(List<Task> tasks, String name, String description ){
        tasks.add(new Task(name, description));
    }
    public static void DeleteTask(List<Task> tasks, String taskToDelete){
        tasks.removeIf(task -> task.name.equalsIgnoreCase(taskToDelete));
    }
    public static void ReadTask(List<Task> tasks, String taskToRead){
        for (Task task : tasks) {
            if (task.name.equalsIgnoreCase(taskToRead)) {
                System.out.println(task);
            }
        }
    }
    public static void UpdateTask(List<Task> tasks, String taskToUpdate,String descriptionForUpdate){

        for (Task task : tasks) {
            if (task.name.equalsIgnoreCase(taskToUpdate)) {
                System.out.println("Enter new task description: ");
                task.description = descriptionForUpdate;
                System.out.println("Task updated successfully!");
            }
        }
    }
    public static void SearchTask(List<Task> tasks,String keyword){
        for (Task task : tasks) {
            if (task.name.contains(keyword)) {
                System.out.println(task);
            } else {
                System.out.println("Task not found!");
            }
        }
    }
    public static void SortTask(List<Task> tasks){
        tasks.sort(Comparator.comparing(task -> task.createdAt));
    }
    public static void ReversedSortTask(List<Task> tasks){
        tasks.sort(Comparator.comparing((Task task) -> task.createdAt).reversed());
    }
    public static void SearchTaskByDescription(List<Task> tasks,String keywordToSearch){
        for (Task task : tasks) {
            if(task.description.contains(keywordToSearch)) {
                System.out.println(task);
            }else{
                System.out.println("Task not found!");
            }
        }
    }
}
