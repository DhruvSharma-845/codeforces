package com.dhruv;

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap;

import java.util.Scanner;

public class Woodcutters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<AbstractMap.SimpleEntry<Integer, Integer>> trees = new ArrayList<>();
		int N = sc.nextInt();
		for(int i = 0; i < N; ++i) {
			int tX = sc.nextInt();
			int tHeight = sc.nextInt();
			trees.add(new AbstractMap.SimpleEntry<>(tX, tHeight));
		}
		Woodcutters wc = new Woodcutters();
		System.out.println(wc.getMaximumCutTrees(trees));
	}
	public int getMaximumCutTrees(List<AbstractMap.SimpleEntry<Integer, Integer>> trees) {
		int[][] dpTable = new int[trees.size()][3];

		dpTable[0][0] = 0;
		dpTable[0][1] = 1;
		dpTable[0][2] = trees.size() > 1 && trees.get(0).getKey() + trees.get(0).getValue() < trees.get(1).getKey() ? 1 : 0;
		for(int i = 1; i < trees.size(); ++i) {
			int currentTreeX = trees.get(i).getKey();
			int currentTreeHeight = trees.get(i).getValue();
			int previousTreeX = trees.get(i-1).getKey();
			int previousTreeHeight = trees.get(i-1).getValue();

			int withoutFall = Math.max(dpTable[i - 1][0], Math.max(dpTable[i - 1][1], dpTable[i - 1][2]));
			int leftFall = Math.max((currentTreeX - currentTreeHeight > previousTreeX) ? Math.max(dpTable[i-1][0], dpTable[i-1][1]) + 1: withoutFall, (currentTreeX - currentTreeHeight > previousTreeX + previousTreeHeight) ? dpTable[i-1][2] + 1 : withoutFall);
			int rightFall = i < trees.size() - 1 ? (currentTreeX + currentTreeHeight < trees.get(i+1).getKey() ? withoutFall + 1: withoutFall) : withoutFall + 1;
			dpTable[i][0] = withoutFall;
			dpTable[i][1] = leftFall;
			dpTable[i][2] = rightFall;
		}
		return Math.max(dpTable[trees.size() - 1][0], Math.max(dpTable[trees.size() - 1][1], dpTable[trees.size() - 1][2]));
	}
}
