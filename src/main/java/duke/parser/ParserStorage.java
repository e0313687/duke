package duke.parser;

import duke.exception.DukeException;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

/**
 * The ParserStorage class deals with storage related operations.
 */
public class ParserStorage {

    /**
     * This parses a task from String format stored in the files back to the task.
     *
     * @param line The String description of a task.
     * @return The corresponding task object.
     * @throws DukeException If the task cannot be converted.
     */
    public static Task createTaskFromStorage(String line) throws DukeException {
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

    /**
     * This parses a task from task to String format in order to be stored.
     *
     * @param task The task
     * @return The corresponding String format of the task object.
     * @throws DukeException If the task cannot be converted.
     */
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
