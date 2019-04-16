
public abstract class Human {
    //==============================================
    //Variables
    private String name = "";
    private String sex = "";
    private String salutation = "";
    
    //==============================================
    //Constructors   
    public Human(String name) {
	this.name = name;
    }
    public Human() {
    }

    //==============================================
    //Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //==============================================
    //final Methods
    final public void sayName() {
	System.out.println("My name is " + name);
    }

    //==============================================
    //abstract Methods
    abstract public void tellStatus();
    
    //==============================================
    //Getters & Setters

    public String getSalutation() {
	return salutation;
    }
    
    public final String getSex() {
        return sex;
    }

    public final boolean setSex(String sex) {
	sex = sex.toLowerCase();
	
        switch(sex) {
        case "male":
        case "männlich":
        case "herr":
        case "mann":
        case "mister":
            this.sex = "male";
            this.salutation = "Mr.";
            return true;
        case "female":
        case "weiblich":
        case "frau":
            this.sex = "female";
            this.salutation = "Ms.";
            return true;
        default:
            break;
        }
        return false;
    }
    
    public final boolean compareSex(String sex) {
	sex = sex.toLowerCase();
	
	switch(sex) {
        case "male":
        case "männlich":
        case "herr":
        case "mann":
        case "mister":
            if(this.getSex() == "male") {
        	return true;
            }
        case "female":
        case "weiblich":
        case "frau":
            if(this.getSex() == "female") {
        	return true;
            }
        default:
            break;
        }
        return false;
    }
}
