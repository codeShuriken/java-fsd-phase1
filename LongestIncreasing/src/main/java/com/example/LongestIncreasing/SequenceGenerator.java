package com.example.LongestIncreasing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SequenceGenerator  {
	private int n;
	private List<Integer> arrayList = new ArrayList<>();
	private Random rand;

    public SequenceGenerator(int n) {
        this.n = n;
        this.rand = new Random();
    }
    
    public List<Integer> getArrayList() {
        return this.arrayList;
    }
    
    public int getSize() {
    	return this.n;
    }

    public List<Integer> generateSequence() {
        this.arrayList.clear();
        for (int i = 0; i < this.n; i++) {
            this.arrayList.add(rand.nextInt(2 * this.n + 1));
        }
        return this.arrayList;
    }
}
