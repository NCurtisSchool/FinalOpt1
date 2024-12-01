public class Students {
    // Attributes
    protected String name;
    protected String address;
    protected double gpa;

    // Constructor
    public Students(String name, String address, double gpa) {
        this.name = name;
        this.address = address;
        this.gpa = gpa;
    }
    
    // Getters
    protected String getName() {return name;}
    protected String getAddress() {return address;}
    protected double getGpa() {return gpa;}

    // Method
    @Override
    public String toString() {
        return String.format("%1$-24s %2$-10s %3$s", name, gpa, address);
    }
}