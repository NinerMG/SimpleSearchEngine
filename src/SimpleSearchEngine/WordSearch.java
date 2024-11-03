package SimpleSearchEngine;
import java.util.ArrayList;

public class WordSearch {

    public void findWord(String word, ArrayList<String> lists){
        if (lists.contains(word)){
            System.out.println(lists.indexOf(word) + 1);
        } else {
            System.out.println("Not found");
        }
    }
}
