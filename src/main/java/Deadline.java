import java.util.Date;

public class Deadline extends Task {

    public String getBy() {
        return this.time;
    }

    public void setBy(String by) {
        this.time = time;
    }

    public Deadline (String description, String time) {
        super(description, "D");
        this.time = time;
    }
}