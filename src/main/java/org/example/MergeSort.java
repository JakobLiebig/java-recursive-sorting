package org.example;

import java.util.ArrayList;
import java.util.List;

public class MergeSort <T extends Comparable<T>> implements SortAlgorithm<T> {

    private List<T> merge(List<T> a, List<T> b) {
        List<T> result = new ArrayList<>();

        while(!a.isEmpty() && !b.isEmpty()) {
            int order = a.get(0).compareTo(b.get(0));
            if(order > 0) {
                result.add(b.remove(0));
            } else {
                result.add(a.remove(0));
            }
        }

        if(a.isEmpty())
            result.addAll(b);
        if(b.isEmpty())
            result.addAll(a);

        return result;
    }

    @Override
    public List<T> sort(List<T> x) {
        if(x.isEmpty())
            return new ArrayList<>();
        else if(x.size() == 1)
            return x;

        List<T> a = new ArrayList<>(x);
        List<T> b = new ArrayList<>();

        while(b.size() < a.size()) {
            b.add(a.remove(0));
        }

        return merge(
                sort(a),
                sort(b)
        );
    }
}
