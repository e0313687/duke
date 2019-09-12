package duke.tasks;

import java.util.Date;

/**
 * The Task class represents a task.
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected String time;

    /**
     * This initializes a task with the given description.
     * @param description The description of this task.
     * @param type The type of this task.
     */
    public Task(String description, String type) {
        this.description = description;
        this.isDone = false;
        this.type = type;
    }

    public String getStatusIcon() {
        return (isDone ? "✓" : "\u2718");
    }

    public boolean getDone() {
        return isDone;
    }

    public String getType() {
        return this.type;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return this.description;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * This returns a string representation of this task.
     *
     * @return The desired string representation.
     */
    public String toString(){
        return "[" + this.getType() + "][" + this.getStatusIcon() + "] " + this.getDescription() + " ";
    }
}


