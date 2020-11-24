package comp1502.assignment;
import java.util.List;
import java.util.ArrayList;
public class ElevatorBank {

	
	private List<Elevator> elevators = new ArrayList<Elevator>();
	private Elevator elevator; 
	 
	
	public ElevatorBank(ArrayList<Elevator> elevators) {
		this.elevators = elevators;
	}
	
	
	
	public void call(Floor floor) {
		int currentSmallestIndex = 0; 
		
		for(int i = 0; i < elevators.size(); i++) {
			
			if(elevators.get(i).distance(floor) < elevators.get(currentSmallestIndex ).distance(floor)) {
				currentSmallestIndex = i;
			}
	
		}
		 elevators.get(currentSmallestIndex).call(floor);
		
	}
	
	public void move() {
		
	}
	
	public String toString() {
		//return elevators + " " +elevator.getCurrentFloor();
		return elevators + "";
	}
}
