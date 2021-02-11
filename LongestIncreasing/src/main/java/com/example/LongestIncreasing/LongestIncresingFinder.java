package com.example.LongestIncreasing;

import java.util.List;

public class LongestIncresingFinder {

	public static int[] findLongestIncreasingSubsequence(List<Integer> nums) {
		int maxSeqLen = 0;
		int maxSeqStart = 0;
		int size = nums.size();
		
		
		/*
		 * The time complexity is O(N)
		 * Even though I'm using a while loop inside, I'm still 
		 * traversing each element in the ArrayList only once. 
		 * Therefore the time complexity is linear.
		 */
		for (int end = 0; end < size; ++end) {
			int start = end;
			while (end + 1 < size && nums.get(end) < nums.get(end+1))++end;
			if (end - start + 1 > maxSeqLen) {
				maxSeqLen = end - start + 1;
				maxSeqStart = start;
			}
		}
		
		System.out.println("The length of the longest increasing sequence is " + maxSeqLen + " starting from index " + maxSeqStart + 
				" to index " + (maxSeqStart + maxSeqLen - 1));
		List<Integer> result = nums.subList(maxSeqStart, maxSeqStart + maxSeqLen);
		
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}
