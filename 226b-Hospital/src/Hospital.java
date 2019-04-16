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
	System.out.println("This is a simulation of a hospital");
	System.out.println("==================================");
	System.out.println("\n=> Whats the name of the first hospital you're going to visit?");
	setName( sc.nextLine() );
	System.out.println("-- Welcome to " + name + ".");
	
	System.out.println("\n=> now let's add some staff:");
	addStaff();
	
	System.out.println("=> After adding staffmembers let's add some patients.");
	addPatients();
	
	System.out.println("\nPatients have been added.\n=> What do you want to do now?\n   1) act as a staff member\n   2) act as a patient\n   3) change this hospital's name\n   4) go to a different hospital\n      99) exit the simulation");
	action();
    }

    //==============================================
    //main
    public static void main(String[] args) {
	new Hospital();
    }

    //==============================================
    //Methods
    public void setName(String name) {
	this.name = name;
    }
    

    
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
	    
	    switch(staffPosition) {
	    case "1":
	    case "doctor":
	    case "doc":
	    case "d":
		System.out.println("=> What's the doctor's name?");
		String input = sc.nextLine();
		//addingPossible = staffAlreadyExists("Doctor", input);//checks if a Nurse with this name already works at the hospital
		
		if(addingPossible) {
		    staffWorkingHere.add( new Doctor(input) );
		    System.out.println("-- Doctor " + input + " has been added.");
		}else {
		    System.out.println("\n-- error:\n   Doctor " + input + " already works in " + this.name + "!");
		}
		addingSuccessful = true;
		break;
	    
	    case "2":
	    case "nurse":
	    case "n":
		System.out.println("=> What's the nurse's name?");
		input = sc.nextLine();
		
		System.out.println("=> What's the nurse's sex?");
		
		String sex = sc.nextLine();
		boolean validSexType = false;
		do {
		    sex = sex.toLowerCase();
		    
		    switch(sex) {
		    case "male":
		    case "männlich":
		    case "herr":
		    case "mann":
		    case "mister":
			validSexType = true;
		    case "female":
		    case "weiblich":
		    case "frau":
			validSexType = true;
		    default:
			System.out.println("=> invalid sex type. please reenter sex type:");
			sex = sc.nextLine();
			validSexType = false;
		    }
		}while(!validSexType);
		
		addingPossible = staffAlreadyExists("Nurse", input, sex);//checks if a Nurse with this name already works at the hospital
		String salutation = "";
		if(addingPossible) {
		    staffWorkingHere.add( new Nurse(input) );
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
    
    private boolean staffAlreadyExists(String string, String input, String sex) {
	boolean addingPossible = true;
	for(Staff staffmember: staffWorkingHere) {
	    if(staffmember.getPosition().equals(string) && staffmember.getName().equals(input) && staffmember.getSex().equals(sex)) {
		addingPossible = false;
	    }
	}
	return addingPossible;
    }
    
    private String staffSalutation(String position, String name, String sex) {
	String salutation = "";
	for(Staff staffmember: staffWorkingHere) {
	    if(staffmember.getPosition().equals(position) && staffmember.getName().equals(name) && staffmember.getSex().equals(sex)) {
		salutation = staffmember.getSalutation();
	    }
	}
	return salutation;
    }

    public void addPatients() {
	System.out.println("=> Whats the patient's name?");

    }
    
    
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
