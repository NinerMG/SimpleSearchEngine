package SimpleSearchEngine;
import java.util.ArrayList;
import java.util.Arrays;

public class StringOperations {

    public ArrayList<String> stringToArray(String input){
       return new ArrayList<>(Arrays.asList(input.split("\\s+")));
    }
}
