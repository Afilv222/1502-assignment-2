package comp1502.assignment;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
class ElevatorBankTest {

	@Test
	void TestingElevator() {
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
}
