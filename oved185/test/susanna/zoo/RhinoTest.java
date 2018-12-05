package susanna.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RhinoTest {

	@Test
	void billIsBill() {
	 Rhino Bill = new Rhino("Bill");
	 assertEquals("Bill", Bill.getName());
	 
	}

}
