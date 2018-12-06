package susanna.zoo;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CageTest {
	static Cage<Rhino> firstRhinoCage;
	static Cage<Zebra> firstZebraCage;
	@BeforeAll
	static void inizializer() {
		firstRhinoCage = new Cage<>(3);
		firstZebraCage = new Cage<>(2);
	}
	
	@Test
	void idFirst() {
		assertEquals(1, firstRhinoCage.getId());
		assertEquals(2, firstZebraCage.getId());
	}
/*
  scritto da me ma ho il problema che funziona
  solo quando è il primo test perchè altrimenti 
  prende anche le altre gabbie e id risulta sfasato rispetto alle previsione
	@Test
	void idCorrect() {
		Cage c1 = new Cage(4);
		assertEquals(1,c1.lastId);
		Cage c2 = new Cage(8);
		assertEquals(2,c2.lastId);
		Cage c3 = new Cage(4);
		assertEquals(3,c3.lastId);
		Cage c4 = new Cage(4);
		assertEquals(4,c4.lastId);
	} */
	
	@Test
	void tooMuchAnimals() {                         
		Cage c = new Cage(3);                     
		Rhino bill = new Rhino("Bill");            
		Rhino bob = new Rhino("Bob");              
		Rhino carl = new Rhino("Carl");             
		c.add(bill);                                
		assertEquals(true,c.add(bill));             
		c.add(bob);                                
		assertEquals(true,c.add(bob));
		c.add(carl);
		assertEquals(false,c.add(carl));
	} 
	
	
	/*Alternativa scritta dal prof
	  @Test
	  void tooMuchAnimals() {
	     Cage<Rhino> cage = new Cage<>(2); 
	     assertTrue(cage.add(new Rhino("a"))); 
	     assertTrue(cage.add(new Rhino("b"))); 
	     assertTrue(cage.add(new Rhino("c")));
	     }
	 */
	
	
	
	@Test
	void addAndRemove() {
		Cage c = new Cage(2);
		Rhino bill = new Rhino("Bill");
		Rhino bob = new Rhino("Bob");
		Rhino carl = new Rhino("Carl");
		c.add(bill);
		c.add(bob);
		c.remuve("Bill");
		assertEquals(Optional.of(bill),c.remuve("Bill"));
		c.remuve("Carl");
		assertEquals(Optional.empty(),c.remuve("Carl"));
	} 
	
	/*
	 Alternativa scritta dal prof
	@Test
	void addAndRemove() {
		Cage<Rhino> cage = new Cage<>(2);
		assertTrue(cage.add(new Rhino("a")));
		Optional<Rhino> rhino = cage.remuve("a");
		assertTrue(rhino.isPresent());                 //mi chiedo se l'animale è presente in optional non nella gabbia da dove ovviamente l'ho tolto
		assertEquals("a", rhino.get().getNome());
	} 
	*/
	
	@Test
	void removeNegative() {
		Cage c = new Cage(2);
		Rhino bill = new Rhino("Bill");
		assertEquals(Optional.empty(),c.remuve("Bill"));
	}
	
	/*
	 Alternativa scritta dal prof
	@Test
	void removeNegative() {
		Cage<Rhino> cage = new Cage<>(2);
		Optional<Rhino> rhino = cage.remuve("b");
		assertFalse(rhino.isPresent());
	} 
	*/
}
