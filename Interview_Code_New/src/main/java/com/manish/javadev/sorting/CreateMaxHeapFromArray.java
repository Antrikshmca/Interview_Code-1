package com.manish.javadev.sorting;

import java.util.Arrays;

/**
 * @author Manish Srivastava
 *
 */
public class CreateMaxHeapFromArray {
	public static void main(String[] args) {
		int arr[] = { 11, 12, 13, 5, 6, 7, 14 };
		// int arr[] = { 12, 11, 13, 5, 6, 7, 8, 4, 3 };
		CreateMaxHeapFromArray hs = new CreateMaxHeapFromArray();
		hs.max_heap(arr);
		System.out.println("Sorted array is");
		System.out.println(Arrays.toString(arr));
	}

	public void max_heap(int arr[]) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			build_maxheap(arr, n, i);

	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void build_maxheap(int arr[], int size, int crr) {
		int largest = crr; // Initialize largest as root
		int l = 2 * crr + 1; // left = 2*i + 1
		int r = 2 * crr + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < size && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < size && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != crr) {
			swapNode(arr, largest, crr);
			// Recursively heapify the affected sub-tree
			build_maxheap(arr, size, largest);
		}
	}

	private void swapNode(int[] arr, int start, int left) {
		int temp;
		temp = arr[start];
		arr[start] = arr[left];
		arr[left] = temp;
	}
}
