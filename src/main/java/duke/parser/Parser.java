package duke.parser;

import duke.command.*;
import duke.exception.DukeException;

public class Parser {
    //deals with making sense of the user command
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

    private static String getCommandWord(String userInput) {
        return userInput.strip().split(" ")[0];
    }

    private static String getWord(String userInput) throws DukeException {
        try {
            return userInput.strip().split(" ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Invalid format. Refer to help for command format.");
        }
    }
}
