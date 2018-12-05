package susanna.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CageTest {

	@Test
	void idFirst() {
		Cage c = new Cage(5);
		 assertEquals(1,c.lastId);
	}

	@Test
	void idSecond() {
		Cage c = new Cage(5);
		Cage c1 = new Cage(5);
		 assertEquals(2,c1.lastId);
	}
}
