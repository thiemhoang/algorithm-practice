package com.self.training.algorithm.array;

import java.util.Arrays;
import java.util.Collections;

public class KthSmallestOrLargest {

    public static void main(String[] args) {
//        System.out.println(solutionSort(new Integer[]{3, 2, 1, 5, 6, 4}, 2));
//        System.out.println(solutionSort(new Integer[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        quickSelect(new int[]{3, 2, 1, 5, 6, 4}, 2);
//        System.out.println(quickSelect(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));



        quickSort(new int[]{3, 2, 1, 5, 6, 4}, 0, 5);
        quickSort(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 0, 8);




//        partition(new int[]{3, 2, 1, 5, 6, 4}, 0 , 5);

    }

    private static int solutionSort(Integer[] A, int k) {
        Arrays.sort(A,  Collections.reverseOrder());
        return A[k-1];
    }

    /**
     * Idea
     * function QuickSelect(A, k) {
     *      if |A| = 1  {
     *          return A[0]
     *      } else {
     *          A1,A2 <- Partition(A)
     *          if k < |A1| {
     *               return QuickSelect(A1, k)
     *          } else {
     *              return QuickSelect(A2, k - |A1|)
     *          }
     *      }
     * }
     *
     * function Partition(A) {
     *     Pick a random pivot value in A
     *     A1 <- all values in A which are < pivot
     *     A2 <- all values in A which are >= pivot
     *     return A1, A2
     * }
     *
     */

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int quickSelect(int A [], int k) {
        return quickSelect(A, 0, A.length-1, k-1);
    }

    private static int quickSelect(int A [], int l, int r, int k) {
        if(l == r) {
            return A[l];
        } else {

            int mid = partition(A, l, r);
            int lLength = mid - l;

            if(k < lLength) {
                return quickSelect(A, l, mid, k);
            } else {
                return quickSelect(A, mid+1, r, k - lLength);
            }
        }
    }

    private static int partition(int [] A, int l, int r) {
        int pivot = A[r];
//        System.out.println("before" + Arrays.toString(A));
        // i track the latest larger than or equal the pivot

        int i = l; int j = l;

        while(j < r) {
            if(A[j] >= pivot && A[i] < pivot) {
                i = j;
            }
            if(A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
            j++;
        }

        swap(A, i, r);

//        System.out.println("after" + Arrays.toString(A));
        System.out.println(i + "l="+ l +"r=" +r);

        return i;

    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }




    /**
     *
     * @param A array
     * @param k
     * @return the kth largest
     * Thinking about the quick sort algorithm
     */
    /**
     *
     * pick pivot last element
     * Move element > pivot to the right
     * Move element < pivot to the left
     *
     */
//    private static int solutionQuickSelect(Integer[] A, int k) {
//
//    }
}
