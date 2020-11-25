package comp1502.assignment;
import java.util.List;
import java.util.ArrayList;

/**
 *ElevatorBank class should be able to allow several Elevators to serve
 *the same set of floors. The ElevatorBank will generate multiple elevators 
 *which will be able to move through out the building and floors. 
 * @author afil_Vidyasagar
 *
 */
public class ElevatorBank {

	
	private List<Elevator> listOfElevators = new ArrayList<Elevator>();
	private Elevator elevator;
	
	/**
	 * Created constructor which initialize the instance variables 
	 * @param elevators equals to the instance variable listOfElevators
	 */
	public ElevatorBank(ArrayList<Elevator> elevators) {
		this.listOfElevators = elevators;
	}
	
	
	/**
	 * The call method will determine which elevator is the nearest to the floor that was called. 
	 * The least amount of distance from the floor should be the elevator called. 
	 * @param floor
	 */
	public Elevator call(Floor floor) { // should be return elevator 
		int currentSmallestIndex = 0; 
	
		for(int i = 0; i < listOfElevators.size(); i++) {
			
			if(listOfElevators.get(i).distance(floor) < listOfElevators.get(currentSmallestIndex ).distance(floor)) {
				currentSmallestIndex = i;
			}
	
		}
		
		Elevator e = listOfElevators.get(currentSmallestIndex);
		e.call(floor);
		return e;
	}
	
	/**
	 * The move method will move every elevator that is created.
	 */
	public void move() {
		for(Elevator e :listOfElevators) {
			e.move();
		}
	}
	
	public boolean isOnFloor(Floor floor) {
		return elevator.isOnFloor(floor);
	}
	
	public Floor getDestinationFloor() {
		return elevator.getDestinationFloor();
	}
	/**
	 * This method should print out all the elevators and which floor each elevator is on. 
	 */
	public String toString() {
		String listOfElevator = "";
	
			for(Elevator e:listOfElevators) {
				listOfElevator += ""+ e + " Elevator on floor: " + e.getCurrentFloor() + " ";
			}
		
		return listOfElevator.trim();
	}
}
