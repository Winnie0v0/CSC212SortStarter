# CSC212: SortStarter
Self-Tested Sorting Starter Code (opinionated structure).

## About this Sorting Assignment

- We're going to focus on the mechanics of sorting here, using our ``ListADT`` classes.
- Helper methods are explicitly formed in this bit of starter code.

## Using ListADT again:

Note: ``ListADT`` and friends are not actually in this repository.
- You can browse the [online Javadoc](https://javadoc.jitpack.io/com/github/jjfiv/CSC212ADT/1.3/javadoc/index.html).
- You can directly [import the code](https://github.com/jjfiv/CSC212ADT) if you want.

The most important portions of the interface are:

```java
public abstract class ListADT<T> ... {
  ...  
  public void addFront(T item);
  public void addBack(T item);
  public void addIndex(int index, T item);

  public T getFront();
  public T getBack();
  public T getIndex(int index);
  
  public void setIndex(int index, T value);
  
  // This is a new one; super-helpful, esp. for Selection Sort!
  public void swap(int index1, int index2);
  
  // This is a new one; super-helpful esp. for Merge Sort!
  public ListADT<T> slice(int start, int endExclusive);

  public int size();
  public boolean isEmpty();
}
```

## Grading (Automatic)

Right now, when I run all the tests in this project, I get the following output:

```
Tests run: 14, Failures: 0, Errors: 13, Skipped: 0
```

So there are 1 passing test, and 13 failing tests.

Your score on this assignment will range up to 100% -- the fraction of the tests that pass on your code (minus the tests that already pass), provided:

 1. you do not use uncited online resources.
 2. there are no code compilation problems with your code (red lines or Problems in Eclipse).  
 3. you do not rename any methods or modify the tests in any way, and 
 4. you resolve any infinite loops in your code (better to comment out that method and have it crash than run forever -- it prevents other tests from running.

## Text-Hints

### SortedSearching

This is your chance to write an implementation of binary search (two of them, actually).

#### ``binarySearchIterative``

- Create variables ``int left = 0`` and ``int right = dataset.size()``. 
- Then play the GuessingGame optimally against it, updating ``left`` or ``right`` each time based on the hint from the ``int middle = (left + right) / 2`` element.
- When you find it, return the position you found it at.
- It's very easy to have an off-by-one error here.

#### ``binarySearchR``

I wouldn't tackle this until the previous method works. Here, instead of updating ``left`` or ``right`` and going around the loop again, you will return a the results of a search (``binarySearchR``) on a smaller range.

### SlowSorts

These are sorts that have quite short descriptions, and each of the ones I want you to code have helper methods.

#### Selection Sort

Selection Sort works by finding the minimum value in the list and bringing it to the front, over and over. This is one of the simplest sorting algorithms.

The helper method ``findMinPosition`` is where you want to start here. If you don't understand what it's supposed to do, check out the test for it!

#### Insertion Sort

Insertion Sort works by building up a list one at a time, and inserting it into the right point. Some bonus points may be available for using binary search to insert, but it can be done with linear search as well. 

The helper method ``insertSorted`` is where you want to start here. If you don't understand what it's supposed to do, check out the test for it!

### Merge Sort

Merge sort is an important sorting algorithm. We will explore the recursive and iterative solutions in this assignment.
First, you will implement a helper method: ``combineTwoSortedLists``, and then you will implement MergeSort twice: once recursive and once iterative.

#### ``combineTwoSortedLists`` helper method

To merge two sorted lists into a single sorted list, look at the first element in each list. Take the smaller of the two off the front of its old list and put it at the end of the new (merged) list. Repeat this until both one of the old lists is empty, at which point you can append the remainder of the other original list to the new list. If the original lists were sorted, and you always take the smallest element available, then the resulting list will also be sorted. 

#### Recursive MergeSort

Use recursion to break down the list into pieces, sort those pieces and build it back up by calling ``combineTwoSortedLists``. Split the list in half until there are only tiny lists that remain.

Note two of the new methods on ``ListADT``: ``slice`` and ``addAll`` that can help you make a copy of a part or all of a list.

#### Iterative MergeSort

Begin by placing each element of the original list into a new singleton list. You may store all the singleton lists in a list of lists.

##### How do you make a list of one element?

While more than one list remains, take the first two lists from your work queue and merge them, preserving the sorted order. Put the result back at the end of the work queue.
