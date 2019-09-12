package duke.tasks;

/**
 * The Todo class represents a todo.
 */
public class Todo extends Task {
    protected boolean isDone;

    public Todo (String description) {
        super(description, "T");
        isDone = false;
    }
}