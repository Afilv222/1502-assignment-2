package comp1502.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlaceTest {
	
	
	@Test
	void testConstructor() {
		Person personOnFloor = new Person("Shreshth");
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",personOnFloor) );
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String elevatorName = "Test";
		
		Place p = new Elevator(elevatorName, floors,null); // Talking to both classes
		
		assertEquals("[1-Shreshth, 2-Nobody, 3-Nobody]",floors.toString());
		
		
		p.arrive(personOnFloor);
		assertEquals(personOnFloor.getName(),p.getPerson().getName());
		//assertEquals(floors.toString(),"");
		//		assertEquals(elevatorName, e.getName());

		//		assertTrue(place.hasPersonWaiting());
		
	}
	
	@Test
	void testEnter(){
		Person personOnFloor = new Person("Afil");
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",personOnFloor) );
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		assertTrue(place.hasPerson());
		
		String elevatorName = "Test";
		
		Place p = new Elevator(elevatorName, floors,null);
		p.arrive(personOnFloor);
		assertTrue(p.hasPerson());
		assertEquals("Test-Afil", p.toString());
		assertEquals("[1-Shreshth, 2-Nobody, 3-Nobody]",p.toString());
	
	}
}
