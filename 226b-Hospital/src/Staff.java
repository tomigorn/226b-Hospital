
public abstract class Staff extends Human{
    //==============================================
    //Variables   
    private String workingUnit = "";
    private String position = "";
    private double salary = 0;
    //Arbeitspensum
    private double laborStint = 1;

    //==============================================
    //Constructors
    public Staff(String name) {
	super(name);
    }
    
    public Staff() {
    }
    
    //==============================================
    //Methods
    //==============================================
    //Getters & Setters
    
    public String getWorkingUnit() {
        return workingUnit;
    }

    public void setWorkingUnit(String workingUnit) {
        this.workingUnit = workingUnit;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getLaborStint() {
        return laborStint;
    }

    public void setLaborStint(double laborStint) {
        this.laborStint = laborStint;
    }

}
