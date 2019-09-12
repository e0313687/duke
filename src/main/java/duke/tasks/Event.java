package duke.tasks;

import java.time.LocalDateTime;

public class Event extends Task {
    private LocalDateTime startDate;
    private String time;

    public Event (String description, LocalDateTime startDate) {
        super(description, "E");
        this.startDate = startDate;
    }

    public Event (String description, String time) {
        super(description, "E");
        this.time = time;
    }

    @Override
    public String toString(){
        return "[" + this.getType() + "][" + this.getStatusIcon() + "] " + this.getDescription() + " (at: " + (startDate == null ? time : startDate.toString()) + ")";
    }

    public String getTime() {
        return startDate == null ? time : startDate.toString();
    }
}