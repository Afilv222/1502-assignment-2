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
		p.arrive(personOnFloor);
		assertEquals(personOnFloor.getName(),p.getPersonWaiting().getName());

		//		assertEquals(elevatorName, e.getName());

		//		assertTrue(place.hasPersonWaiting());
		
	}
	
	@Test
	void testSomething(){
		
	}
}
