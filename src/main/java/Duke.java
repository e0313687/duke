public class Duke {
    private static final String FILE_PATH = "duke.txt";

    private Duke(){
        Ui ui = new Ui();
        ui.showWelcome();
        Storage storage = new Storage(FILE_PATH, ui);
        while (true){
            String userInput = ui.readCommand();
            try {
                Command command = Parser.parse(userInput);
                command.execute(ui, storage);
                if (command instanceof ExitCommand) {
                    break;
                }
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main (String[] args){
        new Duke();
    }
}