public class Task {

    private int id;
    private String title;
    private String description;
    private String status; // Pending / Completed
    private String priority;   // Low / Medium / High
    private String deadline;   // simple string (e.g. 2026-04-10)

    // Constructor
    public Task(int id, String title, String description, String status, String priority, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.deadline = deadline;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // Setter (only for status)
    public void setStatus(String status) {
        this.status = status;
    }

    // toString method (VERY important for printing)

    @Override
    public String toString() {
        return "ID: " + id +
                " | Title: " + title +
                " | Desc: " + description +
                " | Status: " + status +
                " | Priority: " + priority +
                " | Deadline: " + deadline;
    }

    public String toFileString() {
        return id + "," + title + "," + description + "," + status + "," + priority + "," + deadline;
    }

    public String getPriority() {
        return priority;
    }

    public String getDeadline() {
        return deadline;
    }


}