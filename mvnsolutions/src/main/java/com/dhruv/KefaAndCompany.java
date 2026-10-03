package com.dhruv;

import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class KefaAndCompany {
	public long getMaximumFriendship(List<AbstractMap.SimpleEntry<Integer, Integer>> friends, int minDiffMoney) {
		friends.sort((f1, f2) -> Integer.compare(f1.getKey(), f2.getKey()));

		int leftIndex = 0;
		int rightIndex = 0;

		long currentFriendShipSum = 0L;
		long maxFriendShipTillNow = 0L;
		
		while(rightIndex < friends.size()) {
			AbstractMap.SimpleEntry<Integer, Integer> rightFriend = friends.get(rightIndex);
			AbstractMap.SimpleEntry<Integer, Integer> leftFriend = friends.get(leftIndex);
			if(rightFriend.getKey() - leftFriend.getKey() < minDiffMoney) {
				++rightIndex;
				currentFriendShipSum += (long)rightFriend.getValue();
				if(currentFriendShipSum > maxFriendShipTillNow) {
					maxFriendShipTillNow = currentFriendShipSum;
				}
			}
			else if(rightFriend.getKey() - leftFriend.getKey() >= minDiffMoney) {
				while(rightFriend.getKey() - leftFriend.getKey() >= minDiffMoney) {
					++leftIndex;
					currentFriendShipSum -= (long)leftFriend.getValue();
					leftFriend = friends.get(leftIndex);
				}
			}
		}
		return maxFriendShipTillNow;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int D = sc.nextInt();

		List<AbstractMap.SimpleEntry<Integer, Integer>> friends = new ArrayList<>();
		for(int i = 0; i < N; ++i) {
			friends.add(new AbstractMap.SimpleEntry<>(sc.nextInt(), sc.nextInt()));
		}
		KefaAndCompany kc = new KefaAndCompany();
		System.out.println(kc.getMaximumFriendship(friends, D));
	}
}