/* Prefix tree holds information on the different candidates along with arranging candidates based on 
 * prefixes.
 */
import java.util.ArrayList;
import java.util.List;

public class Prefix_Tree {
	Candidate root;
	int size;
	
	
	public Prefix_Tree() {
		root = new Candidate("");
		size = 0;
	}
	
	//Inserts word into tree via iteration of the characters in the word given
	public void insert(String word){
		if (word == null || word.length() == 0) {
			return;
		}
		Candidate node = this.root;
		Candidate stuff;
		int i, j;
		
		//Iterates to the last character, adding new nodes to the path if none exists
		for(i = 0; i < word.length() - 1; i++) {
			j = word.charAt(i) - 'a';
			if(node.childern[j] == null) {
				stuff = new Candidate("");
				node.childern[j] = stuff;
				node = stuff;
			} else {
				node = node.childern[j];
			}
		}
		
		/*Handles the last character if word already exists update confidence
		 * otherwise add candidate, increase size, set end 
		 */
		j = word.charAt(word.length() - 1) - 'a';
		if(node.childern[j] == null) {
			stuff = new Candidate(word);
			node.childern[j] = stuff;
			node = stuff;
			node.confidence = 1;
			node.end = true;
			size = size + 1;
		} else {
			node = node.childern[j];
			if(node.word == "") {
				node.word = word;
				node.end = true;
			}
			node.confidence += 1;
		}
		
	}
	
	//lookup prefix, finds the prefix node, then calls the lookup helper.
	public List<Candidate> prefix_lookup(String prefix) {
		Candidate start = find(prefix);
		if(start == null) {
			return null;
		}
		List<Candidate> res = prefix_lookup(start);
		Sort_by_Confidence c = new Sort_by_Confidence();
		res.sort(c);
		return res;
	}
	
	/* Lookup helper, recursive solution.  Base case if null return empty List.
	 * else recursively call on the childern to build an List
	 * then if node contains a word add it to the the List.
	 * return List.
	 */
	private List<Candidate> prefix_lookup(Candidate start) {
		//Base case if null
		if(start == null) {
			return new ArrayList<Candidate>();
		} 
		//recursive call on childern
		List<Candidate> res = new ArrayList<Candidate>();
		Candidate curr = start;
		for(int i = 0; i < start.childern.length; i++) {
				res.addAll(prefix_lookup(curr.childern[i]));
		}
		
		//check it current node is a word
		if(start.end == true) {
			res.add(start);
		}
		return res;
	}
	
	//Finds the Candidate by traversing the prefix tree, iterating on the characters of the word
	public Candidate find(String word) {
		if (word == null|| word.length() == 0) {
			return null;
		}
		
		Candidate node = this.root;
		int i, j;
		
		for(i = 0; i < word.length(); i++) {
			j = word.charAt(i) - 'a';
			if(node.childern[j] == null) {
				return null;
			} else {
				node = node.childern[j];
			}
		}
		
		return node;
	}
	
}
