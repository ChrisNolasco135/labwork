import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Requirement 2: JUnit test that fails ONLY if any values in an array are less than 20
 */
class ArrayMinimumValueTest {

    @Test
    void testAllValuesGreaterThanOrEqual20() {
        // Test should pass
        int[] values = {20, 25, 30, 100, 50};
        boolean allValid = true;
        for (int val : values) {
            if (val < 20) {
                allValid = false;
                break;
            }
        }
        assertTrue(allValid, "All values should be >= 20");
    }

    @Test
    void testWithValuesLessThan20() {
        // Test should fail
        int[] values = {20, 15, 30, 25};
        boolean allValid = true;
        for (int val : values) {
            if (val < 20) {
                allValid = false;
                break;
            }
        }
        assertTrue(allValid, "All values should be >= 20, but found value(s) less than 20");
    }

    @Test
    void testEdgeCaseWithValueEqual20() {
        // Test should pass
        int[] values = {20, 20, 20};
        boolean allValid = true;
        for (int val : values) {
            if (val < 20) {
                allValid = false;
                break;
            }
        }
        assertTrue(allValid, "All values should be >= 20");
    }

    @Test
    void testEmptyArray() {
        // Test should pass
        int[] values = {};
        boolean allValid = true;
        for (int val : values) {
            if (val < 20) {
                allValid = false;
                break;
            }
        }
        assertTrue(allValid, "Empty array should be considered valid");
    }
}
