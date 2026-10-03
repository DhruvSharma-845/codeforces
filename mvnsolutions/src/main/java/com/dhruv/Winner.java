package com.dhruv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.NavigableMap;

public class Winner {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<AbstractMap.SimpleEntry<String, Integer>> players = new ArrayList<>();
		for(int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			players.add(new AbstractMap.SimpleEntry<>(name, score));
		}

		Winner w = new Winner();
		System.out.println(w.getFastestWinner(players));
	}

	public String getFastestWinner(List<AbstractMap.SimpleEntry<String, Integer>> players) {
		Map<String, List<AbstractMap.SimpleEntry<Integer, Integer>>> scores = new HashMap<>();
		NavigableMap<Integer, List<String>> reverseScores = new TreeMap<>();
		
		for(int i = 0; i < players.size(); ++i) {
			AbstractMap.SimpleEntry<String, Integer> player = players.get(i);
			if(!scores.containsKey(player.getKey())) {
				scores.put(player.getKey(), new ArrayList<>());
			}
			List<AbstractMap.SimpleEntry<Integer, Integer>> scoreList = scores.get(player.getKey());
			int oldScore = 0;
			if(scoreList.size() > 0) {
				oldScore = scoreList.get(scoreList.size() - 1).getKey();
			}
			int newScore = oldScore + player.getValue();

			scores.get(player.getKey()).add(new AbstractMap.SimpleEntry<>(newScore, i));

			if(reverseScores.containsKey(oldScore)) {
				reverseScores.get(oldScore).remove(player.getKey());
			}
			if(!reverseScores.containsKey(newScore)) {
				reverseScores.put(newScore, new LinkedList<>());
			}
			reverseScores.get(newScore).add(player.getKey());
		}

		int lowestIndex = Integer.MAX_VALUE;
		for(Map.Entry<Integer, List<String>> entry: reverseScores.descendingMap().entrySet()) {
			if(entry.getValue().size() > 0) {
				int maxScore = entry.getKey();
				for(String name: entry.getValue()) {
					for(AbstractMap.SimpleEntry<Integer, Integer> score: scores.get(name)) {
						if(score.getKey() >= maxScore && score.getValue() < lowestIndex) {
							lowestIndex = score.getValue();
						}
					}
				}
				break;
			}	
		}
		return players.get(lowestIndex).getKey();
	}
}