package com.dhruv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap;
import com.dhruv.LittleGirlAndMaximumSum;

public class LittleGirlAndMaximumSumTest {
	LittleGirlAndMaximumSum lgms = new LittleGirlAndMaximumSum();

	@Test
	void shouldHandleBasicCase() {
		List<Integer> sequence = new ArrayList<>(List.of(5, 3, 2));
                List<AbstractMap.SimpleEntry<Integer, Integer>> queries = new ArrayList<AbstractMap.SimpleEntry<Integer, Integer>>(List.of(
                                        new AbstractMap.SimpleEntry<Integer, Integer>(1, 2),
                                        new AbstractMap.SimpleEntry<Integer, Integer>(2, 3),
                                        new AbstractMap.SimpleEntry<Integer, Integer>(1, 3)
					));
		assertEquals(25, lgms.getMaximumSumFromQueries(sequence, queries, null));	
	}

	@Test
        void shouldHandleMediumCase() {
                List<Integer> sequence = new ArrayList<>(List.of(5, 2, 4, 1, 3));
                List<AbstractMap.SimpleEntry<Integer, Integer>> queries = new ArrayList<AbstractMap.SimpleEntry<Integer, Integer>>(List.of(
                                        new AbstractMap.SimpleEntry<Integer, Integer>(1, 5),
                                        new AbstractMap.SimpleEntry<Integer, Integer>(2, 3),
                                        new AbstractMap.SimpleEntry<Integer, Integer>(2, 3)
                                        ));
                assertEquals(33, lgms.getMaximumSumFromQueries(sequence, queries, null));
        }
}
