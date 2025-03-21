package ua.Iluk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {
    private static final String path = "tasks.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void writeToFile(List<Task> tasks) {
        try(Writer writer = new FileWriter(path))
        {
            gson.toJson(tasks, writer);
            System.out.println("Tasks written successfully!");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void readFromFile(List<Task> tasks) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("No saved tasks found.");
            tasks = new ArrayList<>();
            return;
        }
        try (Reader reader = new FileReader(path)) {
            List<Task> loadedTasks = gson.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
            if (loadedTasks != null) {
                tasks = loadedTasks;
                System.out.println("Tasks read successfully!");
            } else {
                tasks = new ArrayList<>();
                System.out.println("Tasks list is empty!");
            }
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
    }
}
