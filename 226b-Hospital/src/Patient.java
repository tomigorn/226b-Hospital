import java.util.ArrayList;

public final class Patient extends Human{
    //==============================================
    //Variables
    private String sickness = "";
    private ArrayList<Staff> staffTreatingThisPatient = new ArrayList<Staff>();

    public Patient(String name) {
	setName(name);
	
	System.out.println("Hi " + super.getName() + "\nTell us, what's wrong? Are you sick?\n");
    }
    
    public Patient() {
	
    }

    //==============================================
    //Methods
    @Override
    public void tellStatus() {
	if(!sickness.equals("")) {
	    System.out.println("I'm here for the following reason: " + sickness);
	} else {
	    System.out.println("I was successfully healed and I'm on my way out.");
	}
    }
    

    public void assignStaff(Staff staff) {
	System.out.println("I'm now being looked after by " + staff.getName());
	staffTreatingThisPatient.add(staff);
    }

    public void getWorse() {
	System.out.println("I'm suddenly feeling worse. Please help.");
    }
    
    public void getWell() {
	System.out.println("I was here for the following reason:\n" + getSickness() + "\nI've been successfully healed by these people");
	setSickness("");
    }
    
    
    //==============================================
    //Getters & Setters
    public String getSickness(){
	return sickness;
    }
    
    public void setSickness(String sickness){
	this.sickness = sickness;
    }
    
}
