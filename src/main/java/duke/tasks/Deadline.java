package duke.tasks;

import java.time.LocalDateTime;

/**
 * The Deadline class represents a deadline.
 */
public class Deadline extends Task {
    private LocalDateTime startDate;
    private String time;

    /**
     * This initializes a deadline with the given description and date.
     * @param description The description of this deadline.
     * @param startDate The date of this deadline.
     */
    public Deadline (String description, LocalDateTime startDate) {
        super(description, "D");
        this.startDate = startDate;
    }

    /**
     * This initializes a deadline with the given description and date.
     * @param description The description of this deadline.
     * @param time The date of this deadline.
     */
    public Deadline (String description, String time) {
        super(description, "D");
        this.time = time;
    }

    /**
     * This returns a string representation of this deadline.
     *
     * @return The desired string representation.
     */
    @Override
    public String toString(){
        return "[" + this.getType() + "][" + this.getStatusIcon() + "] " + this.getDescription() + " (by: " + (startDate == null ? time : startDate.toString()) + ")";
    }

    public String getTime() {
        return startDate == null ? time : startDate.toString();
    }
}