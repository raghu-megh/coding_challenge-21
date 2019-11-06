package coding.interview;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

	private char c;
	private List<TrieNode> suffixes;
	private int prefixCount;
	private int wordCount;

	public TrieNode(char c) {
		this.c = c;
		suffixes = new ArrayList<>();
	}
	
	public void plusWordCount() {
		wordCount++;
	}
	
	public int getWordCount() {
		return wordCount;
	}

	public void insertTrieNode(TrieNode t) {
		suffixes.add(t);
	}

	public char getChar() {
		return c;
	}

	public int getPrefixCount() {
		return prefixCount;
	}

	public List<TrieNode> getSuffixes() {
		return suffixes;
	}

	public TrieNode getTrieNode(char c) {
		for(TrieNode t : suffixes) {
			if(t.getChar() == c) return t;
		}

		return null;
	}

	@Override
	public String toString() {
		return c + "->" + suffixes;
	}

	public boolean isPrefixNode() {
		return suffixes.size() == 1 || suffixes.isEmpty();
	}

	public int lengthOfPrefix() {
		if(isPrefixNode()) {
			if(suffixes.isEmpty()) return 0;

			return 1 + suffixes.get(0).lengthOfPrefix();
		}

		return 0;
	}

	public Pair<String, Integer> getPrefix() {
		if(isPrefixNode()) {
			if(suffixes.isEmpty()) {
				return new Pair<>(c + "", getPrefixCount() + wordCount);
			}

			Pair<String, Integer> prefix = suffixes.get(0).getPrefix();
			return new Pair<>(c + prefix.getFirst(), prefix.getSecond() + wordCount);
		}

		return new Pair<>(c + "", getPrefixCount() + wordCount);
	}

	public void plusPrefixCount() {
		prefixCount++;
	}
}
