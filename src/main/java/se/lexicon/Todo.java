package se.lexicon;


public class Todo {

    private int todoId;
    private String title;
    private String description;
    private String deadline;
    private boolean done;
    private int assignee_id;

    public Todo() {
    }

    public Todo(String title, String description, String deadline, boolean done, int assignee_id) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee_id = assignee_id;
    }

    public Todo(String title, String description, String deadline, boolean done) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
    }

    public Todo(int todoId, String title, String description, String deadline, boolean done, int assignee_id) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee_id = assignee_id;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
        this.assignee_id = assignee_id;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assignee_id=" + assignee_id +
                '}';
    }
}