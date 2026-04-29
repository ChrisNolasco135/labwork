import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Requirement 3
 */
class StringCharacterComparisonTest {

    private boolean stringsContainSameCharacters(String strOne, String strTwo) {
        if (strOne == null || strTwo == null) {
            return strOne == strTwo;
        }
        
        char[] chars1 = strOne.toLowerCase().toCharArray();
        char[] chars2 = strTwo.toLowerCase().toCharArray();
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }

    @Test
    void testStringsWithSameCharacters() {
        // Test should pass
        String strOne = "listen";
        String strTwo = "silent";
        
        assertTrue(stringsContainSameCharacters(strOne, strTwo), 
            "Strings should contain the same characters");
    }

    @Test
    void testStringsWithDifferentCharacters() {
        // Test should pass
        String strOne = "hello";
        String strTwo = "world";
        
        assertFalse(stringsContainSameCharacters(strOne, strTwo), 
            "Strings should not contain the same characters");
    }

    @Test
    void testIdenticalStrings() {
        // Test should pass
        String strOne = "test";
        String strTwo = "test";
        
        assertTrue(stringsContainSameCharacters(strOne, strTwo), 
            "Identical strings should contain the same characters");
    }

    @Test
    void testCaseInsensitive() {
        // Test should pass
        String strOne = "HELLO";
        String strTwo = "hello";
        
        assertTrue(stringsContainSameCharacters(strOne, strTwo), 
            "Strings should contain the same characters regardless of case");
    }

    @Test
    void testEmptyStrings() {
        // Test should pass
        String strOne = "";
        String strTwo = "";
        
        assertTrue(stringsContainSameCharacters(strOne, strTwo), 
            "Empty strings should be considered as having the same characters");
    }

    @Test
    void testOneEmptyString() {
        // Test should pass
        String strOne = "";
        String strTwo = "hello";
        
        assertFalse(stringsContainSameCharacters(strOne, strTwo), 
            "Empty string and non-empty string should not have same characters");
    }

    @Test
    void testWithSpecialCharacters() {
        // Test should pass
        String strOne = "a!b@c#";
        String strTwo = "#c@b!a";
        
        assertTrue(stringsContainSameCharacters(strOne, strTwo), 
            "Strings with special characters should match when characters are same");
    }

    @Test
    void testWithDuplicateCharacters() {
        // Test should pass
        String strOne = "aabbcc";
        String strTwo = "abccba";
        
        assertTrue(stringsContainSameCharacters(strOne, strTwo), 
            "Strings with duplicate characters should match");
    }
}
