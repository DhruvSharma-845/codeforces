package com.dhruv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;

import com.dhruv.Woodcutters;

public class WoodcuttersTest {
	private Woodcutters wc = new Woodcutters();

	@Test
	public void shouldHandleBasicCase() {
		List<AbstractMap.SimpleEntry<Integer, Integer>> trees = new ArrayList<>(List.of(
					new AbstractMap.SimpleEntry<>(1, 2),
					new AbstractMap.SimpleEntry<>(2, 1),
					new AbstractMap.SimpleEntry<>(5, 10),
					new AbstractMap.SimpleEntry<>(10, 9),
					new AbstractMap.SimpleEntry<>(19, 1)
					));
		assertEquals(3, wc.getMaximumCutTrees(trees));
	}
}
