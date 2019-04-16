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
	System.out.println("Whats the name of the hospital?");
	setName( sc.nextLine() );
	System.out.println("Welcome to " + name);
	
	System.out.println("Now let's add some staff:");
	addStaff();
	
	System.out.println("After adding staffmembers let's add some patients.");
	addPatients();
	
	System.out.println("\nWhat do you want to do now?\n   1) act as a staff member\n   2) act as a patient\n   3) change this hospital's name\n   4) go to a different hospital");
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
	System.out.println("There are Doctors, Nurses and Assistants. What's the new staffmembers position?");
	
	boolean addingMoreStaff = true;
	boolean addingSuccessful = false;
	boolean addingPossible = true;
	
	do{
	    if(addingSuccessful) {
		System.out.println("Who are you going to add now?   (Doctor/ Nurse/ Assistent)");
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
		System.out.println("What's the doctor's name?");
		String input = sc.nextLine();
		addingPossible = staffAlreadyExists("Doctor", input);//checks if a Nurse with this name already works at the hospital
		
		if(addingPossible) {
		    staffWorkingHere.add( new Doctor(input) );
		}else {
		    System.out.println("\nerror:\n   This Doctor already works here!");
		}
		addingSuccessful = true;
		break;
	    
	    case "2":
	    case "nurse":
	    case "n":
		System.out.println("What's the nurse's name?");
		input = sc.nextLine();
		addingPossible = staffAlreadyExists("Nurse", input);//checks if a Nurse with this name already works at the hospital
		
		if(addingPossible) {
		    staffWorkingHere.add( new Nurse(input) );
		}else {
		    System.out.println("\nerror:\n   This nurse already works here!");
		}
	    	addingSuccessful = true;
	    	break;
	    
	    
	    case "3":
	    case "assistent":
	    case "a":
		System.out.println("What's the assistant's name?");
		input = "";
		input = sc.nextLine();
	    	addingPossible = staffAlreadyExists("Assistant", input);//checks if a Nurse with this name already works at the hospital
		
		if(addingPossible) {
		    staffWorkingHere.add( new Assistant(input) );
		}else {
		    System.out.println("\nerror:\n   This assistant already works here!");
		}
	    	addingSuccessful = true;
	    	break;
	    
	    default:
		System.out.println("Whoops. That's not the expected input. Please try again.");
	    }
	
	    if(addingSuccessful) {
        	    System.out.println("\nShould we add somebody else? (y/n)" );
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
        		System.out.println("yes or no?");
        	    }
	    }
	}while(addingMoreStaff);
    }
    
    private boolean staffAlreadyExists(String string, String input) {
	boolean addingPossible = true;
	for(Staff staffmember: staffWorkingHere) {
	    if(staffmember.getPosition().equals(string) && staffmember.getName().equals(input)) {
		addingPossible = false;
	    }
	}
	return addingPossible;
    }

    public void addPatients() {
	System.out.println("Whats the patient's name?");

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
