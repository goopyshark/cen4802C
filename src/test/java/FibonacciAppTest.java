import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciAppTest {

    @Test
    void testFibonacci0() {
        assertEquals(0, FibonacciApp.fibonacci(0));
    }

    @Test
    void testFibonacci1() {
        assertEquals(1, FibonacciApp.fibonacci(1));
    }

    @Test
    void testFibonacci5() {
        assertEquals(5, FibonacciApp.fibonacci(5));
    }

    @Test
    void testFibonacci10() {
        assertEquals(55, FibonacciApp.fibonacci(10));
    }

    @Test
    void testFibonacci12() {
        assertEquals(144, FibonacciApp.fibonacci(12));
    }
}