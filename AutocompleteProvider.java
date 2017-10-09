/* Autocomplete class, contains the data structure with possible candidates
 * And operations to train the data structure and retrieve candidates.
 */
import java.util.List;

public class AutocompleteProvider {
	Prefix_Tree storage;
	
	public AutocompleteProvider() {
		storage = new Prefix_Tree();
	}
	
	public List<Candidate> getWords(String fragment) {
		return storage.prefix_lookup(fragment);
	}
	
	public void train(String passage) {
		String[] words;
		String processed = passage.replaceAll("[^a-zA-Z ]", "");
		processed = processed.toLowerCase();
		words = processed.split("\\s+");
		
		for(int i = 0; i < words.length; i++) {
			storage.insert(words[i]);
		}
	}
}
