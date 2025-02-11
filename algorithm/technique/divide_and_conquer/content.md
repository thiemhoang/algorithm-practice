# Divide and Conquer
- Merge Sort
- Matrix multiplication
- Quick sort
  - QUICKSORT(A,p,r):
      if p < r :
      // Partition the subarray around the pivot, which ends up in A[q]
      q = PARTITION(A,q,r)
      QUICKSORT(A, p, q-1) // recursively sort the low side
      QUICKSORT(A, q+1, r) // recursively sort the high side