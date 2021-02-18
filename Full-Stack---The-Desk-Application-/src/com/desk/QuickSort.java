package com.desk;

import java.util.ArrayList;

public class QuickSort {
	//O(NlogN) Average case sorting algorithm
		public static void sort(ArrayList<Integer> arrayList, int i, int j) {
			//Base case
			if (i >= j)return;
			int pivot = partition(arrayList, i, j);
			sort(arrayList, i, pivot-1);
			sort(arrayList, pivot + 1, j);
		}

		private static int partition(ArrayList<Integer> arrayList, int i, int j) {
			int pivot = i;
			int index = pivot+1;
			for (int i1  = i+1; i1 <= j; ++i1) {
				if (arrayList.get(pivot) > arrayList.get(i1)) {
					//Swap
					swap(arrayList, index, i1);
					index++;
				}
			}
			//Swap pivot with index
			--index;
			swap(arrayList, pivot, index);
			return index;
		}

		private static void swap(ArrayList<Integer> arrayList, int i, int j) {
			int temp = arrayList.get(i);
			arrayList.set(i, arrayList.get(j));
			arrayList.set(j, temp);
		}
}
