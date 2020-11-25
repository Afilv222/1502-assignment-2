package comp1502.assignment;

public class Person {
	
	private String name; 
	
	/**
	 * @param name
	 */
	public Person(String name) {
		this.name = name;  
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public void setDestination(Floor floor,Elevator elevator) {
		elevator.call(floor);
	}
}
