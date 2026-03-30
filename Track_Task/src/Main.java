import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();

        while (true) {
            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

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

                taskList.add(new Task(id, title, desc, "Pending"));
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
                    System.out.println("🗑 Task deleted!");
                } else {
                    System.out.println("❌ Task not found.");
                }
            }

            else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}