package SimpleSearchEngine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    private final String filePath = "resources/dataToSearch.txt";

    public ArrayList<String> readLinesFromFile(int numberOfLines){
        try{
            List<String> lines = Files.lines(Path.of(filePath))
                    .limit(numberOfLines)
                    .collect(Collectors.toList());
           return new ArrayList<>(lines);
        } catch (IOException e){
            System.err.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
