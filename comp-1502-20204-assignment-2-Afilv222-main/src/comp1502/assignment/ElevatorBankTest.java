package comp1502.assignment;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
class ElevatorBankTest {

	@Test
	void testingElevator() {
		Person personOnFloor = new Person("Shreshth"); 
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		
		floors.add(new Floor("1",personOnFloor) );
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		floors.add(new Floor("4",null));
		
		//Elevator elevator = new Elevator();
		ArrayList<Elevator> elevators = new ArrayList<Elevator>();
		elevators.add(new Elevator("Ele1",floors,null,floors.get(1)));
		elevators.add(new Elevator("Ele2",floors,null,floors.get(3)));
		
		ElevatorBank EB = new ElevatorBank(elevators);
		
		assertEquals(elevators.get(0) + " " + "Elevator on floor: " + floors.get(1) + " " + elevators.get(1) + " " + "Elevator on floor: " + floors.get(3),EB.toString());
	}
	
	@Test
	void callingElevatorsAtDifferentDistances(){
		Person personOnFloor = new Person("Shreshth"); 
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		
		floors.add(new Floor("1",personOnFloor) ); 
		floors.add(new Floor("2",null));  // Ele1 should be here
		floors.add(new Floor("3",null));
		floors.add(new Floor("4",null)); /// Ele2 should be here
		
		//Elevator elevator1 = new Elevator("Ele1",floors,null,floors.get(1));
		//Elevator elevator2 = new Elevator("Ele2",floors,null,floors.get(3));
		ArrayList<Elevator> elevators = new ArrayList<Elevator>();
		elevators.add(new Elevator("Ele1",floors,null,floors.get(1)));
		//elevators.add(elevator1);
		elevators.add(new Elevator("Ele2",floors,null,floors.get(3)));
		
		ElevatorBank EB = new ElevatorBank(elevators);
		
		EB.call(floors.get(0));
		//EB.move();
		
		//assertFalse(elevators.get(0).isMoving());
		assertEquals(floors.get(0),elevators.get(0).getDestinationFloor());
		assertEquals(floors.get(0),elevators.get(0).getCurrentFloor());
		
		assertFalse(elevators.get(1).isMoving());
		assertNull(elevators.get(1).getDestinationFloor());
		assertEquals(floors.get(3),elevators.get(1).getCurrentFloor());
	}
}
