package duke.tasks;

import java.time.LocalDateTime;

/**
 * The Event class represents a event.
 */
public class Event extends Task {
    private LocalDateTime startDate;
    private String time;

    /**
     * This initializes a event with the given description and date.
     * @param description The description of this event.
     * @param startDate The date of this event.
     */
    public Event (String description, LocalDateTime startDate) {
        super(description, "E");
        this.startDate = startDate;
    }

    /**
     * This initializes a event with the given description and time.
     * @param description The description of this event.
     * @param time The time of this event.
     */
    public Event (String description, String time) {
        super(description, "E");
        this.time = time;
    }

    /**
     * This returns a string representation of this event.
     *
     * @return The desired string representation.
     */
    @Override
    public String toString(){
        return "[" + this.getType() + "][" + this.getStatusIcon() + "] " + this.getDescription() + " (at: " + (startDate == null ? time : startDate.toString()) + ")";
    }

    public String getTime() {
        return startDate == null ? time : startDate.toString();
    }
}