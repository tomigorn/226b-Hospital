import java.util.ArrayList;
import java.util.Scanner;

public final class Nurse extends Staff{
    //==============================================
    //Variables
    private ArrayList<Patient> patientsBeingTreated = new ArrayList<Patient>();
    private ArrayList<Patient> treatedPatients = new ArrayList<Patient>();

    //==============================================
    //Constructors   
    public Nurse(String name) {
	super(name);
	setPosition("Nurse");
    }
    public Nurse() {
	System.out.println("What's this nurse's name?");
	setName(new Scanner(System.in).nextLine());
	System.out.println(getName() + " has been added as a new nurse.");
    }
    
    //==============================================
    //Methods
    @Override
    public void tellStatus(){
	System.out.println("I'm a nurse. I'm here to help the Doctors.");
    }

    
    
    
    
}
