public class ParserUtil {
    static Todo createTodo(String userInput) throws DukeException {
        String description = userInput.substring("todo".length()).strip();
        if (description.isEmpty()) {
            System.out.println("Ah oh, the description cannot be empty.");
        }
        return new Todo(description);
    }

    static Deadline createDeadline(String userInput) throws DukeException {
        String[] deadlineDetails = userInput.substring("deadline".length()).strip().split("/by");
        if ((deadlineDetails.length != 2) || (deadlineDetails[1] == null)) {
            System.out.println("Invalid format. Refer to help for command format.");
        }
        if (deadlineDetails[0].strip().isEmpty()) {
            System.out.println("Ah oh, the description cannot be empty.");
        }
        try {
            return new Deadline(deadlineDetails[0].strip(), ParserTime.parseStringToDate(deadlineDetails[1].strip()));
        } catch (DukeException e) {
            return new Deadline(deadlineDetails[0].strip(), deadlineDetails[1].strip());
        }
    }

    static Event createEvent (String userInput) throws DukeException {
        String[] eventDetails = userInput.substring("event".length()).strip().split("/by");
        if (eventDetails.length != 2 || eventDetails[1] == null) {
            System.out.println("Invalid format. Refer to help for command format.");
        }
        if (eventDetails[0].strip().isEmpty()) {
            System.out.println("Ah oh, the description cannot be empty.");
        }
        try {
            return new Event(eventDetails[0].strip(), ParserTime.parseStringToDate(eventDetails[1].strip()));
        } catch (DukeException e) {
            return new Event(eventDetails[0].strip(), eventDetails[1].strip());
        }
    }

    static int getIndex (String userInput) throws DukeException {
        try {
            int temp = Integer.parseInt(userInput.replaceAll("\\D+", ""));
            return temp-1;
        } catch (NumberFormatException e) {
            throw new DukeException("Invalid format. Refer to help for command format.");
        }
    }
}
