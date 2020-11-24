package comp1502.assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FloorTest {

	@Test
	void testConstructor() {
		String expectedName = "Test";
		Floor f  = new Floor(expectedName,null);
		assertEquals(expectedName, f.getName());
		assertNull(f.getPerson());
		assertFalse(f.hasPerson());
	}
	
	@Test
	void testArrive() {
		Floor f  = new Floor("Test",null);
		Person p = new Person("Tester");
		f.arrive(p);
		assertTrue(f.hasPerson());
		assertEquals(p, f.getPerson());
	}
	
	@Test 
	void testToStringWithoutPerson() {
		String expectedName = "Test";
		Floor f  = new Floor(expectedName,null);
		assertEquals(expectedName+"-Nobody", f.toString());
	}
	
	@Test 
	void testToStringWithPerson() {
		String expectedName = "Test";
		String personName = "Alice";
		Floor f  = new Floor(expectedName,null);
		Person p = new Person(personName);
		f.arrive(p);
		assertEquals(expectedName+"-"+personName, f.toString());
	}
	
	@Test
	void testDepart() {
		Floor f  = new Floor("Test",null);
		Person p = new Person("Tester");
		f.arrive(p);
		Person exiter = f.exit();
		assertFalse(f.hasPerson());
		assertNull(f.getPerson());
		assertEquals(p, exiter);
	}

}
