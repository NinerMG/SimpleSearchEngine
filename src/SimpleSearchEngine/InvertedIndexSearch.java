package SimpleSearchEngine;

import java.util.*;

public class InvertedIndexSearch {

    public  Map<String, Set<Integer>> buildInvertedIndex(ArrayList<String> lines) {
        Map<String, Set<Integer>> invertedIndex = new HashMap<>();

        for(int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i).toLowerCase().split("\\s+");
            for (String word : words){
                invertedIndex.computeIfAbsent(word, k -> new HashSet<>()).add(i);
            }
        }
        return invertedIndex;
    }

    public  Set<Integer> search(String query, Map<String, Set<Integer>> invertedIndex){
        return invertedIndex.getOrDefault(query.toLowerCase(), Collections.emptySet());
    }

}
