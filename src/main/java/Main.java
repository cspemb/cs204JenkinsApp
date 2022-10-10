import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static final Calculator calc = new Calculator();

    private static final String USAGE = "Usage: operation args...";
    private static final String OPS = "Valid Operations:\n" +
            "add a b\n" +
            "subtract a b\n" +
            "multiply a b\n" +
            "divide a b\n" +
            "binary n\n" +
            "fib n\n" +
            "exit\n\n";
    public static void main(String[] args) {

        System.out.println("Welcome to the calculator!\n");
        System.out.println("Enter a command: (-h for help)");

        while (true) {
            mainLoop();
        }
    }

    private static void mainLoop() {
        Scanner scanner = new Scanner(System.in);

        String[] currLine = scanner.nextLine().split(" ");
        switch (currLine[0]) {
            case "add":
            case "subtract":
            case "multiply":
            case "divide":
                final int a = Integer.parseInt(currLine[1]);
                final int b = Integer.parseInt(currLine[2]);
                handleArithmetic(currLine[0], a, b);
                break;

            case "binary":
                final int bin_n = Integer.parseInt(currLine[1]);
                handleBinary(bin_n);
                break;

            case "fib":
                final int fib_n = Integer.parseInt(currLine[1]);
                handleFib(fib_n);
                break;

            case "-h":
                System.out.println(USAGE);
                System.out.println(OPS);
                break;

            case "exit":
                exit(0);

            default:
                System.err.println("Invalid command. Type -h for help or exit to close the program\n");
                break;
        }
    }

    private static void handleArithmetic(String operation, int a, int b) {
        int val = 0;

        switch (operation) {
            case "add":
                val = calc.add(a, b);
                break;
            case "subtract":
                val = calc.subtract(a, b);
                break;
            case "multiply":
                val = calc.multiply(a, b);
                break;
            case "divide":
                val = calc.divide(a, b);
                break;
        }

        System.out.println(val);
    }

    private static void handleBinary(int n) {
        System.out.println(calc.intToBinaryNumber(n));
    }

    private static void handleFib(int n) {
        System.out.println(calc.fibonacciNumberFinder(n));
    }
}
