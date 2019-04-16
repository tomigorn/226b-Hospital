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
	System.out.println("=============================================");
	System.out.println("- - - - - - - -the hospitals- - - - - - - - -");
	System.out.println("      This is a simulation of hospitals");
	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	
	//instructions
	/*
	System.out.println("\n=> instructions:\n   at any point in the program\n   you can write these commands\n      simulation-help\n      simulation-restart\n      simulation-exit");
	System.out.println("\n=============================================");
	*/
	
	
	//first hospital name
	
	System.out.println("\n  => What's the name of the hospital\n   you're going to visit first?");
	System.out.print("  ");
	setName( sc.nextLine() );
	System.out.println("  -- Welcome to " + name);
	
	//adding hospital staff
	
	System.out.println("\n  => now let's add some staff:");
	addStaff();
	
	//adding patients to the first hospital
	
	System.out.println("  => After adding staffmembers,\n     let's add some patients.");
	addPatients();
	
	/* action part
	 *  
	 * one can do the following things:
	 * - adding/removing/altering staff members
	 * - adding/removing/altering hospital patients
	 * - changing the hospital's name
	 * - visit a different hospital
	 * - exit the simulation	*/
	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	System.out.println("  => What do you want to do now?");
	System.out.println("     1) act as a staff member");
	System.out.println("     2) act as a patient");
	System.out.println("     3) change this hospital's name");
	System.out.println("     4) go to a different hospital");
	System.out.println("    99) exit the simulation");
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
	System.out.println("     There are Doctors, nurses and assistants.");
	System.out.println("               ^^^^^^^  ^^^^^^     ^^^^^^^^^^");
	System.out.println("     What's the new staffmembers position?");
	
	boolean addingMoreStaff = true;
	boolean addingSuccessful = false;
	boolean addingPossible = true;
	
	do{
	    //if there has already someone been added before in this loop
	    if(addingSuccessful) {
		System.out.println("\n  => Who are you going to add now?\n   (Doctor, Nurse, Assistent)");
	    }
	    
	    //resetting
	    addingSuccessful = false;
	    addingPossible = true;
	    
	    String staffPosition = "";
	    System.out.print("  ");
	    staffPosition = sc.nextLine();
	    staffPosition = staffPosition.toLowerCase();
	    
	    String currentName = "";
	    String currentPosition = "";
	    String currentSex = "";
	    char shortCurrentSex = ' ';
	    String currentSalutation = "";
	    
	    
	    //big switch to choose between staff member position/ type
	    switch(staffPosition) {
	    
	    //case Doctor
	    
	    case "1":
	    case "doctor":
	    case "doc":
	    case "d":
		System.out.println("  => What's the new Doctor's name?");
		System.out.println("                             ^^^^");
		System.out.print("  ");
		currentName = sc.nextLine();
		currentPosition = "Doctor";
		
		System.out.println("  => What's the new Doctor's sex?");
		System.out.println("                             ^^^");
		currentSex = normalizeSexType();
		shortCurrentSex = currentSex.charAt(0);
		
		//checks if a Doctor with this name and sex already works at the hospital
		addingPossible = staffDoesntExistYet(currentPosition, currentName, currentSex);
		
		if(addingPossible) {
		    staffWorkingHere.add( new Doctor(currentName, currentSex) );
		    System.out.println("  -- Dr. " + currentName + " (" + shortCurrentSex + ") now works at " + this.name + ".");
		}else {
		    currentSalutation = getSalutation(currentPosition, currentName, currentSex);
		    System.out.println("  -- error:\n     Dr. " + currentName + " (" + shortCurrentSex + ") already works at " + this.name + "!");
		}
		System.out.println("--------------------------------------------");
		addingSuccessful = true;
		break;
	    
		
	    //case Nurse
		
	    case "2":
	    case "nurse":
	    case "n":
		System.out.println("  => What's the new nurse's name?");
		System.out.println("                            ^^^^");
		System.out.print("  ");
		currentName = sc.nextLine();
		currentPosition = "Nurse";
		
		System.out.println("  => What's the new nurse's sex?");
		System.out.println("                            ^^^");
		currentSex = normalizeSexType();
		
		//checks if a nurse with this name and sex already works at this hospital
		addingPossible = staffDoesntExistYet(currentPosition, currentName, currentSex);
		
		if(addingPossible) {
		    staffWorkingHere.add( new Nurse(currentName, currentSex) );
		    currentSalutation = getSalutation(currentPosition, currentName, currentSex);
		    System.out.println("  -- " + currentSalutation + " " + currentName + " is a new nurse at " + this.name + ".");
		}else {
		    currentSalutation = getSalutation(currentPosition, currentName, currentSex);
		    System.out.println("  -- error:\n     " + currentSalutation + " " + currentName + " already is a nurse at " + this.name + "!");
		}
		System.out.println("--------------------------------------------");
		addingSuccessful = true;
		break;
	    
		
	    //case assistant
	    
	    case "3":
	    case "assistent":
	    case "a":
		System.out.println("  => What's the new assistant's name?");
		System.out.println("                                ^^^^");
		System.out.print("  ");
		currentName = sc.nextLine();
		currentPosition = "Assistant";
		
		System.out.println("  => What's the new assistant's sex?");
		System.out.println("                                ^^^");
		currentSex = normalizeSexType();
		
		//checks if an assistant with this name and sex already works at this hospital
		addingPossible = staffDoesntExistYet(currentPosition, currentName, currentSex);
		
		if(addingPossible) {
		    staffWorkingHere.add( new Assistant(currentName, currentSex) );
		    currentSalutation = getSalutation(currentPosition, currentName, currentSex);
		    System.out.println("  -- " + currentSalutation + " " + currentName + " is a new assistant at " + this.name + ".");
		}else {
		    currentSalutation = getSalutation(currentPosition, currentName, currentSex);
		    System.out.println("  -- error:\n     " + currentSalutation + " " + currentName + " already is a assistant at " + this.name + "!");
		}
		System.out.println("--------------------------------------------");
		addingSuccessful = true;
		break;
	    default:
		System.out.println("  -- Whoops.\n   That's not the expected input.\n   Please try again.");
	    }
	
	    if(addingSuccessful) {
        	    System.out.println("  => Should we add somebody else? (y/n)" );
        	    System.out.print("  ");
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
        		System.out.println("  => yes or no?");
        	    }
	    }
	}while(addingMoreStaff);
	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    
    //==============================================
    // checking if the staffmember already exists
    private boolean staffDoesntExistYet(String position, String name, String sex) {
	name = name.toLowerCase();
	boolean addingPossible = true;
	
	for(Staff staffmember: staffWorkingHere) {
	    if(staffmember.getPosition().equals(position) && staffmember.getName().toLowerCase().equals(name) && staffmember.getSex().equals(sex)) {
		addingPossible = false;
	    }
	}
	
	//return true if staffmember doesn't exist yet
	return addingPossible;
    }
    
    
    //==============================================
    //what's this staffmember's salutation?
    private String getSalutation(String position, String name, String sex) {
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
	boolean addingMorePatients = true;
	boolean addingSuccessful = true;
	
	do {
	    String currentName;
	    String currentSex;
	    String currentSickness;
		
	    System.out.println("     What's the new patient's name?");
	    System.out.println("                              ^^^^ ");
	    System.out.print("  ");
	    currentName = sc.nextLine();
		
	    System.out.println("  => What's the new patient's sex?");
	    System.out.println("                              ^^^ ");
	    System.out.print("  ");
	    currentSex = sc.nextLine();
		
	    System.out.println("  => Why does this patient have to be here?");
	    System.out.println("     (sickness?)");
	    System.out.print("  ");
	    currentSickness = sc.nextLine();
	    
	    
	    if(addingSuccessful) {
        	    System.out.println("  => Should we add more patients? (y/n)" );
        	    System.out.print("  ");
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
        		addingMorePatients = false;
        		break;
        	    default:
        		System.out.println("  => yes or no?");
        	    }
	    }
	}while(addingMorePatients);
	
	
	
	
    }
    
    
    //==============================================
    //filter out sex types, so that only the allowed ones are left
    //either male or female
    public String normalizeSexType() {
	boolean validSexType = false;
	String sex = "";
	
	do {
	    System.out.print("  ");
	    sex = sc.nextLine();
	    sex = sex.toLowerCase();
	    
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
	    case "m":
		
		sex = "male";
		validSexType = true;
		break;
		
	    case "female":
	    case "woman":
	    case "wife":
	    case "girl":
	    case "frau":
	    case "f":
	    case "w":
		
		sex = "female";
		validSexType = true;
		break;
		
	    default:
		System.out.println("  -- invalid sex type\n=> please try again");
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
	    System.out.print("  ");
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
