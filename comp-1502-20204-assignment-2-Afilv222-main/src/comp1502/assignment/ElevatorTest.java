package comp1502.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ElevatorTest {

	@Test
	void testConstructor() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		assertEquals(name, e.getName());
		assertEquals(floors.get(0), e.getCurrentFloor());
		assertNull(e.getDestinationFloor());
		assertNull(e.getPerson());
		assertFalse(e.isMoving());
		assertTrue(e.isOnFloor(floors.get(0)));
		assertFalse(e.isOnFloor(floors.get(1)));
		assertFalse(e.isOnFloor(floors.get(2)));
	}
	
	@Test
	void testEnter() {
		Person p = new Person("Tester");
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",p));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		
		e.arrive(p);
		assertTrue(e.hasPerson());
		assertEquals(p, e.getPerson());
	}
	
	@Test
	void testExit() {
		Person p = new Person("Tester");
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",p));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		
		e.arrive(p);
		Person exiter = e.exit();
		assertFalse(e.hasPerson());
		assertNull(e.getPerson());
		assertEquals(p, exiter);
	}
	
	@Test
	void testCall() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		e.call(floors.get(2));
		assertEquals(floors.get(2), e.getDestinationFloor());
	}
	
	@Test
	void testMoveUp() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null)); 
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		
		e.call(floors.get(2)); // floor 3
		e.move();
		assertTrue(e.isMoving());
		assertEquals(floors.get(1), e.getCurrentFloor());
	}
	
	@Test
	void testMoveUpStops() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
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
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
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
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		floors.add(new Floor("4",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		
		e.call(floors.get(3));
		e.move();
		e.move();
		e.call(floors.get(1));
		e.move();
		e.move();
		assertEquals(floors.get(1), e.getCurrentFloor());
		assertFalse(e.isMoving());
	}
	
	@Test 
	void testToStringWithoutPerson() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		assertEquals(name+"-Nobody", e.toString());
	}
	
	@Test 
	void testToStringWithPerson() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1",null));
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors,null);
		String personName = "Alice";
		Person p = new Person(personName);
		e.arrive(p);
		assertEquals(name+"-"+personName, e.toString());
	}
	
	@Test
	void testDistanceMethod() {
		Person personOnFloor = new Person("Shreshth"); 
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		
		floors.add(new Floor("1",personOnFloor) );
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		floors.add(new Floor("4",null));
		
		Elevator elevator = new Elevator("Test",floors,null);
		Elevator elevator2 = new Elevator("Test2",floors,null);
		
		assertEquals(3,elevator.distance(floors.get(3)));
		assertEquals(2,elevator.distance(floors.get(2)));
		
	}
	
}
