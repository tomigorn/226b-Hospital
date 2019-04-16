import java.util.ArrayList;
import java.util.Scanner;


public class Hospital {
    Scanner sc = new Scanner(System.in);
    
    //==============================================
    //Variables
    public String name = "";
    private ArrayList<Staff> staffWorkingHere = new ArrayList<Staff>();
    
    //==============================================
    //Constructors
    public Hospital() {
	
	//intro
	
	System.out.println("---------the hospitals-----------");
	System.out.println("This is a simulation of hospitals");
	System.out.println("=================================");
	
	//first hospital name
	
	System.out.println("\n=> Whats the name of the hospital you're going to visit first?");
	setName( sc.nextLine() );
	System.out.println("-- Welcome to " + name + ".");
	
	//adding hospital staff
	
	System.out.println("\n=> now let's add some staff:");
	addStaff();
	
	//adding patients to the first hospital
	
	System.out.println("=> After adding staffmembers let's add some patients.");
	addPatients();
	
	/* action part
	 *  
	 * one can do the following things:
	 * - adding/removing/altering staff members
	 * - adding/removing/altering hospital patients
	 * - changing the hospital's name
	 * - visit a different hospital
	 * - exit the simulation	*/
	System.out.println("\nPatients have been added.\n=> What do you want to do now?\n   1) act as a staff member\n   2) act as a patient\n   3) change this hospital's name\n   4) go to a different hospital\n      99) exit the simulation");
	action();
    }

    
    
    //==============================================
    //==============================================
    //main
    public static void main(String[] args) {
	new Hospital();
    }

    //==============================================
    //==============================================
    //Methods
    
    //==============================================
    //set the name of the hospital
    public void setName(String name) {
	this.name = name;
    }
    

    //==============================================
    //add staff to the hospital
    public void addStaff(){	
	System.out.println("=> There are Doctors, Nurses and Assistants. What's the new staffmembers position?");
	System.out.println("             ^^^^^^^  ^^^^^^     ^^^^^^^^^^");
	
	boolean addingMoreStaff = true;
	boolean addingSuccessful = false;
	boolean addingPossible = true;
	
	do{
	    if(addingSuccessful) {
		System.out.println("=> Who are you going to add now?   (Doctor/ Nurse/ Assistent)");
	    }
	    addingSuccessful = false;
	    addingPossible = true;
	    
	    String staffPosition = "";
	    staffPosition = sc.nextLine();
	    staffPosition = staffPosition.toLowerCase();
	    
	    String currentName = "";
	    String currentPosition = "";
	    String currentSex = "";
	    
	    switch(staffPosition) {
	    
	    //case Doctor
	    
	    case "1":
	    case "doctor":
	    case "doc":
	    case "d":
		System.out.println("=> What's this Doctor's name?");
		currentName = sc.nextLine();
		currentPosition = "Doctor";
		
		System.out.println("\n=> What's this Doctor's sex?");
		currentSex = normalizeSexType();
		
		//checks if a Nurse with this name already works at the hospital
		addingPossible = !staffAlreadyExists(currentPosition, currentName, currentSex);
		
		if(addingPossible) {
		    staffWorkingHere.add( new Doctor(currentName) );
		    System.out.println("-- Dr. " + currentName + " has been added.");
		}else {
		    System.out.println("\n-- error:\n   Dr. " + currentName + " already works in " + this.name + "!");
		}
		addingSuccessful = true;
		break;
	    
		
	    //case Nurse
		
	    case "2":
	    case "nurse":
	    case "n":
		currentPosition = "Nurse";
		
		System.out.println("=> What's the nurse's name?");
		currentName = sc.nextLine();
		
		System.out.println("=> What's the nurse's sex?");
		currentSex = normalizeSexType();
		
		addingPossible = staffAlreadyExists(currentPosition, currentName, sex);//checks if a Nurse with this name already works at the hospital
		String salutation = "";
		if(addingPossible) {
		    staffWorkingHere.add( new Nurse(currentName) );
		    for(Staff staffmember: staffWorkingHere) {
			System.out.println("Test ");
		    }
		    System.out.println("-- " + salutation + " " + input + " has been added to the staff of " + this.name + ".");
		}else {
		    System.out.println("\n-- error:\n   " + salutation + " " + input + " already works here as a nurse!");
		}
	    	addingSuccessful = true;
	    	break;
	    
	    
	    case "3":
	    case "assistent":
	    case "a":
		System.out.println("=> What's the assistant's name?");
		input = "";
		input = sc.nextLine();
	    	//addingPossible = staffAlreadyExists("Assistant", input);//checks if a Nurse with this name already works at the hospital
		
		if(addingPossible) {
		    staffWorkingHere.add( new Assistant(input) );
		}else {
		    System.out.println("\n-- error:\n   This assistant already works here!");
		}
	    	addingSuccessful = true;
	    	break;
	    
	    default:
		System.out.println("-- Whoops. That's not the expected input. Please try again.");
	    }
	
	    if(addingSuccessful) {
        	    System.out.println("\n=> Should we add somebody else? (y/n)" );
        	    String moreToAdd = sc.nextLine();
        	    moreToAdd = moreToAdd.toLowerCase();
        	
        	    switch(moreToAdd) {
        	    case "1":
        	    case "y":
        	    case "yes":
        	    case "ja":
        		break;
        	    case "0":
        	    case "n":
        	    case "no":
        	    case "nein":
        		addingMoreStaff = false;
        		break;
        	    default:
        		System.out.println("=> yes or no?");
        	    }
	    }
	}while(addingMoreStaff);
    }
    
    
    //==============================================
    // checking if the staffmember already exists
    private boolean staffAlreadyExists(String position, String name, String sex) {
	boolean addingPossible = true;
	for(Staff staffmember: staffWorkingHere) {
	    if(staffmember.getPosition().equals(position) && staffmember.getName().equals(name) && staffmember.getSex().equals(sex)) {
		addingPossible = false;
	    }
	}
	return addingPossible;
    }
    
    
    //==============================================
    //what's this staffmember's salutation?
    private String staffSalutation(String position, String name, String sex) {
	String salutation = "";
	for(Staff staffmember: staffWorkingHere) {
	    if(staffmember.getPosition().equals(position) && staffmember.getName().equals(name) && staffmember.getSex().equals(sex)) {
		salutation = staffmember.getSalutation();
	    }
	}
	return salutation;
    }

    
    //==============================================
    //adding patients to the hospital
    public void addPatients() {
	System.out.println("=> Whats the patient's name?");

    }
    
    
    //==============================================
    //filter out sex types, so that only the allowed ones are left
    //either male or female
    public String normalizeSexType() {
	boolean validSexType = false;
	String sex = "";
	
	do {
	    sex = sc.nextLine();
	    sex.toLowerCase();
	    
	    switch(sex) {
	    case "male":
	    case "man":
	    case "boy":
	    case "boi":
	    case "mr":
	    case "mister":
	    case "sir":
	    case "husband":
	    case "mann":
	    case "männlich":
		
		sex = "male";
		validSexType = true;
		
	    case "female":
	    case "woman":
	    case "wife":
	    case "girl":
	    case "frau":
		
		sex = "female";
		validSexType = true;
		
	    default:
		System.out.println("-- invalid sex type\n\n=> please try again");
	    }
	}while(!validSexType);
	
	return sex;
    }
    
    
    //==============================================
    //actions the user can perform after adding members of the hospital
    //changing between actions
    public void action() {
	String action = "";
	
	while(sc.hasNextLine()) {
	    boolean inputValid = true;
	    action = sc.nextLine();
	    action = action.toLowerCase();
	    
	    switch(action) {
	    case "1":
		break;
	    case "2":
		break;
	    case "3":
		break;
	    case "4":
		break;
	    case "5":
		break;
	    default:
		System.out.println("");
		inputValid = false;
	    }
	    
	    
	    if(inputValid) {
		break;
	    }
	}
	System.out.println("good");
    }
}
