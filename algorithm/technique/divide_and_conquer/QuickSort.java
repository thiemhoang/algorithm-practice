package com.self.training.algorithm.technique.divide_and_conquer;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int [] {1,3,2,7,38,223,2};
        quicksort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quicksort(int[] a) {
        quicksortRecur(a, 0, a.length - 1);
    }

    public static void quicksortRecur(int[] a, int p, int r) {
        // partition
        if( p < r) {
            int q = partition(a, p, r);
            quicksortRecur(a, p, q - 1);
            quicksortRecur(a, q + 1, r);
        }
    }

    public static int partition(int a[], int p, int r) {
        int x = a[r];
        int i = p -1;

        for (int j = p; j <= r - 1; j++) {
            if (a[j] < x) {
                i += 1;
                swap(a, i, j);
            }
        }
        swap(a, i+ 1, r);
        return i+1;
    }

    private static  void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static  int partition2(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {

            // Nếu phần tử hiện tại nhỏ hơn chốt
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] và arr[high] (hoặc pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}
