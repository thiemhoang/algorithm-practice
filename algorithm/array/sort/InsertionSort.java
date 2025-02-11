package com.self.training.algorithm.array.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int a[] = new int[] {31,41,59,26,41,58};
        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int key = a[i];

            int j = i -1;
            while(j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }
}
