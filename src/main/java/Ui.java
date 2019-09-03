import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
//interactions with the user
    private Scanner scanner;

    public Ui(){
        scanner = new Scanner(System.in);
    }

    public void showAdd(Task task) {
        System.out.println("Got it. I've added this task: ");
        System.out.println(task);
    }

    public void showBye() {
        System.out.print("Bye. Hope to see you again soon!");
    }

    public void showDelete (Task task) {
        System.out.println("Alright! I've removed this task: ");
        System.out.println(task);
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void showMarkDone (Task task) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(task);
    }

    public void showList(ArrayList<Task> userCommands) {
        for (int i = 0; i < userCommands.size(); i++) {
            System.out.println((i+1) + ". " + userCommands.get(i));
        }
    }

    public void showTotal (ArrayList<Task> userCommands) {
        System.out.println("Now you have " + userCommands.size() + " tasks in the list.");
    }

    public String readCommand(){
        String line = scanner.nextLine().strip();
        System.out.println("\n" + line);
        return line;
    }

    public void showWelcome(){
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }
}
