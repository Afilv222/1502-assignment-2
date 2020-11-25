package comp1502.assignment;

import java.util.ArrayList;

public class Simulation {

	public static void main(String[] args) {
		Person personOnFloor = new Person("Shreshth");
		Place  place = new Place(personOnFloor);
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("A",personOnFloor));
		floors.add(new Floor("B",null));
		floors.add(new Floor("C",null));
		floors.add(new Floor("D",null));
		
		///Elevator e = new Elevator("Simulation Elevator", floors,null);
		
		ArrayList<Elevator> elevators = new ArrayList<Elevator>();
		elevators.add(new Elevator("Ele1",floors,null,floors.get(1)));
		elevators.add(new Elevator("Ele2",floors,null,floors.get(3)));
		ElevatorBank EB = new ElevatorBank(elevators);
		
		//Person p = new Person("Persephony");
		Building b = new Building("Simulation Building", floors, EB, personOnFloor );
		
		for (int i = 1; i <= 100; i++) {
			System.out.println("Step " + i);
			System.out.println(b.getBuildingVisualization());
			b.simulate();
		}
		

	}

}
