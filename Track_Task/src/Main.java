import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>(FileHandler.loadTasks());

        while (true) {
            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("6. Sort by Priority");
            System.out.println("7. Show Pending Tasks");
            System.out.println("8. Show Completed Tasks");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Description: ");
                String desc = sc.nextLine();

                System.out.print("Enter Priority (Low/Medium/High): ");
                String priority = sc.nextLine();

                System.out.print("Enter Deadline (YYYY-MM-DD): ");
                String deadline = sc.nextLine();

                taskList.add(new Task(id, title, desc, "Pending", priority, deadline));
                FileHandler.saveTasks(taskList);
                System.out.println("✅ Task Added!");

            }

            else if (choice == 2) {
                if (taskList.isEmpty()) {
                    System.out.println("⚠ No tasks available.");
                } else {
                    for (Task t : taskList) {
                        System.out.println(t);
                    }
                }
            }

            else if (choice == 3) {
                System.out.print("Enter Task ID to mark complete: ");
                int id = sc.nextInt();

                boolean found = false;

                for (Task t : taskList) {
                    if (t.getId() == id) {
                        t.setStatus("Completed");
                        FileHandler.saveTasks(taskList);
                        found = true;
                        System.out.println("✅ Task marked as completed!");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("❌ Task not found.");
                }
            }

            else if (choice == 4) {
                System.out.print("Enter Task ID to delete: ");
                int id = sc.nextInt();

                boolean removed = taskList.removeIf(t -> t.getId() == id);

                if (removed) {
                    FileHandler.saveTasks(taskList);
                    System.out.println("🗑 Task deleted!");
                } else {
                    System.out.println("❌ Task not found.");
                }
            }
            else if (choice == 6) {

                taskList.sort((t1, t2) -> {
                    return getPriorityValue(t1.getPriority()) - getPriorityValue(t2.getPriority());
                });

                System.out.println("📊 Tasks sorted by priority!");
            }

            else if (choice == 7) {

                for (Task t : taskList) {
                    if (t.getStatus().equalsIgnoreCase("Pending")) {
                        System.out.println(t);
                    }
                }
            }

            else if (choice == 8) {

                for (Task t : taskList) {
                    if (t.getStatus().equalsIgnoreCase("Completed")) {
                        System.out.println(t);
                    }
                }
            }
            else if (choice == 9) {
                System.out.println("Exiting...");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }



        sc.close();


    }

    public static int getPriorityValue(String priority) {
        switch (priority.toLowerCase()) {
            case "high": return 1;
            case "medium": return 2;
            case "low": return 3;
            default: return 4;
        }
    }
}