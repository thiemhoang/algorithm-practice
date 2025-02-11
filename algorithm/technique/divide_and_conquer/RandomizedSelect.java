package com.self.training.algorithm.technique.divide_and_conquer;

public class RandomizedSelect {

    public static void main(String[] args) {
        int[] a = new int [] {1,3,2,7,38,223,2};
        System.out.println(randomizedSelect(a, 5));
    }

    public static int randomizedSelect(int [] a, int i) {
       return randomizedSelect(a, 0, a.length - 1, i );
    }

    public static int randomizedSelect(int [] a, int p, int r, int i) {
        if(p == r) { // base case
            return a[p];
        }
        int q = partition(a, p, r);
        int k = q - p + 1; // the size of lower side
        if(k == i) {
            return a[q];
        } else if (i < k) {
            return randomizedSelect(a, p, q -1, i);
        } else {
            return randomizedSelect(a, q + 1, r, i - k);
        }
    }

    private static int partition(int [] a, int p, int r) {
        int i = p-1;
        int x = a[r]; // pivot

        for(int j = p; j <= r -1 ; j ++) {
            if(a[j] < x) {
                i ++;
                swap(a, i, j);
            }
        }

        swap(a, i +1, r);

        return i +1;
    }

    private static  void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
