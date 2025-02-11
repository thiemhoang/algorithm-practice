package com.self.training.algorithm.technique.divide_and_conquer;

import java.util.Arrays;

public class SelectMedianPivot {

    public static void main(String[] args) {
        int[] a = new int [] {1,3,2,7,38,223,2};
        System.out.println(selection(a, 0, a.length - 1, 5));
    }

    public static int selection(int a[], int p, int r, int i) {

        // reduce the size of array to be divisible by 5
        // by moving the minimum to the start of arrays
        while ((r - p + 1) % 5 != 0) {
            for(int j  = p; j <= r; j ++) {
                if(a[p] > a[j]) {
                    swap(a, j, p);
                }
            }
            // If we want the minimum return it
            if(i == 1) {
                return a[p];
            }
            p = p + 1;
            i = i - 1;
        }

        int g = (r - p + 1) / 5;

        // list all groups
        for(int j = p ; j <= p + g - 1; j++) {
            // each group includes a[j + g], a[j + 2g], a[j + 3g], a[j + 4g]
            insertionSort(a, j + g, j + 2 * g, j + 3 * g, j + 4 * g);
        }

        // medians allocate in the index from p + 2g to p + 3g - 1
        // find the pivot(x) by find the median of above array
        int x = selection(a, p + 2 * g, p + 3 * g - 1, (g % 2 == 0) ? (g / 2) : (g/2 + 1));
        int q = partitionAround(a, p, r, x);
        // same as the randomized select algorithm
        int k = q - p + 1;
        if (k == i) {
            return a[q];
        } else if (i < k) {
            return selection(a, p, q - 1, i);
        } else {
            return selection(a, q + 1, r, i - k);
        }
    }

    private static void insertionSort(int[] a, int ... indexes) {
        for(int i = 0 ; i < indexes.length; i ++) {
            for(int j = i + 1; j < indexes.length; j ++) {
                if(a[indexes[i]] < a[indexes[j]]) {
                    swap(a, indexes[i], indexes[j]);
                }
            }
        }
    }

    private static int partitionAround(int[] a, int p, int r, int x) {
        // Dutch National Flag algorithm
        int lo = p; // boundary for elements less than pivot
        int hi = r; // boundary for elements greater than pivot
        int mid = p; // current element being considered

        while(mid <= hi) {
            if(a[mid] < x) {
                swap(a, lo++, mid++);
            } else if(a[mid] == x) {
                mid ++;
            } else {
                swap(a, mid, hi--);
            }
        }

        return lo;
    }

    private static  void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
