package duke.parser;

import duke.command.*;
import duke.exception.DukeException;

/**
 * The Parser class deals with making sense of the user command, which reads from standard input and returns Command.
 */
public class Parser {

    /**
     * This parses the userInput and returns a Command.
     *
     * @param userInput The userInput read by the user Interface.
     * @return The corresponding Command.
     * @throws DukeException If userInput is invalid.
     */
    public static Command parse(String userInput) throws DukeException {
        String commandWord = getCommandWord(userInput);
        switch (commandWord) {
            case "bye":
                return new ExitCommand();
            case "deadline":
                return new AddCommand(ParserUtil.createDeadline(userInput));
            case "delete":
                return new DeleteCommand(ParserUtil.getIndex(userInput));
            case "done":
                return new MarkAsDoneCommand(ParserUtil.getIndex(userInput));
            case "event":
                return new AddCommand(ParserUtil.createEvent(userInput));
            case "find":
                return new FindCommand(getWord(userInput));
            case "list":
                return new ListCommand();
            case "todo":
                return new AddCommand(ParserUtil.createTodo(userInput));
            default:
                throw new DukeException("I'm sorry, I don't understand.");
        }
    }

    /**
     * This gets command word from the userInput.
     *
     * @param userInput The userInput read by the user interface.
     * @return The command word.
     */
    private static String getCommandWord(String userInput) {
        return userInput.strip().split(" ")[0];
    }

    /**
     * This gets word from the userInput.
     *
     * @param userInput The userInput read by the user interface.
     * @return The word.
     * @throws DukeException If userInput is invalid.
     */
    private static String getWord(String userInput) throws DukeException {
        try {
            return userInput.strip().split(" ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Invalid format. Refer to help for command format.");
        }
    }
}
