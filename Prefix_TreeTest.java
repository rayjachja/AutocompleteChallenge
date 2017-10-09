/* Test for Prefix tree.
 * 
 */

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class Prefix_TreeTest {

	@Test
	public void test1() {
		Prefix_Tree test = new Prefix_Tree();
		test.insert("water");
		test.insert("");
		test.insert("waterpokemon");
		test.insert("water");
		
		assertEquals(test.find("water").getWord(), "water");
		assertEquals(test.find("zzz"), null);
		assertEquals(test.find(""), null);
		assertEquals(test.find("water").getConfidence(), 2);
		assertEquals(test.find("waterpokemon").getConfidence(), 1);
		assertEquals(test.size, 2);
	}

	@Test
	public void test2() {
		Prefix_Tree test = new Prefix_Tree();
		test.insert("water");
		test.insert("");
		test.insert("waterpokemon");
		test.insert("water");
		List<Candidate> stuff = test.prefix_lookup("wat");
		assertEquals(stuff.get(0).getWord(), "water");
		assertEquals(stuff.get(1).getWord(), "waterpokemon");
	}
	
	@Test
	public void test3() {
		Prefix_Tree test = new Prefix_Tree();
		test.insert("waterpokemon");
		test.insert("");
		test.insert("water");
		test.insert("water");
		List<Candidate> stuff = test.prefix_lookup("wat");
		assertEquals(stuff.get(0).getWord(), "water");
		assertEquals(stuff.get(1).getWord(), "waterpokemon");
	}
	
	@Test
	public void test4() {
		Prefix_Tree test = new Prefix_Tree();
		test.insert("waterpokemon");
		test.insert("");
		test.insert("water");
		test.insert("water");
		List<Candidate> stuff = test.prefix_lookup("waterp");
		assertEquals(stuff.size(), 1);
		assertEquals(stuff.get(0).getWord(), "waterpokemon");
	}
}
