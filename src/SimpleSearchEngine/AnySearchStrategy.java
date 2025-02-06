package SimpleSearchEngine;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnySearchStrategy implements SearchStrategy{
    @Override
    public Set<Integer> search(String query, Map<String, Set<Integer>> invertedIndex, int totalContacts) {
        Set<Integer> result = new HashSet<>();
        String[] words = query.toLowerCase().split("\\s+");

        for (String word : words) {
            if (invertedIndex.containsKey(word)) {
                result.addAll(invertedIndex.get(word));
            }
        }

        return result;
    }
}
