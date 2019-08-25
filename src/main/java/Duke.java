import java.util.Scanner;

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
        System.out.println("Hello! I'm Duke");
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
        }

    }
}