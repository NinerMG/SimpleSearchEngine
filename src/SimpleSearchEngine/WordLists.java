package SimpleSearchEngine;
import java.util.ArrayList;

public class WordLists {


    private ArrayList<String> wordList;

    public WordLists(){
        wordList = new ArrayList<>();
    }

    public void addElement(String element){
        wordList.add(element);
    }

    public void addLists(ArrayList<String> list){
        wordList.addAll(list);
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }
    public int getIndex(String element){
        return wordList.indexOf(element);
    }

    public int size(){
        return wordList.size();
    }

    public void printAll(){
        for (String element : wordList){
            System.out.println(element);
        }
    }
}
