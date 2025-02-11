Because many programs use it as an intermediate step, sorting is a fundamental operation in computer science. As a result, you have a large number of good sorting algorithms at your disposal. Which algorithm is best for a given application depends on - among other factors - the number of items to be sorted, the extent to which the items are already somewhat sorted, possible restrictions on the item values, the architecture of the computer, and the kind of storage devices to be used: main memory, disk, or even archaically - tapes

- A data structure is away to store and organize data in order to facilitate access and modifications. Using the appropriate data structure or structures is an important part of algorithm design. No single data structure works well for all purpose, and so you should know the strengths and limitations of several of them

- You might someday encounter a problem for which you cannot readily find a published algorithm. This book will teach you techniques of algorithm design and analysis so that you can develop algorithms on your own, show that they give the correct answer, and analyze their efficiency. 

- Most of this book is about efficient algorithms. Our usual measure of efficiency is spread: There are some problems, however, for which we know of no algorithm that runs a reasonable amount of time. 
- NP-complete - Fist, although no efficient algorithm for an NP-complete problem has ever been found, nobody has ever proven that an efficient algorithm for one cannot exist. Second the set of NP-complete problems has the remarkable property that if an efficient algorithm exists for any one of them, then efficient algorithms exist for all of them

- This chapter will familiarize you with the framework we'll use throughout the book to think about the design and analysis of algorithms.


- We start with insertion sort, which is and efficient algorithm for sorting a small number of elements. Insertion sort works the way you might sort a hand of playing cards. Start with an empty left hand and the cards in a pile on the table. Pick up the fist card in the pile and hold it with your left hand. Then, with your right hand, remove one card at a time from the pile and insert it into the correct position in your left hand. You can find the correct position for a card by comparing it with each of the cards already in your left hand, starting at the right and moving left. As soon as you see a card in your left hand whose value is less than or equal to the card you're holding in your right hand, insert the card that you're holding in your right hand just to the right of this card in your left hand. If all the cards in your left hand have values greater than the card in you right hand, then place this card as the leftmost card in your left hand.
 
- Initialization: We start by showing that the loop invariant holds before the first loop iteration, when i = 2. The sub array A[1:i-1] consists of just the single element A[1] which is in fact that original element in A[1]. Moreover, this subarray is sorted (after all, how could a subarray with just one value not be sorted?), which shows that the loop invariant holds prior to the first iteration of the loop.

- Maintenance: Next, we tackle the second property: Showing that each iteration maintains the loop invariant. Informally, the body of the for loop works by moving the values in A[i-1], A[i-2], A[i-3], and so on by one position to the right until it finds the proper position for A[i], at which point it inserts the value of A[i]. The subarray A[1:i] then consists of the elements originally, but in sorted order. Incrementing i for the next iteration of the for loop then preserves the loop invariant
A more formal treatment of the second property would require us to state and show a loop invariant for the while loop. Let's not get bogged down in such formalism just yet. Instead, we'll rely on our informal analysis to show that the second property holds for the outer loop

- Termination: Finally, we examine loop termination. The loop variable i starts at 2 and increases by 1 in each iteration. Once i's value exceeds n in line 1, the loop terminates. That is, the loop terminates once i equals n + 1. Substituting n +1 for i in the wording of the loop invariant yields that the subarray A[1:n] consist of the elements originally in A[1:n], but in sored order. Hence the algorithm is correct

Analyzing algorithms

Analyzing an algorithm has come to mean predicting the resources that the algorithm requires. You might consider resources such as memory, communication bandwidth, or energy consumption. Most often, however, you'll want to measure computational time. If you analyze several candidate algorithms for a problem, you can identify the most efficient one

Instead of timing a run, or even several runs, of insertion sort, we can determine how long it takes by analyzing the algorithm itself. We'll examine how many times it executes each line of pseudocode and how long each line of pseudocode takes to run. We'll first come up with a precise but complicated formula for the running time. Then we'll distill the important par of the formula using a convenient notation that can help us compare the running times of different algorithms for the same problem.

The best notion of input size depends on the problem being studied. The most natural measure is the number of items in the input. For many other problems, such as multiplying two integers, the best measure of input size is the total number of bits needed to represent the input in ordinary binary notation. Sometimes it is more appropriate to describe the size of the input with more than just one number. For example, if the input to an algorithm is a graph, we usually characterize the input size by both the number of vertices and the number of edges in the graph.

The running time of the algorithm is the sum of running times for each statement executed. A statement that takes Ck steps to execute and executes m times contributes Ckm to the total running time. We usually denote the running time of an algorithm on an input of size n by T(n). To compute T(n), the running time of INSERTION-SORT on an input of n values, we sum the products of the cost and times columns, obtaining

Even for inputs of a given size, an algorithms running time may depend on which input of that size is given. For example, in INSERTION SORT, the best case occurs when the array is already sorted. In this case, each time that line 5 executes, the value of key-the value originally in A[i] - is already greater than or equal to all values in A[1:i-1], so that the while loop of lines 5-7 always exits upon the first test in line 5. There fore, we have that ti = 1 for i = 2,3,4,5,...n and the best case running time is given by an+b for constant a and b that depend on the statement costs Ck (where a = c1+...c8) and b = c2 + ... c8. The running time is thus a linear function of n. The worst case arises when the array is in reverse sorted order - that is, it starts out in decreasing order. The procedure must compare each element A[i] which each element in the entire sorted subarray A[1:i-1], and so ti = i for i = 2,3,..n. 

The average case is often roughly as bas as the worst case. 

Many useful algorithms are recursive in structure: to solve a given problem, they recurse on or more times to handle closely related subproblems. These algorithms typically follow the divide and conquer method: they break the problem into several subproblems that are similar to the original problem but smaller in size, solve the subproblems recursively, and then combine these solutions to create a solution to the original problem.
In the divide and conquer method, if the problem is mall enough - the base case - you just solve it directly without recursing. Otherwise - the recursive case - you perform three characteristic steps:
Divide the problem into one or more subproblems that are smaller instances of the same problem
Conquer the subproblems by solving them recursively
Combine the subproblem solutions to form a solution to the original problem.

The merge sort algorithm closely follows the divide and conquer method. In each step it sorts a subarray A[p:r], starting with the entire array A[a:n] and recursing down to smaller and smaller subarrays. Here is how merge sort operates: 

Divide the subarray A[p:r] to be sorted into two adjacent subarrays, each of half the size. To do so, compute the midpoint q of A[p:r] and divide A[p:r] into subarrays A[p:q] and A[q+1:r]
Conquer by sorting each the two subarrays A[p:q] and A[q+1:r] recursively using merge sort
Combine by merging the two sorted subarrays A[p:q] and A[q+1:r] back into A[p:r], producing the sorted answer
98/1312

PARENT(i):
   return bi=2c
LEFT(i):
   return 2i
RIGHT(i):
   return 2i + 1

MAX-HEAPIFY(A,i):
    l = LEFT(i)
    r = RIGHT(i)
    if l <= A.heap-size and A[l] > A[i]
	largest = l
    else largest = i
    if r <= A.heap-size and A[r] > A[largest]
	largest = r
    if largest != i
	exchange A[i] with A[largest]
	MAX- HEAPIFY(A, largest)


unlike merge sort, quick sort works well even in virtual memory system
Quicksort, like merge sort, applies the divide and conquer method. Here is the three step divide and conquer process for sorting a sub array: A[p:r]:

* Divide by partitioning (rearranging) the array A[p:r] into two sub arrays A[p:q-1 and A[q+1:r] shuch that each element in the low side of the partition is less than or equal to the pivot A[q], which is, in turn, less than or equal to each element in the high side. Compute the index q of the pivot as part of this partitioning procedure.
* Combine by doing nothing: because the two subarrays are already soted, no work is needed to combine them. All elements in A[p:q-1] are sorted and less than or equal to A[q], and all elements in A[q+1:r] are sorted and greater than or equal to the pivot A[q]. The entire subarray A[p:r] cannot help but be sorted

QUICKSORT(A,p,r):
    if p < r :
        // Partition the subarray around the pivot, which ends up in A[q]
        q = PARTITION(A,q,r)
        QUICKSORT(A, p, q-1) // recursively sort the low side
        QUICKSORT(A, q+1, r) // recursively sort the high side

* Partitioning the array
The key to the algorithm is the PARTITION procedure on the next page, which rearrages the subarray A[p:r] in place, returning the index of dividing point between the two sides of the partiion.
PARTITION always selects the element x = A[r] as the pibot. As the procedure runs, each element falls into exactly one of four regions, some of which may be empty. At the start of each iteration of the for loop in lines 3-6, the regiions satisfy certain properties. 

PARITION(A,p,r):
    x = A[r]        **//the pivot**
    i = p - 1           **//hihgest index into the low side**
    for j = p to r -1   **//process each element other than the pivot**
        if A[j] <= x     **//does this element belong on the low side?**
            i += 1      **//index of a new slot in the low side**
            exchange A[i] with A[j] **//put this element there**
    exchange A[i+1] with A[r] **//pivot goes just to the right of the low side**
    return i + 1 **//return new index of the pivot**

    At the begining of each iteration of the loop of lines 3-6, for any array index k, the following conditions hold:
    1. if p<= k <= 1, then A[k] <= x
    2. if i + 1 <= k <= j-1, then A[k] > x
    3. if k = r, then A[k]= x
	
    We need to show that this loop invariant is true prior to the first iteration, that each iteration of the loop maintains the invariant, that the loop terminates, and that correctnest follows from the invariant when the loop terminates
    **Ininitialization**: Prioor to the first iteration of the loop, we have i = p-1, and j = q. Because no values lie between p and i and no values lie between i +1 and j-1, the first two conditions of the loop invariant are trivially satisfied. The assignment in line 1 statisfies the third condition
    **Maintenance**: We consider two cases, depending on the outcome of the test in line 4. what happens when A[j] > x: the only action in the loop is to increment j. After j has been incremented, the second condition holds for A[j-1] and all other entries remain unchanged, and what happens when A[j] <= x: the loop increments i swap A[i] and A[j], and then increments j. Because of the swap we now have that A[i] <= x, and condition 1 is satisfied. Similarly, we also have that A[j-1] > x, since the item that was swapped into A[j-1] is, by the loop invariant, greater than x.
    ***Termination*: Since the loop makes exactly r - p iterations, it terminates, where upon j = r. At that point, the unexamied subarray A[j:r-1] is empty every entry in the array belongs to one of the other three sets described by the invariant. Thus the values in the array have been paritioned into three sets: those less than or equal to x, those greater than  and a singlton set containing x

    The final two lines of PARTITION finish up by swapping the pivot with the lef tmost element greater than x, there by, moving the pivot into its correct place in the partitioned array, and then returning the pivot's new index. The output of PARTITION now staisfied the specifications giving for the divide step. In fact, it satisfies a slightly stronger condidtion: after line 3 of QUICKSORT, A[q] is strictly less than every element of A[q+1:r]

# selection in expected linear time:
RANDOMIZED-SELECT is modeled after the quicksort algorith. Like quicksort it partitions the input array recursively. But unlinke quicksort, which rescursively processes both sides of the partition, RANDOMIZED-SELECT works on only one side of the parition. This difference shows up in the anylysis: whereas quicksort has an expected running time of O(nlgn), the expected running tim of RANDOMIZED-SELECT is O(n), assuming that the elements are distinct.
```
RANDOMIZED-SELECT (A, p, r, i)
    if  p == r
        return A[p]                     // 1 <= i <= r - p + 1 when p == r mean that i = 1
    q = RANDOMIZED-PARTITION(A, p, r)
    k = q - p + 1 // size of the lower side
    if i == k
        return A[q]                     // the pivot value is the answer
    elseif i < k 
        return RANDOMIZED-SELECT(A, p, q - 1, i)
    else return RANDOMIZED-SELECT(A, q + 1, r, i - k)
```

Line 1 checks for the base of the recursion, in which the subarray A[p:r] consists of just one element. In this case, i must be equal 1, and line 2 sumply returns A[p] as the ith smalles element. Otherwise, the call to RANDOMIZED-PARTITION in line 3 partitions the array A[p:r] into two subarrays A[p:q-1] and A[q+1:r] such that each element of A[p:q-1] is less than or equal to A[q], which in turn is less than each element of A[q+1:r]. As in quicksort, we'll refer to A[q] as the pivot element. Line 4 computes the number k of elements in the subarray A[p:q]. That is the number of elements in the low side of the partition, plus 1 for the pivot element. Line 5 then checks whether A[q] is the ith smallest element. If it is, then line 6 return A[q]. Otherwise, the algorithm determines in which of the two subarrays A[p:q-1] and A[q+1:r], which line 9 finds recursively. The code appears to allow recursive calls to subarrays with 0 elements

The complexity of Randomized Select algorithm depends on how luck we are with the pivot value, if each time of paritioning the array, we only can remove 1 item, the cost will be O(n2). So the best value of the pivot is the median of that sub-array
There is a solution names median of medians that approximately find the median in linear time complexity
![alt text]([https://github.com/thiemhoang/algorithm-practice/blob/main/resources/Screenshot%202025-02-11%20154917.png]) 
```
SELECT(A, p, r, i)
    while (r - p + 1) mode 5 != 0
        for j = p + 1 to r              // put the minimum into A[p]
            if A[p] > A[j]
                exchange A[p] with A[j]
        // If we want the mininum of A[p:r] we're done
        if i == 1
            return A[p]
        // Otherwise, we want the (i - 1)st element of A[p+1:r]
        p = p + 1
        i = i - 1
    g = (r - p + 1) / 5 // number of 5 elements groups
    for j = p to p + g -1
        sort(A[j], A[j+g], A[j+2g], A[j+3g], A[j+4g]) in place
    // All group medians now lie in the midle fifth of A[p:r].
    //Find the pivot x recursively as the median of the group medians

    x=SELECT(A, p+2g,p+3g-1,g/2) 
    q=PARTITION-AROUND(A,p,r,x) // partition around the pivot
    //The rest is just like lines 3-9 of RANDOMIZED-SELECT
    k=q-p+1
    if i == k
        return A[q]
    elseif i < k
        return SELECT(A, p, q - 1, i)
    else return SELECT(A, q + 1, r, i - k)

```

The pseudocode starts by executing the while loop in lines 1-10 to reduce the number r - p + 1 of elements in the subarray until it is divisible by 5. The while loop executes 0 to 4 times, each time rearraging the elements of A[p:r] so that A[p] contains the minimum element. If i = 1, which means that we actually want the minunum element, then the procedure simply returns it in line 7. Otherwise, SELECT eliminates the minimum from the subarray A[p:r] and iterates to find the (i-1)st element in A[p+1:r]. Lines 9-10 do so by incrementing p and decrementing i. If the while loop completes all of its iterations withou returning a result, the procedure executs the core of algorithm in lines 11-24, assured that the number r - p + 1 of elements in A[p:r] is evenly divisible by 5.
    The next part of the algorithm implements the following idea. Divide the elements in A[p:r] into g = (r-p+1)/5 groups of 5 elements each. The first 5 elements group is
    (A[p], A[p+g], A[p+2g], A[p+3g], A[p+4g])
    The second is
    (A[p+1], A[p+g+1], A[p+2g+1], A[p+3g+1], A[p+4g+1]),
    and so forth until the last, which is
    (A[p+g-1], A[p+2g-1], A[p+3g-1], A[p+4g-1], A[r])
(Not that r = p + 5g -1). Line 13 puts each group in order using, for example, insertion sort(Section 2.1), so that for j = p, p +1, ..., p + g - 1, we have A[j] <= A[j+g]<=A[j+2g]<=A[j+3g]<=A[j+4g]

Each vertial column in Figure 9.3 depicts a sorted group 5 elements. The median of each 5-element group is A[j+2g], and thus all the 5-element medians, shown in red, lie in the range A[p+2g:p+3g-1].
    Next, line 16 determines the pivot x by recursively calling SELECT to find the median (specificaly, the g/2 th smallest) of the g group medians. Line 17 uses the modified PARTITION-AROUND algorithm to partition the elements of A[p:r] around x, returning the index q, so that A[q] = x, elements in A[p:q] are all at most x, and elements in A[q:r] are greater than or equal to x.
    The remainder of the code mirrors that of RANDOMIZED-SELECT. If the pivot x is the ith largest, the procedure returns it. Otherwise, the procedure recursively calls itself on either A[p:q-1] or A[q+1:r], depending on the value of i.
