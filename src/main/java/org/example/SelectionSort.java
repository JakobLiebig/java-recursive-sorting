package org.example;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort <T extends Comparable<T>> implements SortAlgorithm<T> {
    private List<T> recursiveHelper(List<T> sorted, List<T> unsorted, int i, T smallest) {
        if(unsorted.isEmpty())
            return sorted;

        if(i == unsorted.size()) {
            sorted.add(smallest);
            unsorted.remove(smallest);

            return recursiveHelper(sorted, unsorted, 0, null);
        }

        T current = unsorted.get(i);
        if (smallest == null || smallest.compareTo(current) > 0)
            smallest = current;

        return recursiveHelper(sorted, unsorted, i + 1, smallest);
    }

    @Override
    public List<T> sort(List<T> x) {
        List<T> unsorted = new ArrayList<>(x);
        List<T> sorted = new ArrayList<>();

        return recursiveHelper(sorted, unsorted, 0, null);
    }
}
