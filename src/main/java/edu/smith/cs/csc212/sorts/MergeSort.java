package edu.smith.cs.csc212.sorts;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {

	/**
	 * This method walks through two sorted input lists and creates an output list that contains all elements from the two inputs.
	 * @param lhs - a sorted list.
	 * @param rhs  - a sorted list.
	 * @return a sorted list containing all of the items from lhs and rhs.
	 */
	public static ListADT<Integer> combineTwoSortedLists(ListADT<Integer> lhs, ListADT<Integer> rhs) {
		ListADT<Integer> output = new JavaList<>();
		while (lhs.size() != 0 && rhs.size() != 0){
			if (lhs.getFront() <= rhs.getFront()) {
				output.addBack(lhs.removeFront());
			} else {
				output.addBack(rhs.removeFront());
			}
		}
		output.addAll(lhs);
		output.addAll(rhs);
		return output;
	}
	
	/**
	 * Recursively sort this list by breaking it in half and piecing it back together.
	 * You will need to call {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
     *
	 * @param input - the input list.
	 * @return a new list containing the sorted output.
	 */
	public static ListADT<Integer> doMergeSortRecursively(ListADT<Integer> input) {
		if (input.size() == 1) {
			return input;
		}
		else {
			ListADT<Integer> left = input.slice(0, input.size()/2);
			ListADT<Integer> right = input.slice(input.size()/2, input.size());
			return combineTwoSortedLists(doMergeSortRecursively(left), doMergeSortRecursively(right));
		}
	}
	
	/**
	 * Iteratively sort this list by breaking it in half and piecing it back together.
	 * You will need to call {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
	 * 
	 * @param input - the input list.
	 * @return a new list containing the sorted output.
	 */
	public static ListADT<Integer> doMergeSortIteratively(ListADT<Integer> input) {
		ListADT<ListADT<Integer>> all = new JavaList<>();
		for (int a: input) {
			ListADT<Integer> single = new JavaList<>();
			single.addBack(a);
			all.addBack(single);
		}
		while (all.size() != 1) {
			all.addBack(combineTwoSortedLists(all.removeFront(),all.removeFront()));
		}
		return all.getFront();
			
	}
}
