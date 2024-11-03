package SimpleSearchEngine;
import java.util.ArrayList;

public class SearchEngine {
    UserInput userInput;
    StringOperations stringOperations;
    WordLists wordLists;
    WordSearch wordSearch;
    public SearchEngine(){
        this.userInput = new UserInput();
        this.stringOperations = new StringOperations();
        this.wordSearch = new WordSearch();
        this.wordLists = new WordLists();
    }
    public void start(){
        performInputOperations();
    }
    private void performInputOperations(){
        String stringLists = userInput.userInput();
        String wordToSearch = userInput.userInput();

        ArrayList<String> stringArrayList = stringOperations.stringToArray(stringLists);
        wordLists.addLists(stringArrayList);

        wordSearch.findWord(wordToSearch, wordLists.getWordList());
    }
}
