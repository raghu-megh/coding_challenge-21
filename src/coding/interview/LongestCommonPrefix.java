package coding.interview;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix("apple", "ape"));

		List<String> words = Arrays.asList("pea", "pear", "apple", "for", "april", "apendix", "peace", "1");

		Trie trie = new Trie();

		for(String word : words) {
			trie.addWord(word);
		}
		
		trie.addWord("peaceful");
		trie.addWord("apparent");
		trie.addWord("applause");
		trie.addWord("apex");

		List<Pair<String, Integer>> prefixes = trie.getPrefixes();
		System.out.println(prefixes);
		if(prefixes.isEmpty()) {
			System.out.println(-1);
		}

		Pair<String, Integer> maxPair = findMaxPair(prefixes);
		System.out.println(maxPair.getFirst());
	}

	private static Pair<String, Integer> findMaxPair(List<Pair<String, Integer>> prefixes) {
		Pair<String, Integer> maxPair = prefixes.get(0);

		for(Pair<String, Integer> p : prefixes) {
			if(maxPair.getSecond() < p.getSecond() || (maxPair.getSecond() == p.getSecond() && 
					(maxPair.getFirst().length() < p.getFirst().length()))) {
				maxPair = p;
			}
		}
		
		return maxPair;
	}

	public static String longestCommonPrefix(String string1, String string2) {
		if(string1.isEmpty() || string2.isEmpty()) return "";

		if(string1.length() == 1 || string2.length() == 1) {
			if(string1.charAt(0) == string2.charAt(0)) {
				return string1.charAt(0) + "";
			}

			return "";
		}

		if(string1.charAt(0) == string2.charAt(0)) {
			String prefix = longestCommonPrefix(string1.substring(1), string2.substring(1));

			return string1.charAt(0) + prefix;
		}

		return "";
	}
}
