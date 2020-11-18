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
		
		Elevator e = new Elevator("Simulation Elevator", floors,null);
		//Person p = new Person("Persephony");
		Building b = new Building("Simulation Building", floors, e, personOnFloor );
		
		for (int i = 1; i <= 100; i++) {
			System.out.println("Step " + i);
			System.out.println(b.getBuildingVisualization());
			b.simulate();
		}
		

	}

}
