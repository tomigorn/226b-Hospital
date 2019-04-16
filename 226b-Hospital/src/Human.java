
public abstract class Human {
    //==============================================
    //Variables
    private String name = "";
    private String sex = "";
    
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
    public final String getSex() {
        return sex;
    }

    public final void setSex(String sex) {
        this.sex = sex;
    }
}
