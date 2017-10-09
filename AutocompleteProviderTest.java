/* Test for Autocomplete Provider.
 * 
 */
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AutocompleteProviderTest {

	@Test
	public void test() {
		AutocompleteProvider test = new AutocompleteProvider();
		String passage = "The third thing that I need to tell you is that this thing does not think thoroughly.";
		test.train(passage);
		List<Candidate> auto1 = test.getWords("thi");
		List<Candidate> auto2 = test.getWords("nee");
		List<Candidate> auto3 = test.getWords("th");
		
		assertEquals(auto1.get(0).getWord(), "thing");
		assertEquals(auto1.get(1).getWord(), "think");
		assertEquals(auto1.get(2).getWord(), "third");
		assertEquals(auto1.get(3).getWord(), "this");
		
		assertEquals(auto1.get(0).getConfidence(), 2);
		assertEquals(auto1.get(1).getConfidence(), 1);
		assertEquals(auto1.get(2).getConfidence(), 1);
		assertEquals(auto1.get(3).getConfidence(), 1);
		
		assertEquals(auto2.get(0).getWord(), "need");
		
		assertEquals(auto2.get(0).getConfidence(), 1);
		
		assertEquals(auto3.get(0).getWord(), "that");
		assertEquals(auto3.get(1).getWord(), "thing");
		assertEquals(auto3.get(2).getWord(), "the");
		assertEquals(auto3.get(3).getWord(), "think");
		assertEquals(auto3.get(4).getWord(), "third");
		assertEquals(auto3.get(5).getWord(), "this");
		assertEquals(auto3.get(6).getWord(), "thoroughly");
		
		assertEquals(auto3.get(0).getConfidence(), 2);
		assertEquals(auto3.get(1).getConfidence(), 2);
		assertEquals(auto3.get(2).getConfidence(), 1);
		assertEquals(auto3.get(3).getConfidence(), 1);
		assertEquals(auto3.get(4).getConfidence(), 1);
		assertEquals(auto3.get(5).getConfidence(), 1);
		assertEquals(auto3.get(6).getConfidence(), 1);
		
	}

}
