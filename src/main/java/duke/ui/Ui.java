package duke.ui;

import duke.exception.DukeException;
import duke.task.Task;
import duke.task.TaskList;

import java.util.Scanner;

public class Ui {
    /** Scanner for UI */
    private Scanner scanner;

    /**
     * Constructs Ui class.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads user command.
     *
     * @return User input as string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays output with tab prepended.
     */
    public void printUi(String message){
        System.out.println("\t" + message);
    }

    /**
     * Displays BorzAI logo.
     */
    public void showStartUp() {
        String logo = "  /\\_/\\\n"
                + " /\u25DE   \u25DF\\\n"
                + "( \u25d5   \u25d5 )\n"
                + " \\     /\n"
                + "  \\   /\n"
                + "   \\ /\n"
                + "    \u25CF\n";
        System.out.println(logo + "BorzAI\n");
    }

    /**
     * Displays welcome message.
     */
    public void showWelcome() {
        printUi("When all I do is for you, Kermie \u2665\n\tWhat can I do for you?\n");
    }

    /**
     * Displays loading error when tasks cannot be loaded.
     */
    public void showLoadingError() {
        printUi("Error: Unable to load tasks from file.");
    }

    /**
     * Displays Ui line.
     */
    public void showLine() {
        printUi("__________________________________________________________");
    }

    /**
     * Displays message to acknowledge task added.
     */
    public void showAdded(Task t) {
        printUi("Got it. I've added this task:\n\t  " + t);
    }

    /**
     * Displays message including size of list.
     */
    public void showListSize(TaskList tasks) {
        if (tasks.getSize() == 1) {
            printUi("Now you have " + tasks.getSize() + " task in the list.");
        } else {
            printUi("Now you have " + tasks.getSize() + " tasks in the list.");
        }
    }

    /**
     * Displays all tasks in the list.
     */
    public void showList(TaskList tasks) {
        printUi("Here are the tasks in your list:");
        for (int i = 0; i < tasks.getSize(); i++) {
            Task t = tasks.getTask(i);
            int index = i + 1;
            printUi(index + "." + t);
        }
    }

    /**
     * Displays message to acknowledge task marked.
     */
    public void showMarked(Task t) {
        printUi("Nice! I've marked this task as done:\n\t  " + t);
    }

    /**
     * Displays message to acknowledge task unmarked.
     */
    public void showUnmarked(Task t) {
        printUi("OK, I've marked this task as not done yet:\n\t  " + t);
    }

    /**
     * Displays message to acknowledge task deleted.
     */
    public void showDeleted(Task t) {
        printUi("Noted. I've removed this task:\n\t  " + t);
    }

    /**
     * Displays error message if any error occurs.
     */
    public void showError(String errorMessage) {
        printUi("\u2639 OOPS!!! " + errorMessage);
    }

    /**
     * Displays exit message.
     */
    public void showExit() {
        printUi("Woof (\u256F\u11BA\u2570\u0E51)");
    }

    /**
     * Closes scanner.
     */
    public void closeScanner() {
        scanner.close();
    }
}