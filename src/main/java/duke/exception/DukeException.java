package duke.exception;

/**
 * The DukeException class is an error during operation of the program.
 */
public class DukeException extends Exception{
    public DukeException(String message) {
        super(message);
    }
}