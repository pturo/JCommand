package pturo.jcommand;

import java.io.*;
import java.util.Scanner;

/**
 * JCommand - Application runs tasks by calling commands. For educational purposes. It uses JDK 12 & 13 features like
 * text blocks and switch statements.
 * @author Paweł Turoń
 * @version 1.0
 */

public class JCommand {

    /**
     * runJCommand is a main method which holds whole program.
     * @throws IOException
     */
    private static void runJCommand() throws IOException {
        String welcome = """
        Welcome in JCommand! If you need help, write -help command. Remember to not input spaces when
        you typing commands!
        Enjoy!
        """;
        System.out.println(welcome);
        Scanner inputCommand = new Scanner(System.in);
        System.out.print("> ");
        String choice = inputCommand.nextLine();
        switch (choice){
            case "-exit" -> exit();
            case "-help" -> help();
            case "-open" -> open();
            case "--version" -> version();
            default -> throw new IOException("Invalid command! Try again!");
        }
    }

    /**
     * version method gives current version of program.
     * @throws IOException when given invalid command.
     */
    private static void version() throws IOException {
        System.out.println("JCommand version: 1.0");
        runJCommand();
    }

    /**
     * help method displays list of available command and its explanation.
     * @throws IOException when given invalid command.
     */
    private static void help() throws IOException {
        String help = """
        List of available commands:
        ------------------------------------------------------------------------
        |  Command  |                      Explanation                         |
        ------------------------------------------------------------------------
        |   -exit   |  Ends program.                                           |
        |   -help   |  Displays help.                                          |
        |   -open   |  Opens text file. You need to give a valid path to file. |
        | --version |  Displays version.                                       |
        ------------------------------------------------------------------------
        """;
        System.out.println(help);
        runJCommand();
    }

    /**
     * exit method ends program.
     */
    private static void exit() {
        System.exit(0);
    }

    /**
     * Text file opener.
     */
    private static void open() throws IOException {
        System.out.print("Give a path to text file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File textFile = new File(path);
        Scanner reader = new Scanner(textFile);
        int lines = 1;
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            System.out.println(line);
            lines++;
        }
        System.out.println();
        runJCommand();
    }

    /**
     * App launcher
     * @param args - arguments of main() method.
     * @throws IOException when given invalid command during using the program.
     */
    public static void main(String[] args) throws IOException {
        runJCommand();
    }
}
