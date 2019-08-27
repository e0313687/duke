public class Event extends Task {
    protected String at;

    public String getAt() {
        return this.at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public Event (String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}