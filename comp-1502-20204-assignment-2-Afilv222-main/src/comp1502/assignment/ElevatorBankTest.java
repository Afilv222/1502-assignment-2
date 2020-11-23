package comp1502.assignment;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
class ElevatorBankTest {

	@Test
	void callingElevator() {
		Person personOnFloor = new Person("Shreshth"); 
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		
		floors.add(new Floor("1",personOnFloor) );
		floors.add(new Floor("2",null));
		floors.add(new Floor("3",null));
		
		//Elevator elevator = new Elevator();
		ArrayList<Elevator> elevators = new ArrayList<Elevator>();
		elevators.add(new Elevator("Ele1",floors,null));
		elevators.add(new Elevator("Ele2",floors,null));

		ElevatorBank EB = new ElevatorBank(elevators);
		
		EB.call(floors.get(0));
		
		assertEquals(,);
	}
}
