package SimpleSearchEngine;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoneSearchStrategy implements SearchStrategy{
    @Override
    public Set<Integer> search(String query, Map<String, Set<Integer>> invertedIndex, int totalContacts) {
        Set<Integer> allIndexes = new HashSet<>();
        for (int i = 0; i < totalContacts; i++) {
            allIndexes.add(i);
        }

        String[] words = query.toLowerCase().split("\\s+");

        for (String word : words) {
            if (invertedIndex.containsKey(word)) {
                allIndexes.removeAll(invertedIndex.get(word));
            }
        }

        return allIndexes;
    }
}
