import java.util.ArrayList;
import java.util.Scanner;

public final class Assistant extends Staff{
    //==============================================
    //Variables   
    private ArrayList<Patient> patientsBeingTreated = new ArrayList<Patient>();
    private ArrayList<Patient> treatedPatients = new ArrayList<Patient>();

    //==============================================
    //Constructors
    public Assistant() {
	System.out.println("What's the assistant's name?");
	setName(new Scanner(System.in).nextLine());
	System.out.println(getName() + " has been added as a new assistant.");
    }
    
    
    public Assistant(String name) {
	super(name);
	setPosition("Assistant");
    }
    
    public Assistant(String name, String sex) {
	super(name, sex);
	setPosition("Assistant");
    }
    //==============================================
    //Methods
    @Override
    public void tellStatus(){
	System.out.println("I'm a assistant. I help the Doctors and help prepare patients.");
    }

    public void helpPatient(Patient patient) {
	System.out.println("I'll be helping " + patient.getName() + " from now on.");
	patientsBeingTreated.add(patient);
    }
    
    public void stopHelpingPatient(Patient patient) {
	//patient.
	System.out.println("I stopped helping " + patient.getName() + ".");
    }
}
