import java.util.Scanner;
import java.util.StringTokenizer;

public class Duke {
    public static void main(String[] args) {

        //Level 0
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/

        //Level 1
        /*System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        while(true){
            Scanner command = new Scanner(System.in);
            String userCommand = command.nextLine();
            if (userCommand.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            System.out.println(userCommand);
        }*/

        //Level 2
        /*System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String userCommands[] = new String[100];
        int temp = 0;

        while(true) {
            Scanner command = new Scanner(System.in);
            String userCommand = command.nextLine();
            if (userCommand.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            if (userCommand.equals("list")) {
                for (int i = 0; i < temp; i++) {
                    System.out.println(i+1 + ". " + userCommands[i]);
                }
            }
            else {
                userCommands[temp] = userCommand;
                temp++;
                System.out.println("added: " + userCommand);
            }
        }*/

        //Level 3
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Task[] userCommands = new Task[100];
        int temp = 0;

        while(true) {
            Scanner command = new Scanner(System.in);
            String userCommand = command.nextLine();
            StringTokenizer defaultTokenizer = new StringTokenizer(userCommand);

            if (userCommand.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            if (defaultTokenizer.countTokens() == 2 && defaultTokenizer.nextToken().equals("done")) {
                int done = Integer.parseInt(defaultTokenizer.nextToken());
                userCommands[done-1].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  [" + userCommands[done-1].getStatusIcon() + "] " + userCommands[done-1].getDescription());

            }
            else if (userCommand.equals("list")) {
                for (int i = 0; i < temp; i++) {
                    System.out.println(i+1 + ".[" + userCommands[i].getStatusIcon() + "] " + userCommands[i].getDescription());
                }
            }
            else {
                userCommands[temp] = new Task(userCommand);
                temp++;
                System.out.println("added: " + userCommand);
            }
        }
    }
}