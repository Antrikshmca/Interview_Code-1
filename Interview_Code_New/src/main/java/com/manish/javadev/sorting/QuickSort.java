package com.manish.javadev.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 5, 2, 6, 1, 3, 4 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int arr[], int p, int r) {
		if (p < r) {
			// The index of pivot element is same as in sorted array and in
			// Portioned array
			int q = partition(arr, p, r);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
		}
	}

	private static int partition(int[] arr, int p, int r) {
		int pivote = arr[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (arr[j] <= pivote) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, r, i + 1);
		return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
