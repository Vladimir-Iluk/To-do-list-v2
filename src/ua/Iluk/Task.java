package ua.Iluk;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        return "ua.Iluk.Task Name: " + name + "\nDescription: " + description + "\nCreated At: " + sdf.format(createdAt);
    }
}
