import java.util.ArrayList;
import java.util.Scanner;


public final class Doctor extends Staff{
    //==============================================
    //Variables   
    private ArrayList<Patient> patientsBeingTreated = new ArrayList<Patient>();
    private ArrayList<Patient> treatedPatients = new ArrayList<Patient>();

    //==============================================
    //Constructors   
    public Doctor(String name) {
	super(name);
	setPosition("Doctor");
    }
    public Doctor() {
	System.out.println("What's the doctor's name?");
	setName(new Scanner(System.in).nextLine());
	System.out.println(getName() + " has been added as a new Doctor.");
    }
    
    //==============================================
    //Methods
    @Override
    public void tellStatus(){
	System.out.println("I'm a Doctor. I help and heal patients.");
	
    }

    public void takeNewPatient(Patient patient) {
	System.out.println("I'll be treating " + patient.getName() + " from now on.");
	patientsBeingTreated.add(patient);
    }
    
    public void healPatient(Patient patient) {
	//patient.
	System.out.println("Patient " + patient.getName() + " was here for the following reason:\n" + patient.getSickness() + "\nI've successfully healed this patient.");
	
    }
}
