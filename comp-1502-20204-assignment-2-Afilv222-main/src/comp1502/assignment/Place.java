package comp1502.assignment;
/**
 * Place class , is super class of Elevator and Floor which provides 
 * a concept of a location where a person can wait. But can also tell Person 
 * to enter or exit Elevator same thing goes for Floor.
 * @author afil_Vidyasagar
 *
 */
public class Place { 
	private Person person; 
	
	
	/**
	 * Created constructor which initialize the instance variables 
	 * @param person equal to the instance variable person
	 * 
	 */
	public Place(Person person) {
		this.person = person; 
	}
	
	
	/**
	 * 
	 * Gets the person.  
	 * @return the person
	 */
	public Person getPerson() { 
		return person;
	}
	
	/**
	 * Checks if the elevator or floor has person currently riding the elevator or waiting on the floor.
	 * @return
	 */
	public boolean hasPerson() {
		return person != null;
		
	}
	
	/**
	 * The person on the floor should now enter the elevator.
	 * @param person
	 * @return person equal to personInElevator.
	 */
	public void arrive(Person newPerson) { 
		person = newPerson;
	}
	
	public Person exit() { 
		Person departer = person;
		person = null;
		return departer;
	}
	
	
	public String toString() {
		if (this.person == null) {
			return "-Nobody";
		} 
		return "-" + person.getName();
		
		
	}
}
