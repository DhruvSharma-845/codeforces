package com.dhruv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;

import com.dhruv.KefaAndCompany;

public class KefaAndCompanyTest {
	KefaAndCompany kc = new KefaAndCompany();

	@Test
	public void shouldHandleBasicCase() {
		List<AbstractMap.SimpleEntry<Integer, Integer>> friends = new ArrayList<>(List.of(
			new AbstractMap.SimpleEntry<>(75, 5),
			new AbstractMap.SimpleEntry<>(0, 100),
			new AbstractMap.SimpleEntry<>(150, 20),
			new AbstractMap.SimpleEntry<>(75, 1)
		));
		assertEquals(100, kc.getMaximumFriendship(friends, 5));
	}
}