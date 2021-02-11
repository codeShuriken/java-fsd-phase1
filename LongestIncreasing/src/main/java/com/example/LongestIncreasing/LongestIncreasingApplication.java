package com.example.LongestIncreasing;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingApplication {
	
    public static void main(String[] args){
    	int n = 25;
		SequenceGenerator sequenceGenerator = new SequenceGenerator(n);
		List<Integer> sequence = sequenceGenerator.generateSequence();
		System.out.println("Input Sequence is: " + sequence);
		
		int[] longestSeq = LongestIncresingFinder.findLongestIncreasingSubsequence(sequence);
		
		System.out.println("The longest increasing sequence is: " + Arrays.toString(longestSeq));
		
		System.out.println("-----------------------------------------------------------------------");
		
		int n1 = 50;
		SequenceGenerator sequenceGenerator1 = new SequenceGenerator(n1);
		List<Integer> sequence1 = sequenceGenerator1.generateSequence();
		System.out.println("Input Sequence is: " + sequence1);
		
		int[] longestSeq1 = LongestIncresingFinder.findLongestIncreasingSubsequence(sequence1);
		
		System.out.println("The longest increasing sequence is: " + Arrays.toString(longestSeq1));
		
		System.out.println("-----------------------------------------------------------------------");
		
		int n2 = 100;
		SequenceGenerator sequenceGenerator2 = new SequenceGenerator(n2);
		List<Integer> sequence2 = sequenceGenerator2.generateSequence();
		System.out.println("Input Sequence is: " + sequence2);
		
		int[] longestSeq2 = LongestIncresingFinder.findLongestIncreasingSubsequence(sequence2);
		
		System.out.println("The longest increasing sequence is: " + Arrays.toString(longestSeq2));
    }
}
