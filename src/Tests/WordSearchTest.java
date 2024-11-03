package Tests;

import SimpleSearchEngine.WordSearch;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class WordSearchTest {
    private WordSearch wordSearch;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        wordSearch = new WordSearch();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testFindWordFound() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        wordSearch.findWord("banana", list);
        assertEquals("2", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testFindWordNotFound() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        wordSearch.findWord("orange", list);
        assertEquals("Not found", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testFindWordFirstPosition() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");

        wordSearch.findWord("apple", list);
        assertEquals("1", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testFindWordEmptyList() {
        ArrayList<String> list = new ArrayList<>();

        wordSearch.findWord("apple", list);
        assertEquals("Not found", outputStreamCaptor.toString().trim());
    }
}
