public class Task {
    String name;
    String description;
    String comments;
    String date;

    public Task(String name, String description, String comments, String date) {
        this.name = name;
        this.description = description;
        this.comments = comments;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getComments() {
        return comments;
    }

    public String getDate() {
        return date;
    }
}
