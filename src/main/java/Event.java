public class Event extends Task {

    public String getAt() {
        return this.time;
    }

    public void setAt(String at) {
        this.time = time;
    }

    public Event (String description, String time) {
        super(description, "E");
        this.time = time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + time + ")";
    }
}