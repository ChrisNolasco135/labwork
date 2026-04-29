import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Requirement 4
 * 
 * ANSWER: Each test method is independent. If one test
 * fails, the others will still execute. Each @Test method runs in its own
 * instance, and failure in one doesn't prevent others from running.
 */
class TestExecutionAfterFailureTest {

    static int executionCount = 0;

    @Test
    void testOne_FailingTest() {
        executionCount++;
        System.out.println("Test One executed (failure expected) - Execution count: " + executionCount);
        
        // This assertion will fail
        assertEquals(5, 10, "This test INTENTIONALLY fails - test 2 and 3 should still run");
    }

    @Test
    void testTwo_PassingTest() {
        executionCount++;
        System.out.println("Test Two executed - Execution count: " + executionCount);
        
        // This test passes
        assertEquals(5, 5, "This test passes");
    }

    @Test
    void testThree_PassingTest() {
        executionCount++;
        System.out.println("Test Three executed - Execution count: " + executionCount);
        
        // This test passes
        assertTrue(true, "This test passes");
    }

    @Test
    void testFour_VerifyAllExecuted() {
        System.out.println("\nConclusion: If you see all three previous tests in the output,");
        System.out.println("then the answer is YES - all test methods execute even if one fails.");
    }
}
