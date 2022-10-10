import java.lang.reflect.InvocationTargetException;

public class Main {
    private static final Calculator calc = new Calculator();

    private static final String USAGE = "Usage: operation args...";
    private static final String OPS = "Valid Operations:\n" +
            "add a b\n" +
            "subtract a b\n" +
            "multiply a b\n" +
            "divide a b\n" +
            "binary n\n" +
            "fib n\n\n";
    public static void main(String[] args) {
        switch (args[1]) {
            case "add":
            case "subtract":
            case "multiply":
            case "divide":
                final int a = Integer.parseInt(args[2]);
                final int b = Integer.parseInt(args[3]);
                handleArithmetic(args[1], a, b);
                break;

            case "binary":
                final int bin_n = Integer.parseInt(args[2]);
                handleBinary(bin_n);
                break;

            case "fib":
                final int fib_n = Integer.parseInt(args[2]);
                handleFib(fib_n);
                break;

            default:
                System.err.println(USAGE);
                System.err.println(OPS);
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
