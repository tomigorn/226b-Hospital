import java.util.ArrayList;

public final class Patient extends Human{
    //==============================================
    //Variables
    private String sickness = "";
    private ArrayList<Staff> staffTreatingThisPatient = new ArrayList<Staff>();

    
    //==============================================
    //Constructors
    public Patient() {
	
    }
    
    
    public Patient(String name) {
	super(name);
	
	System.out.println("Hi " + super.getName() + "\nTell us, what's wrong? Are you sick?\n");
    }


    public Patient(String currentName, String currentSex) {
	super(currentName, currentSex);
    }


    //==============================================
    //Methods
    @Override
    public void tellStatus() {
	if(!sickness.isEmpty()) {
	    System.out.println("I'm here for the following reason: " + sickness);
	} else {
	    System.out.println("I was successfully healed and I'm on my way out.");
	}
    }
    

    public void assignStaff(String staff) {
	System.out.println("  -- " + this.getName() + " is now beeing looked after\n     by Dr." + staff);
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
