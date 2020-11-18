package comp1502.assignment;

public class Place { 
	private Person person; 
	
	
	
	public Place(Person person) {
		this.person = person; 
	}
	/**
	 * @return the waiter
	 */
	public Person getPersonWaiting() { // Change method name
		return person;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasPersonWaiting() { // Change method name
		return person != null;
		
	}
	
	public void arrive(Person newPerson) { // Change method name
		person = newPerson;
	}
	
	public Person depart() { // Change method name
		Person departer = person;
		person = null;
		return departer;
	}
	
	
	public String toString() {
		return "";	
	}
}
