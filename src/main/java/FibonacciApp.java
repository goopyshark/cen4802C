import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciApp {

    // Creates the logger for the application.
    private static final Logger logger =
            LoggerFactory.getLogger(FibonacciApp.class);

    /**
     * Calculates the nth Fibonacci number using recursion.
     *
     * @param n the position in the Fibonacci sequence
     * @return the Fibonacci number at position n, or -1 for invalid input
     */
    public static long fibonacci(int n) {

        if (n < 0) {
            logger.error("Invalid Fibonacci input: {}", n);
            return -1;
        }

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        logger.info("FibonacciApp profiling session started.");

        long applicationStartTime = System.currentTimeMillis();

        /*
         * Fibonacci(40) creates a noticeable CPU workload because
         * the recursive method recalculates many of the same values.
         *
         * Running it repeatedly keeps the application active long
         * enough for VisualVM or another profiler to collect data.
         */
        for (int iteration = 1; iteration <= 100; iteration++) {

            int input = 40;

            long calculationStartTime = System.nanoTime();

            long result = fibonacci(input);

            long calculationEndTime = System.nanoTime();

            double executionTimeMilliseconds =
                    (calculationEndTime - calculationStartTime) / 1_000_000.0;

            logger.info(
                    "Iteration {}: Fibonacci({}) = {} | Execution time: {} ms",
                    iteration,
                    input,
                    result,
                    String.format("%.3f", executionTimeMilliseconds)
            );

            System.out.printf(
                    "Iteration %d: Fibonacci(%d) = %d | Execution time: %.3f ms%n",
                    iteration,
                    input,
                    result,
                    executionTimeMilliseconds
            );

            /*
             * A short pause gives time to view the graphs without
             * making sleeping the application's primary activity.
             */
            try {
                Thread.sleep(200);
            } catch (InterruptedException exception) {
                logger.error("The profiling workload was interrupted.", exception);
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Demonstrates invalid-input logging.
        fibonacci(-5);

        long applicationEndTime = System.currentTimeMillis();
        long totalExecutionTime =
                applicationEndTime - applicationStartTime;

        logger.info(
                "FibonacciApp profiling session finished. Total time: {} ms",
                totalExecutionTime
        );

        System.out.println();
        System.out.println("Profiling workload completed.");
        System.out.println(
                "Total application time: " + totalExecutionTime + " milliseconds"
        );
    }
}