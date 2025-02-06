package SimpleSearchEngine;

import java.util.Map;
import java.util.Set;

public interface SearchStrategy {
    Set<Integer> search(String query, Map<String, Set<Integer>> invertedIndex, int totalContacts);
}
