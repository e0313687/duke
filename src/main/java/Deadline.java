import java.time.LocalDateTime;

public class Deadline extends Task {
    private LocalDateTime startDate;
    private String time;

    public Deadline (String description, LocalDateTime startDate) {
        super(description, "D");
        this.startDate = startDate;
    }

    public Deadline (String description, String time) {
        super(description, "D");
        this.time = time;
    }

    @Override
    public String toString(){
        return "[" + this.getType() + "][" + this.getStatusIcon() + "] " + this.getDescription() + " (by: " + (startDate == null ? time : startDate.toString()) + ")";
    }

    public String getTime() {
        return startDate == null ? time : startDate.toString();
    }
}