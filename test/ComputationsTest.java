import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import Week15.Computations;

/**
 * Requirement 5
 */
class ComputationsTest {
    
    @Test
    void testFibonacciBaseCase0() {
        assertEquals(0, Computations.fibonacci(0), "fibonacci(0) should be 0");
    }

    @Test
    void testFibonacciBaseCase1() {
        assertEquals(1, Computations.fibonacci(1), "fibonacci(1) should be 1");
    }

    @Test
    void testFibonacciSmallValue() {
        assertEquals(1, Computations.fibonacci(2), "fibonacci(2) should be 1");
        assertEquals(2, Computations.fibonacci(3), "fibonacci(3) should be 2");
        assertEquals(3, Computations.fibonacci(4), "fibonacci(4) should be 3");
        assertEquals(5, Computations.fibonacci(5), "fibonacci(5) should be 5");
    }

    @Test
    void testFibonacciLargerValue() {
        assertEquals(55, Computations.fibonacci(10), "fibonacci(10) should be 55");
        assertEquals(89, Computations.fibonacci(11), "fibonacci(11) should be 89");
    }

    @Test
    void testFibonacciNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Computations.fibonacci(-1);
        }, "fibonacci(-1) should throw IllegalArgumentException");

        assertThrows(IllegalArgumentException.class, () -> {
            Computations.fibonacci(-100);
        }, "fibonacci(-100) should throw IllegalArgumentException");
    }

    // isPrime Tests 

    @Test
    void testIsPrimeBaseCase() {
        assertFalse(Computations.isPrime(0), "0 is not prime");
        assertFalse(Computations.isPrime(1), "1 is not prime");
    }

    @Test
    void testIsPrimeNegativeNumbers() {
        assertFalse(Computations.isPrime(-1), "Negative numbers are not prime");
        assertFalse(Computations.isPrime(-10), "Negative numbers are not prime");
    }

    @Test
    void testIsPrimeSmallPrimes() {
        assertTrue(Computations.isPrime(2), "2 is prime");
        assertTrue(Computations.isPrime(3), "3 is prime");
        assertTrue(Computations.isPrime(5), "5 is prime");
        assertTrue(Computations.isPrime(7), "7 is prime");
        assertTrue(Computations.isPrime(11), "11 is prime");
        assertTrue(Computations.isPrime(13), "13 is prime");
    }

    @Test
    void testIsPrimeSmallNonPrimes() {
        assertFalse(Computations.isPrime(4), "4 is not prime");
        assertFalse(Computations.isPrime(6), "6 is not prime");
        assertFalse(Computations.isPrime(8), "8 is not prime");
        assertFalse(Computations.isPrime(9), "9 is not prime");
        assertFalse(Computations.isPrime(10), "10 is not prime");
    }

    @Test
    void testIsPrimeLargerPrimes() {
        assertTrue(Computations.isPrime(17), "17 is prime");
        assertTrue(Computations.isPrime(19), "19 is prime");
        assertTrue(Computations.isPrime(23), "23 is prime");
        assertTrue(Computations.isPrime(29), "29 is prime");
        assertTrue(Computations.isPrime(97), "97 is prime");
    }

    @Test
    void testIsPrimeLargerNonPrimes() {
        assertFalse(Computations.isPrime(24), "24 is not prime");
        assertFalse(Computations.isPrime(25), "25 is not prime");
        assertFalse(Computations.isPrime(100), "100 is not prime");
        assertFalse(Computations.isPrime(121), "121 = 11*11 is not prime");
    }

    @Test
    void testIsPrimePerfectSquares() {
        assertFalse(Computations.isPrime(16), "16 = 4*4 is not prime");
        assertFalse(Computations.isPrime(36), "36 = 6*6 is not prime");
        assertFalse(Computations.isPrime(49), "49 = 7*7 is not prime");
    }

    // isEven Tests

    @Test
    void testIsEvenZero() {
        assertTrue(Computations.isEven(0), "0 is even");
    }

    @Test
    void testIsEvenPositiveNumbers() {
        assertTrue(Computations.isEven(2), "2 is even");
        assertTrue(Computations.isEven(4), "4 is even");
        assertTrue(Computations.isEven(100), "100 is even");
        assertTrue(Computations.isEven(1000), "1000 is even");
    }

    @Test
    void testIsEvenNegativeNumbers() {
        assertTrue(Computations.isEven(-2), "-2 is even");
        assertTrue(Computations.isEven(-100), "-100 is even");
    }

    @Test
    void testIsEvenOddPositiveNumbers() {
        assertFalse(Computations.isEven(1), "1 is not even");
        assertFalse(Computations.isEven(3), "3 is not even");
        assertFalse(Computations.isEven(99), "99 is not even");
    }

    @Test
    void testIsEvenOddNegativeNumbers() {
        assertFalse(Computations.isEven(-1), "-1 is not even");
        assertFalse(Computations.isEven(-99), "-99 is not even");
    }

    // isOdd Tests

    @Test
    void testIsOddZero() {
        assertFalse(Computations.isOdd(0), "0 is not odd");
    }

    @Test
    void testIsOddPositiveNumbers() {
        assertTrue(Computations.isOdd(1), "1 is odd");
        assertTrue(Computations.isOdd(3), "3 is odd");
        assertTrue(Computations.isOdd(99), "99 is odd");
        assertTrue(Computations.isOdd(1001), "1001 is odd");
    }

    @Test
    void testIsOddNegativeNumbers() {
        assertTrue(Computations.isOdd(-1), "-1 is odd");
        assertTrue(Computations.isOdd(-99), "-99 is odd");
    }

    @Test
    void testIsOddEvenNumbers() {
        assertFalse(Computations.isOdd(2), "2 is not odd");
        assertFalse(Computations.isOdd(100), "100 is not odd");
    }

    // Temperature Conversion Tests

    @Test
    void testToCelsiusFreezingPoint() {
        assertEquals(0.0, Computations.toCelsius(32), 0.01, 
            "32°F should equal 0°C");
    }

    @Test
    void testToCelsiusBoilingPoint() {
        assertEquals(100.0, Computations.toCelsius(212), 0.01, 
            "212°F should equal 100°C");
    }

    @Test
    void testToCelsiusRoomTemperature() {
        assertEquals(20.0, Computations.toCelsius(68), 0.01, 
            "68°F should equal approximately 20°C");
    }

    @Test
    void testToCelsiusNegativeFahrenheit() {
        assertEquals(-40.0, Computations.toCelsius(-40), 0.01, 
            "-40°F should equal -40°C");
    }

    @Test
    void testToCelsiusZeroFahrenheit() {
        assertEquals(-17.777, Computations.toCelsius(0), 0.01, 
            "0°F should equal approximately -17.78°C");
    }

    @Test
    void testToFahrenheitFreezingPoint() {
        assertEquals(32.0, Computations.toFahrenheit(0), 0.01, 
            "0°C should equal 32°F");
    }

    @Test
    void testToFahrenheitBoilingPoint() {
        assertEquals(212.0, Computations.toFahrenheit(100), 0.01, 
            "100°C should equal 212°F");
    }

    @Test
    void testToFahrenheitRoomTemperature() {
        assertEquals(68.0, Computations.toFahrenheit(20), 0.01, 
            "20°C should equal 68°F");
    }

    @Test
    void testToFahrenheitNegativeCelsius() {
        assertEquals(-40.0, Computations.toFahrenheit(-40), 0.01, 
            "-40°C should equal -40°F");
    }

    @Test
    void testToFahrenheitNegativeCelsius2() {
        assertEquals(0.0, Computations.toFahrenheit(-17.777), 0.01, 
            "Approximately -17.78°C should equal 0°F");
    }

    @Test
    void testTemperatureConversionRoundTrip() {
        double original = 25.0;
        double fahrenheit = Computations.toFahrenheit(original);
        double backToCelsius = Computations.toCelsius(fahrenheit);
        assertEquals(original, backToCelsius, 0.01, 
            "Converting Celsius to Fahrenheit and back should be consistent");
    }
}
