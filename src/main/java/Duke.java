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
        /*System.out.println("Hello! I'm Duke");
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
        }*/

        //Level 4 & 5
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Task[] userCommands = new Task[100];

        int temp = 0;

        while(true) {
            Scanner command = new Scanner(System.in);
            String userCommand = command.nextLine();
            StringTokenizer defaultTokenizer = new StringTokenizer(userCommand);
            String firstWord = defaultTokenizer.nextToken();

            if (userCommand.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            if (firstWord.equals("done")) {
                //if (defaultTokenizer.countTokens() > 0) {
                try {
                    int done = Integer.parseInt(defaultTokenizer.nextToken());
                    if (temp < 1) {
                        System.out.println(" ☹ OOPS!!! You don't have any tasks in your list yet.");
                    } else if (done > temp) {
                        System.out.println(" ☹ OOPS!!! You only have " + temp + " tasks in your list.");
                    } else {
                        userCommands[done - 1].markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  [" + userCommands[done - 1].getStatusIcon() + "] " + userCommands[done - 1].getDescription());
                    }
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! Please tell me which task you have completed.");
                }
            } else if (firstWord.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < temp; i++) {
                    //System.out.println(i+1 + ".[" + userCommands[i].getStatusIcon() + "] " + userCommands[i].getDescription());
                    System.out.println(i + 1 + "." + userCommands[i].toString());
                }
            } else if (firstWord.equals("todo")) {
                //if (defaultTokenizer.countTokens() > 0){
                try {
                    String[] tempTodo = userCommand.split(" ", 2);
                    userCommands[temp] = new Todo(tempTodo[1]);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + userCommands[temp].toString());
                    temp++;
                    System.out.println("Now you have " + temp + " tasks in the list.");
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                }
            } else if (firstWord.equals("deadline")) {
                //if (defaultTokenizer.countTokens() > 0) {
                try {
                    String[] tempDeadline = userCommand.split("/");
                    String[] taskName = tempDeadline[0].split(" ", 2);
                    String[] byDate = tempDeadline[1].split(" ", 2);
                    userCommands[temp] = new Deadline(taskName[1], byDate[1]);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + userCommands[temp].toString());
                    temp++;
                    System.out.println("Now you have " + temp + " tasks in the list.");
                } catch (Exception e){
                    System.out.println(" ☹ OOPS!!! The description of a deadline cannot be empty.");
                }
            } else if (firstWord.equals("event")) {
                //if (defaultTokenizer.countTokens() > 0) {
                try {
                    String[] tempEvent = userCommand.split("/");
                    String[] taskName = tempEvent[0].split(" ", 2);
                    String[] atPlace = tempEvent[1].split(" ", 2);
                    userCommands[temp] = new Event(taskName[1], atPlace[1]);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + userCommands[temp].toString());
                    temp++;
                    System.out.println("Now you have " + temp + " tasks in the list.");
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! The description of an event cannot be empty.");
                }
            } else {
                System.out.println(" ☹ OOPS!!! I don't understand.");
            }
        }
    }
}