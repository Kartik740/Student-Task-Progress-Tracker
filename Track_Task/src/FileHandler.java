import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String FILE_NAME = "tasks.txt";

    // Save tasks to file
    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Task t : tasks) {
                bw.write(t.toFileString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Load tasks from file
    public static List<Task> loadTasks() {

        List<Task> tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                Task t = new Task(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5]
                );

                tasks.add(t);
            }

        } catch (IOException e) {
            // First run → file won't exist → ignore
        }

        return tasks;
    }
}