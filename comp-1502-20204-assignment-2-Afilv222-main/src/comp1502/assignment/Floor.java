package comp1502.assignment;

public class Floor extends Place{

	private String name;
	//private Person waiter;
	
	
	public Floor(String name,Person waiter) {
		super(waiter);
		this.name = name;
		//this.waiter = waiter; // used to be null
		
	}

	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
	return name + super.toString(); 
	}


}
