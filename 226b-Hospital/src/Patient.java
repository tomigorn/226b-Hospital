public final class Patient extends Human{
    //==============================================
    //Variables
    private String sickness = "";

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

    //==============================================
    //Getter & Setter
    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    
}
