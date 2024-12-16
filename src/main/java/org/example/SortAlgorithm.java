package org.example;

import java.util.List;

public interface SortAlgorithm <T extends Comparable<T>> {
    public List<T> sort(List<T> x);
}
