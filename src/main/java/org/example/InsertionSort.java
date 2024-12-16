package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertionSort <T extends Comparable<T>> implements SortAlgorithm<T> {

    private List<T> recursiveHelper(LinkedList<T> sorted, LinkedList<T> unsorted, int i, T x) {
        if(unsorted.isEmpty() && x == null)
            return sorted;
        else if(x == null)
            x = unsorted.remove(0);

        if(i == sorted.size()) {
            sorted.add(x);
            return recursiveHelper(sorted, unsorted, 0, null);
        }

        int order = x.compareTo(sorted.get(i));
        if(order < 0) {
            sorted.add(i, x);
            return recursiveHelper(sorted, unsorted, 0, null);
        }

        return recursiveHelper(sorted, unsorted, i + 1, x);
    }

    @Override
    public List<T> sort(List<T> x) {
        LinkedList<T> unsorted = new LinkedList<>(x);
        LinkedList<T> sorted = new LinkedList<>();

        return recursiveHelper(sorted, unsorted, 0, null);
    }
}
