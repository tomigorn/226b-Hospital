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
	
	System.out.println("\nWhat do you want to do now?\n   1) add a staff member\n   2) add a patient\n   3) change the hospital's name\n   4) act as a Doctor\n   5) act as a patient");
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
	
	while(addingMoreStaff) {
	    if(addingSuccessful) {
		System.out.println("Who are you going to add now?   (Doctor/ Nurse/ Assistent)");
	    }
	    addingSuccessful = false;
	    addingPossible = true;
	    
	    String position = "";
	    position = sc.nextLine();
	    
	    position = position.toLowerCase();
	    
	    switch(position) {
	    case "1":
	    case "doctor":
	    case "doc":
	    case "d":
		System.out.println("What's the doctor's name?");
		String input = sc.nextLine();
		for(Staff staffmember: staffWorkingHere) {
		    if(staffmember.getPosition().equals("Doctor") && staffmember.getName().equals(input)) {
			addingPossible = false;
		    }
		}
		if(addingPossible) {
		    staffWorkingHere.add( new Doctor(input) );
		}else {
		    System.out.println("This Doctor already works here!");
		}
		addingSuccessful = true;
	    break;
	    /*
	    case "2":
	    case "nurse":
	    case "n":
	    	staffWorkingHere.add( new Nurse() );
	    	addingSuccessful = true;
	    break;
	    */
	    
	    /*
	    case "3":
	    case "assistent":
	    case "a":
	    	staffWorkingHere.add( new Nurse() );
	    	addingSuccessful = true;
	    break;
	    */
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
	}
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
