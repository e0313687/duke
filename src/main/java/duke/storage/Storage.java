package duke.storage;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import duke.exception.DukeException;
import duke.parser.ParserStorage;
import duke.tasks.Task;
import duke.ui.Ui;

public class Storage {
    //deals with loading tasks from the file and saving tasks in the file
    private String filePath;
    private ArrayList<Task> userCommands;
    private Ui ui;

    public Storage(String filePath, Ui ui){
        this.filePath = filePath;
        this.ui = ui;
        load();
    }

    private void load(){
        ArrayList<Task> newTasks = new ArrayList<>();
        try {
            File f = new File(filePath);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                newTasks.add(ParserStorage.createTaskFromStorage(s.nextLine()));
            }
            s.close();
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Oh no, file not found!");
        }
        userCommands = newTasks;
    }

    public void write() {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (Task task : userCommands) {
                writer.write(ParserStorage.toStorageString(task) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Oops, file not saved!");
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        }
    }

    public ArrayList<Task> getTasks() {
        return userCommands;
    }
}
