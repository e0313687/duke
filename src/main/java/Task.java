public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected String time;

    public Task(String description, String type) {
        this.description = description;
        this.isDone = false;
    }

    public void setType(String type){
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

    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.getDescription() + " ";
    }
}


