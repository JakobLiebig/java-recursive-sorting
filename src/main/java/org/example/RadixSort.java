package org.example;

import java.util.ArrayList;
import java.util.List;

public class RadixSort implements SortAlgorithm<Integer> {

    private List<Integer> concat(List<Integer> smaller, List<List<Integer>> buckets, List<Integer> bigger) {
        List<Integer> result = new ArrayList<>(smaller);

        for(List<Integer> list: buckets)
            result.addAll(list);

        result.addAll(bigger);

        return result;
    }
    
    private int getNumberOfDigits(int n) {
        if(n == 0)
            return 1;

        return (int)(Math.log10(n) + 1);
    }
    
    private int getDigitAd(int i, int index) {
        if(i == 0)
            return 0;

        return (int)(i / Math.pow(10, index)) % 10;
    }

    private List<Integer> recursiveHelper(List<Integer> elements, int digit) {
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();

        ArrayList<List<Integer>> buckets = new ArrayList<>();
        for(int bucket = 0; bucket < 10; bucket++)
            buckets.add(new ArrayList<>());

        for(int element: elements){
            int numberOfDigits = getNumberOfDigits(element);

            if(numberOfDigits < digit)
                smaller.add(element);
            else if(numberOfDigits > digit)
                bigger.add(element);
            else {
                int bucketIndex = getDigitAd(element, digit - 1);
                buckets.get(bucketIndex).add(element);
            }
        }

        elements = concat(smaller, buckets, bigger);

        if(smaller.size() == elements.size())
            return elements;
        else
            return recursiveHelper(elements, digit + 1);
    }
    @Override
    public List<Integer> sort(List<Integer> x) {
        List<Integer> copy = new ArrayList<>(x);
        return recursiveHelper(copy, 1);
    }
}
