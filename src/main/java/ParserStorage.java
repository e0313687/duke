import java.lang.reflect.Member;

public class ParserStorage {
    public static Task createTaskFromStorage(String line) throws DukeException{
        String[] taskParts = line.split("\\|");
        try {
            String type = taskParts[0].strip();
            String status = taskParts[1].strip();
            String description = taskParts[2].strip();
            Task task;
            if (type.equals("D")) {
                try {
                    task = new Deadline(description, ParserTime.parseStringToDate(taskParts[3].strip()));
                } catch (DukeException e) {
                    task = new Deadline(description, taskParts[3].strip());
                }
            } else if (type.equals("E")) {
                try {
                    task = new Event(description, ParserTime.parseStringToDate(taskParts[3].strip()));
                } catch (DukeException e) {
                    task = new Event(description, taskParts[3].strip());
                }
            } else {
                task = new Todo(description);
            }
            task.markAsDone();
            return task;
        } catch (Exception e) {
            throw new DukeException(" Rip, Task cannot be converted to String!");
        }
    }

    public static String toStorageString(Task task) throws DukeException {
        if (task instanceof Deadline) {
            return "D | " + task.getDone() + " | " + task.getDescription() + ((Deadline) task).getTime();
        } else if (task instanceof Event) {
            return "E | " + task.getDone() + " | " + task.getDescription() + ((Event) task).getTime();
        } else if (task instanceof Todo) {
            return "T | " + task.getDone() + " | " + task.getDescription();
        }
        throw new DukeException(" Rip, Task cannot be converted to String!");
    }
}
