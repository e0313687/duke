package duke.ui;

import duke.tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Ui class interacts with the user as it handles user input and messages shown to user of this application.
 */
public class Ui {
    private Scanner scanner;

    public Ui(){
        scanner = new Scanner(System.in);
    }

    /**
     * This prints the description of the task.
     * @param task
     */
    public void showAdd(Task task) {
        System.out.println("Got it. I've added this task: ");
        System.out.println(task);
    }

    /**
     * This prints the bye message to the user when they exit the program.
     */
    public void showBye() {
        System.out.print("Bye. Hope to see you again soon!");
    }

    /**
     * This prints the task that is deleted.
     * @param task
     */
    public void showDelete (Task task) {
        System.out.println("Alright! I've removed this task: ");
        System.out.println(task);
    }

    /**
     * This prints an error message to the user.
     * @param errorMessage The error message shown.
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * This prints the task that is marked as done.
     * @param task
     */
    public void showMarkDone (Task task) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(task);
    }

    /**
     * This prints the list of the tasks.
     * @param userCommands The list of tasks.
     */
    public void showList(ArrayList<Task> userCommands) {
        for (int i = 0; i < userCommands.size(); i++) {
            System.out.println((i+1) + ". " + userCommands.get(i));
        }
    }

    /**
     * This prints the number of tasks in the list.
     * @param userCommands The list of tasks.
     */
    public void showTotal (ArrayList<Task> userCommands) {
        System.out.println("Now you have " + userCommands.size() + " tasks in the list.");
    }

    /**
     * This prints a welcome message to the user at the startup.
     */
    public void showWelcome(){
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    /**
     * This scans the next line from standard input, returning a String containing the user input with leading and trailing whitespaces removed.
     *
     * @return The String corresponding to the user input.
     */
    public String readCommand(){
        String line = scanner.nextLine().strip();
        System.out.println("\n" + line);
        return line;
    }
}
