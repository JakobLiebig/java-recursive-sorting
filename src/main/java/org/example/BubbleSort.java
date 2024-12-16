package org.example;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort <T extends Comparable<T>> implements SortAlgorithm<T> {
    private List<T> recursiveHelper(List<T> x, int i, boolean swapped) {
        if(i == x.size() - 1 && swapped)
            return recursiveHelper(x, 0, false);
        else if(i == x.size() - 1)
            return x;

        T a = x.get(i);
        T b = x.get(i + 1);

        int order = a.compareTo(b);
        if(order > 0) {
            // swap a, b
            x.set(i, b);
            x.set(i + 1, a);
            swapped = true;
        }

        return recursiveHelper(x, i + 1, swapped);
    }

    @Override
    public List<T> sort(List<T> x) {
        if(x.size() <= 1)
            return x;

        List<T> copy = new ArrayList<T>(x);
        return recursiveHelper(copy, 0, true);
    }
}
