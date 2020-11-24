package comp1502.assignment;

import java.util.ArrayList;

public class Elevator extends Place{

	private enum Direction {MOVING_UP, MOVING_DOWN, HOLDING}; 
	
	private String name;
	private ArrayList<Floor> floors;
	//private ArrayList<Elevator> currentElevator; 
	private Floor currentFloor;
	private Floor destinationFloor;

	
	private Person rider;
	
	private Direction elevatorDirection;
	
	public Elevator(String name, ArrayList<Floor> floors,Person rider) {
		super(rider);
		this.name = name;
		this.floors = floors;
		this.currentFloor = floors.get(0);
		this.destinationFloor = null;
		this.rider = rider; // used to be null
		this.elevatorDirection = Direction.HOLDING;
		
	}
	
	public Elevator(String name, ArrayList<Floor> floors,Person rider,Floor setElevatorOnFloor) {
		super(rider);
		this.name = name;
		this.floors = floors;
		this.currentFloor = setElevatorOnFloor;
		this.destinationFloor = null;
		this.rider = rider; // used to be null
		this.elevatorDirection = Direction.HOLDING;
		
	}
	
	public String getName() {
		return name;
	}

	public Floor getCurrentFloor() {
		return currentFloor;
	}

	public Floor getDestinationFloor() {
		return destinationFloor;
	}
	
	public boolean isMoving() {
		return elevatorDirection != Direction.HOLDING;
	}

	public boolean isOnFloor(Floor floor) {
		return currentFloor.equals(floor);
		
	}

	public void call(Floor floor) {
		this.destinationFloor = floor;
		
		setElevatorDirection();
	}
	
	private void setElevatorDirection(){
		
		int destinationIndex = floors.indexOf(destinationFloor);  
		int currentIndex = floors.indexOf(currentFloor); 
		
		if (destinationIndex > currentIndex) {
			elevatorDirection = Direction.MOVING_UP;
		} else if (destinationIndex < currentIndex) {
			elevatorDirection = Direction.MOVING_DOWN;
		} else {
			elevatorDirection = Direction.HOLDING;
		}
	}
	
	public void move() { 
		if (elevatorDirection == Direction.HOLDING) {
			return;
		} else if (elevatorDirection == Direction.MOVING_UP) {
			int currentIndex = floors.indexOf(currentFloor);
			currentFloor = floors.get(currentIndex + 1);
		} else if (elevatorDirection == Direction.MOVING_DOWN) {
			int currentIndex = floors.indexOf(currentFloor);
			currentFloor = floors.get(currentIndex - 1);
		}
		
		stopIfArrived();
	}
	
	private void stopIfArrived() {
		if (currentFloor.equals(destinationFloor)) {
			elevatorDirection = Direction.HOLDING;
		}
	}
	
	
	public int distance(Floor givenFloor) {
		int distance =0;
		
		distance = floors.indexOf(currentFloor) - floors.indexOf(givenFloor);
					// 0 - 3 = -3
		if(distance < 0) {
			 distance *= (-1);
		}
		
		
		return distance; 
	}
	
	
	@Override
	public String toString() {
		return name + super.toString();
	}

}
