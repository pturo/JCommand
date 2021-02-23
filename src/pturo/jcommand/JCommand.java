package pturo.jcommand;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * JCommand - Application runs tasks by calling commands. For educational purposes.
 * It uses JDK 15 features like text blocks and switch statements.
 * @author Paweł Turoń
 * @version 1.1
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
            case "-exit", "-e" -> exit();
            case "-genfuntxt", "-gft" -> generateFunnyText();
            case "-help", "-h" -> help();
            case "-open", "-o" -> open();
            case "--version" -> version();
            default -> System.out.println("Invalid command! Try agin!");
        }
        runJCommand();
    }

    /**
     * version method gives current version of program.
     * @throws IOException when given invalid command.
     */
    private static void version() throws IOException {
        System.out.println("JCommand version: 1.1");
        runJCommand();
    }

    /**
     * help method displays list of available command and its explanation.
     * @throws IOException when given invalid command.
     */
    private static void help() throws IOException {
        String help = """
        List of available commands:
        ------------------------------------------------------------------------------
        |     Command     |                        Explanation                       |
        ------------------------------------------------------------------------------
        |    -exit, -e    |  Ends program.                                           |
        | -genfuntxt -gft |  Generate a funny text (only in Polish language)         |
        |    -help, -h    |  Displays help.                                          |
        |    -open, -o    |  Opens text file. You need to give a valid path to file. |
        |    --version    |  Displays version.                                       |
        ------------------------------------------------------------------------------
        """;
        System.out.println(help);
        runJCommand();
    }

    /**
     * exit method ends program.
     */
    private static void exit() {
        System.out.println("Thanks for using JCommand! ByeBye!");
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
     * A simple funny text generator.
     */
    private static void generateFunnyText() throws IOException {
        String [] s1 = {"Makłowicz", "Pralka", "Ciastko", "Muszla klozetowa", "Worek na śmieci", "Joker"};
        String [] s2 = {"znajdzie", "zje", "przepuści", "umyje", "pokroi", "zamrozi", "wyczyści", "zniszczy"};
        String [] s3 = {"pomidor", "łyżkę", "statek", "masło", "Joannę Krupę", "boazerię", "płytę winylową"};
        String [] s4 = {"a"};
        String [] s5 = {"ptak", "Magda Gessler", "maszynista", "zdobywca gwiazdek Michelin", "przepychacz"};
        String [] s6 = {"rozpruje", "wyniesie", "schowa", "odeśle", "przytarga", "ugotuje", "sprzeda"};
        String [] s7 = {"balon", "skórę", "mydło", "Twojego sąsiada", "Twoją dziewczynę", "złomowisko"};
        String [] s8 = {"do piachu.", "na straty.", "do wojska.", "do rowu.", "do domu.", "na księżyc."};

        Random r = new Random();

        int i1 = r.nextInt(s1.length);
        int i2 = r.nextInt(s2.length);
        int i3 = r.nextInt(s3.length);
        int i4 = r.nextInt(s4.length);
        int i5 = r.nextInt(s5.length);
        int i6 = r.nextInt(s6.length);
        int i7 = r.nextInt(s7.length);
        int i8 = r.nextInt(s8.length);

        String txt = s1[i1] + " " + s2[i2] + " " + s3[i3] + ", "
                + s4[i4] +  " " + s5[i5] + " " + s6[i6] + " " + s7[i7] + " " + s8[i8];
        System.out.println(txt);
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
