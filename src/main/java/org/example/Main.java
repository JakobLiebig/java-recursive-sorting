package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    static void testSort(SortAlgorithm<Integer> sortAlgorithm) {
        List<Integer> a = Arrays.asList(200, 10, 8, 3, 2, 0, 9, 4, 4, 4);
        System.out.println(sortAlgorithm.sort(a).toString());
    }

    public static void main(String[] args) {
        testSort(new BubbleSort<>());
        testSort(new InsertionSort<>());
        testSort(new SelectionSort<>());
        testSort(new MergeSort<>());
        // this implementation of radix sort can only sort non negativ integers
        testSort(new RadixSort());
    }
}