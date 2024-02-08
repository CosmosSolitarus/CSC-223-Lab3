import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class LinkedEquivalenceClassTest {

	@Test
	void testGeneral() {
		Comparator<Integer> c = new Comparator<Integer>()
		{public int compare(Integer x, Integer y)
		{return x%2 == y % 2 ? 0:1;}
		};
		LinkedEquivalenceClass<Integer> LEC =new LinkedEquivalenceClass<Integer>(c);
		assertTrue(LEC.isempty());
		assertFalse(LEC.contains(3));
			for(int i=0; i<7;i++) {
				LEC.add(i);
			}
		assertTrue(LEC.demoteAndSetCanonical(1));
		assertEquals(1,LEC.canonical());
		}
	}