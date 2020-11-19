package comp1502.assignment;

public class Place { 
	private Person person; 
	
	
	
	public Place(Person person) {
		this.person = person; 
	}
	/**
	 * @return the waiter
	 */
	public Person getPerson() { 
		return person;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasPerson() {
		return person != null;
		
	}
	
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
