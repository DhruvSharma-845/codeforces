package com.dhruv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

import com.dhruv.Boredom;

class BoredomTest {
	private Boredom boredom = new Boredom();

	@Test
	void shouldHandleBasicCase() {
		List<Integer> sequence = new ArrayList<>(List.of(1, 2));
		long maxPoints = boredom.getMaximumPoints(sequence);
		assertEquals(2L, maxPoints);
	}

	@Test
        void shouldHandleMediumCase() {
                List<Integer> sequence = new ArrayList<>(List.of(1, 2, 1, 3, 2, 2, 2, 2, 3));
                long maxPoints = boredom.getMaximumPoints(sequence);
                assertEquals(10L, maxPoints);
        }
}
