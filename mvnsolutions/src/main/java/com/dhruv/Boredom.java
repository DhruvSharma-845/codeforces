package com.dhruv;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Scanner;

public class Boredom {
	public long getMaximumPoints(List<Integer> sequence) {
		SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
		for(Integer num: sequence) {
			if(!sortedMap.containsKey(num)) {
				sortedMap.put(num, 0);
			}
			sortedMap.put(num, sortedMap.get(num) + 1);
		}

		List<Long> dpTable = new ArrayList<>(sortedMap.size() + 1);
		dpTable.add(0L);
		Iterator<Map.Entry<Integer, Integer>> it = sortedMap.entrySet().iterator();
		
		Map.Entry<Integer, Integer> entry = it.next();
		dpTable.add((long)entry.getKey() * entry.getValue());
		int previousKey = entry.getKey();

		long result = dpTable.get(1);
		for(int i = 2; i <= sortedMap.size(); ++i) {
			long withoutKey = dpTable.get(i-1);
			Map.Entry<Integer, Integer> currentEntry = it.next();
			long withKey = ((long)currentEntry.getKey() * currentEntry.getValue()) + (currentEntry.getKey() == previousKey + 1 ? dpTable.get(i-2) : dpTable.get(i-1));
			dpTable.add(Math.max(withoutKey, withKey));
			result = Math.max(result, dpTable.get(i));
			previousKey = currentEntry.getKey();
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int sz = scanner.nextInt();

		List<Integer> sequence = new ArrayList<>(sz);
		for(int i = 0; i < sz; ++i) {
			sequence.add(scanner.nextInt());
		}
		Boredom bd = new Boredom();
		System.out.println(bd.getMaximumPoints(sequence));
	}
}
