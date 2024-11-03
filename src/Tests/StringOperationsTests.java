package Tests;

import SimpleSearchEngine.StringOperations;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringOperationsTests {

    @Test
    public void testStringToArray_WithRegularString() {
        StringOperations stringOperations = new StringOperations();
        String input = "Hello world this is a test";
        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList("Hello", "world", "this", "is", "a", "test"));

        ArrayList<String> actualOutput = stringOperations.stringToArray(input);

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void testStringToArray_WithWhitespaceOnly() {
        StringOperations stringOperations = new StringOperations();
        String input = "     ";
        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList());

        ArrayList<String> actualOutput = stringOperations.stringToArray(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testStringToArray_WithSingleWord() {
        StringOperations stringOperations = new StringOperations();
        String input = "Hello";
        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList("Hello"));

        ArrayList<String> actualOutput = stringOperations.stringToArray(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testStringToArray_WithMultipleSpacesBetweenWords() {
        StringOperations stringOperations = new StringOperations();
        String input = "Hello    world    this";
        ArrayList<String> expectedOutput = new ArrayList<>(Arrays.asList("Hello", "world", "this"));

        ArrayList<String> actualOutput = stringOperations.stringToArray(input);

        assertEquals(expectedOutput, actualOutput);
    }
}
