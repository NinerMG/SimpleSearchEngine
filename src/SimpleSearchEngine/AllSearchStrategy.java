package SimpleSearchEngine;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllSearchStrategy implements SearchStrategy{

    @Override
    public Set<Integer> search(String query, Map<String, Set<Integer>> invertedIndex, int totalContacts) {
        Set<Integer> result = new HashSet<>();
        String[] words = query.toLowerCase().split("\\s+");

        boolean firstWord = true;

        for (String word : words) {
            if (invertedIndex.containsKey(word)) {
                if (firstWord) {
                    result.addAll(invertedIndex.get(word));
                    firstWord = false;
                } else {
                    result.retainAll(invertedIndex.get(word));
                }
            } else {
                return new HashSet<>();
            }
        }

        return result;
    }
}
