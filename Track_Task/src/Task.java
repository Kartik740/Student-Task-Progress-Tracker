public class Task {

    private int id;
    private String title;
    private String description;
    private String status; // Pending / Completed

    // Constructor
    public Task(int id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
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
                " | Description: " + description +
                " | Status: " + status;
    }
}