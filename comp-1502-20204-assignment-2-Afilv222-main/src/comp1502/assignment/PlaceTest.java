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
		
	}
	
	@Test
	void testEnterElevator(){
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
	
	}
	
	@Test
	void testExitElevator(){
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
		
		p.exit();
		assertFalse(p.hasPerson());
		assertNull(p.getPerson());
		
		assertEquals("Test-Nobody",p.toString());
	}
	
	@Test
	void testCall() {
		Person personOnFloor = new Person("Afil");
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",personOnFloor));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		e.call(floors.get(2));
		assertEquals(floors.get(2), e.getDestinationFloor());
	}
	
	@Test
	void testMoveUp() {
		Person personOnFloor = new Person("Afil");
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",personOnFloor));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		
		e.call(floors.get(2));
		e.move();
		assertTrue(e.isMoving());
		assertEquals(floors.get(1), e.getCurrentFloor());
	}
	
	@Test
	void testMoveUpStops() {
		Person personOnFloor = new Person("Afil");
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",personOnFloor));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		
		e.call(floors.get(2));
		e.move();
		e.move();
		assertEquals(floors.get(2), e.getCurrentFloor());
		assertFalse(e.isMoving());
		
	}
	
	@Test
	void testMoveDown() {
		Person personOnFloor = new Person("Afil");
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",personOnFloor));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		
		e.call(floors.get(2));
		e.move();
		e.move();
		e.call(floors.get(0));
		assertTrue(e.isMoving());
		e.move();
		assertEquals(floors.get(1), e.getCurrentFloor());
	}
	
	@Test
	void testMoveDownStops() {
		Person personOnFloor = new Person("Afil");
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",personOnFloor));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		
		e.call(floors.get(2));
		e.move();
		e.move();
		e.call(floors.get(1));
		e.move();
		e.move();
		assertEquals(floors.get(1), e.getCurrentFloor());
		assertFalse(e.isMoving());
	}
	
	@Test 
	void testToStringWithoutPersonOnFloor() {
		String expectedName = "Test";
		Floor f  = new Floor(expectedName,null);
		assertEquals(expectedName+"-Nobody", f.toString());
	}
	
	@Test 
	void testToStringWithPersonOnFloor() {
		Person personOnFloor = new Person("Afil");
		String expectedName = "Test";
		Floor f  = new Floor(expectedName,personOnFloor);
	
		f.arrive(personOnFloor);
		assertEquals(f.getName()+"-"+personOnFloor.getName(), f.toString());
	}
	
}
