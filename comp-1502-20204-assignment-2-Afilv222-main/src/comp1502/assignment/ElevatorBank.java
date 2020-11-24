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
	 * @param elevator euqal to the instance varibale elevator
	 */
	public ElevatorBank(ArrayList<Elevator> elevators) {
		this.listOfElevators = elevators;
	}
	
	
	
	public void call(Floor floor) {
		int currentSmallestIndex = 0; 
	
		for(int i = 0; i < listOfElevators.size(); i++) {
			
			if(listOfElevators.get(i).distance(floor) < listOfElevators.get(currentSmallestIndex ).distance(floor)) {
				currentSmallestIndex = i;
			}
	
		}
		
		listOfElevators.get(currentSmallestIndex).call(floor);
	}
	
	public void move() {
		for(Elevator e :listOfElevators) {
			e.move();
		}
	}
	
	public String toString() {
		String listOfElevators = "";
	
			for(Elevator e:elevators) {
				listOfElevators += ""+ e + " Elevator on floor: " + e.getCurrentFloor() + " ";
			
			}
		
		return listOfElevators.trim();
	}
}
