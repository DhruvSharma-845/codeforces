package com.dhruv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 

import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;

import com.dhruv.Winner;

public class WinnerTest {

	Winner w = new Winner();

	@Test
	public void shouldHandleBasicCase() {
		List<AbstractMap.SimpleEntry<String, Integer>> players = new ArrayList<>(List.of(
			new AbstractMap.SimpleEntry<>("mike", 3),
			new AbstractMap.SimpleEntry<>("andrew", 5),
			new AbstractMap.SimpleEntry<>("mike", 2)
		));

		assertEquals("andrew", w.getFastestWinner(players));
	}
}