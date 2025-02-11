package com.self.training.algorithm.technique.divide_and_conquer;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int [] {1,3,2,7,38,223,2};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int [] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int a[], int p, int r) {
        if(p >= r) {
            return;
        }

        int q = (p +r) / 2;
        sort(a, p, q);
        sort(a, q + 1, r);

        merge2(a, p, q, r);
    }

     static void merge(int [] a, int p, int q, int r) {
        // copy array
         int [] L = Arrays.copyOfRange(a, p, q + 1 );
         int [] R = Arrays.copyOfRange(a, q + 1, r + 1);

         int i = 0, // left array index
                 j = 0, // right array index
                 k = p; // current position to fill
         while( i < L.length && j < R.length) {
             if(L[i] <= R[j]) {
                 a[k] = L[i];
                 i++;
             } else {
                a[k] = R[j];
                j++;
             }
             k++;
         }
         while(i < L.length) {
             a[k++] = L[i++];
         }
         while(j < R.length) {
             a[k++] = R[j++];
         }
     }

     static void merge2(int a[], int p, int q, int r) {
         int i = p, // left array index
                 j = q+1, // right array index
                 k = p; // current position to fill
         while(i <= q && j <= r) {
             if(a[i] <= a[j]) {
                 i++;
             } else {
                 // shift element
                 int value  = a[j];
                 int index = j;
                 while(index != i) {
                     a[index] = a[index - 1];
                     index --;
                 }
                 a[i] = value;
                 i++;
                 j++;
                 q++;
             }
         }
     }
}
