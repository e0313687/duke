import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Duke {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        Path file = Paths.get("duke.txt");
        FileWriter out = new FileWriter(String.valueOf(file), true);

        ArrayList<Task> userCommands = new ArrayList<Task>();

        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            String nextline = sc.nextLine();
            String[] lineParts = nextline.split("\\|");
            String type = lineParts[0];
            String done = lineParts[1];
            String description = lineParts[2];
            switch (type) {
                case "T": {
                    Task command = new Task(description, "T");
                    command.isDone = done.equals("1");
                    userCommands.add(command);
                    break;
                }
                case "D": {
                    Task command = new Deadline(description, lineParts[3]);
                    command.isDone = done.equals("1");
                    userCommands.add(command);
                    break;
                }
                case "E": {
                    Task command = new Event(description, lineParts[3]);
                    command.isDone = done.equals("1");
                    userCommands.add(command);
                    break;
                }
            }
        }

        while(true) {
            Scanner command = new Scanner(System.in);
            String userCommand = command.nextLine();
            StringTokenizer defaultTokenizer = new StringTokenizer(userCommand);
            String firstWord = defaultTokenizer.nextToken();

            if (userCommand.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                new FileWriter("duke.txt").close();
                for(Task i : userCommands) {
                    String done = i.getDone() ? "1" : "0";
                    if (i.getType().equals("T")) {
                        out.write("T|" + done + "|" + i.getDescription() + "\n");
                    } else if (i.getType().equals("D")) {
                        out.write("D|" + done + "|" + i.getDescription() + "|" + i.getTime() + "\n");
                    } else if (i.getType().equals("E")) {
                        out.write("E|" + done + "|" + i.getDescription() + "|" + i.getTime() + "\n");
                    }
                }
                out.flush();
                out.close();
                break;
            }

            if (firstWord.equals("done")) {
                try {
                    int done = Integer.parseInt(defaultTokenizer.nextToken());
                    if (userCommands.size() < 1) {
                        System.out.println(" ☹ OOPS!!! You don't have any tasks in your list yet.");
                    } else if (done > userCommands.size()) {
                        System.out.println(" ☹ OOPS!!! You only have " + userCommands.size() + " tasks in your list.");
                    } else {
                        userCommands.get(done -1).markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  [" + userCommands.get(done-1).getStatusIcon() + "] " + userCommands.get(done-1).getDescription());
                    }
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! Please tell me which task you have completed.");
                }
            } else if (firstWord.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < userCommands.size(); i++) {
                    System.out.println(i + 1 + ". " + userCommands.get(i).toString());

                }
            } else if (firstWord.equals("todo")) {
                try {
                    String[] tempTodo = userCommand.split(" ", 2);
                    Task taskToAdd = new Todo(tempTodo[1]);
                    taskToAdd.setType("T");
                    userCommands.add(taskToAdd);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + taskToAdd.toString());
                    System.out.println("Now you have " + userCommands.size() + " tasks in the list.");
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                }
            } else if (firstWord.equals("deadline")) {
                try {
                    String[] tempDeadline = userCommand.split("/");
                    String[] taskName = tempDeadline[0].split(" ", 2);
                    String[] byDate = tempDeadline[1].split(" ", 3);
                    String fullDate = byDate[1] + " " + byDate[2];
                    Date date = new SimpleDateFormat("yyyyMMdd HHmm").parse(fullDate);
                    Task taskToAdd = new Deadline(taskName[1], fullDate);
                    taskToAdd.setType("D");
                    userCommands.add(taskToAdd);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + taskToAdd.toString() + " (by: " + date + ")");
                    System.out.println("Now you have " + userCommands.size() + " tasks in the list.");
                } catch (Exception e){
                    System.out.println(" ☹ OOPS!!! The description of a deadline cannot be empty.");
                }
            } else if (firstWord.equals("event")) {
                try {
                    String[] tempEvent = userCommand.split("/");
                    String[] taskName = tempEvent[0].split(" ", 2);
                    String[] atTime = tempEvent[1].split(" ", 3);
                    String fullTime = atTime[1] + " " + atTime[2];
                    Date date = new SimpleDateFormat("yyyyMMdd HHmm").parse(fullTime);
                    Task taskToAdd = new Event(taskName[1], fullTime);
                    taskToAdd.setType("E");
                    userCommands.add(taskToAdd);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + taskToAdd.toString() + " (at: " + date + ")");
                    System.out.println("Now you have " + userCommands.size() + " tasks in the list.");
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! The description of an event cannot be empty.");
                }
            } else if (firstWord.equals("delete")) {
                try {
                    int delete = Integer.parseInt(defaultTokenizer.nextToken());
                    System.out.println("Noted. I've removed this task:");
                    Task taskToBeRemoved = userCommands.get(delete-1);
                    System.out.println(taskToBeRemoved.toString());
                    userCommands.remove(delete-1);
                    System.out.println("Now you have " + userCommands.size() + " tasks in the list.");
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! Cannot delete non-existent task!");
                }
            } else if (firstWord.equals("find")) {
                try {
                    String find = defaultTokenizer.nextToken();
                    int temp = 0;
                    for (Task i : userCommands) {
                        if (i.getDescription().contains(find)){
                            System.out.println(temp+1 + ". " + i.toString());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(" ☹ OOPS!!! We ran to an error!");
                }
            }
            else {
                System.out.println(" ☹ OOPS!!! I don't understand.");
            }
        }
    }
}