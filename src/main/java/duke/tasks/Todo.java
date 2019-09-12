package duke.tasks;

public class Todo extends Task {
    protected boolean isDone;

    public Todo (String description) {
        super(description, "T");
        isDone = false;
    }
}