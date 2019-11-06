package coding.interview;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode('\\');
	}

	public void addWord(String word) {
		TrieNode previousNode = root;

		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode currentTrieNode = previousNode.getTrieNode(c);

			if(currentTrieNode == null) {
				currentTrieNode =  new TrieNode(c);
				previousNode.insertTrieNode(currentTrieNode);
			}

			previousNode.plusPrefixCount();
			previousNode = currentTrieNode;
		}
		
		previousNode.plusWordCount();
	}

	public List<Pair<String, Integer>> getPrefixes() {
		List<Pair<String, Integer>> prefixes = new ArrayList<>();

		for(TrieNode t : root.getSuffixes()) {
			Pair<String, Integer> prefix = t.getPrefix();

			if(prefix.getSecond() > 1)
				prefixes.add(prefix);
		}

		return prefixes;
	}

	@Override
	public String toString() {
		return root.toString();
	}
}
