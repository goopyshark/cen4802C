import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciApp {

    // Create the logger
    private static final Logger logger = LoggerFactory.getLogger(FibonacciApp.class);

    /**
     * Calculates the nth term in the Fibonacci sequence using recursion.
     *
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {

        logger.debug("Calculating Fibonacci({})", n);

        if (n < 0) {
            logger.error("Invalid input: {}", n);
            return -1;
        }

        if (n <= 1) {
            logger.info("Base case reached: Fibonacci({}) = {}", n, n);
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        logger.info("Application started.");

        // Run 100 times to generate plenty of log entries
        for (int i = 1; i <= 100; i++) {

            int input = i % 11;

            if (input >= 8) {
                logger.warn("Large Fibonacci input detected: {}", input);
            }

            int result = fibonacci(input);

            logger.info("Run {}: Fibonacci({}) = {}", i, input, result);
        }

        // Generate one ERROR log
        fibonacci(-5);

        logger.info("Application finished.");

        System.out.println("Logging Demo Complete!");
    }
}