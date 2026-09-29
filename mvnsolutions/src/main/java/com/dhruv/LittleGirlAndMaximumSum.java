package com.dhruv;

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.io.InputStream;
import java.io.IOException;

public class LittleGirlAndMaximumSum {
   	static class FastScanner {
        	private final InputStream in;
        	private final byte[] buffer = new byte[1 << 16];
        	private int ptr = 0;
        	private int len = 0;

        	FastScanner(InputStream is) {
            		in = is;
        	}

        	private int read() throws IOException {
            		if (ptr >= len) {
                		len = in.read(buffer);
                		ptr = 0;
               	 		if (len <= 0) {
                    			return -1;
                		}
           		 }	
            		return buffer[ptr++];
        	}

        	int nextInt() throws IOException {
            		int c;
            		do {
                		c = read();
            		} while (c <= ' ');

            		int sign = 1;
            		if (c == '-') {
                		sign = -1;
                		c = read();
           		 }

            		int result = 0;
            		while (c > ' ') {
                		result = result * 10 + (c - '0');
                		c = read();
           		 }

            		return result * sign;
        	}
    	}
	public static void main(String[] args) throws Exception {
		LittleGirlAndMaximumSum lgms = new LittleGirlAndMaximumSum();
		FastScanner sc = new FastScanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		List<Integer> sequence = new ArrayList<>(N);
		for(int i = 0; i < N; ++i) {
			sequence.add(sc.nextInt());
		}
		// List<AbstractMap.SimpleEntry<Integer, Integer>> queries = new ArrayList<>(Q);
		int[] prefix = new int[sequence.size() + 1];
		for(int i = 0; i < Q; ++i) {
			AbstractMap.SimpleEntry<Integer, Integer> pair = new AbstractMap.SimpleEntry<>(sc.nextInt(), sc.nextInt());
			prefix[pair.getKey()] += 1;
 			if(pair.getValue() < N) {
 				prefix[pair.getValue() + 1] -= 1;
 			}
			// queries.add(pair);
		}
		System.out.println(lgms.getMaximumSumFromQueries(sequence, null, prefix));
	}

	public long getMaximumSumFromQueries(List<Integer> sequence, List<AbstractMap.SimpleEntry<Integer, Integer>> queries, int[] prefix) {
		if(prefix == null) {
			System.out.println("Setting up prefix");
			prefix = new int[sequence.size() + 1];
			for(AbstractMap.SimpleEntry<Integer, Integer> query: queries) {
				prefix[query.getKey()] += 1;
 				if(query.getValue() < sequence.size()) {
 					prefix[query.getValue() + 1] -= 1;
 				}
			}
		}
		for(int i = 1; i <= sequence.size(); ++i) {
			prefix[i] += prefix[i - 1];
		}
		Arrays.sort(prefix);
		Collections.sort(sequence);

		long result = 0L;
		for(int i = 1; i <= sequence.size(); ++i) {
			result += ((long)prefix[i] * sequence.get(i - 1));
		}	
		return result;
	}
}
