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
	 * Sets a person waiting on a floor or
	 * The person on the floor should now enter the elevator. 
	 * @param newPerson equals the person instance variable 
	 */
	public void arrive(Person newPerson) { 
		person = newPerson;
	}
	
	/**
	 *  When the person leaves the elevator or floor the elevator or floor will no longer have someone on board.
	 *  Updates the person in the elevator or floor to null , meaning the person in the elevator or floor is no longer there.
	 *  Also the person that exited the elevator or floor should be the same person that entered. 
	 * @return personInElevator on the floor.
	 */
	public Person exit() { 
		Person departer = person;
		person = null;
		return departer;
	}
	
	/**
	 * The super class(Place) will return the object into String which will display ther
	 */
	public String toString() {
		if (this.person == null) {
			return "-Nobody";
		} 
		return "-" + person.getName();
		
		
	}
}
