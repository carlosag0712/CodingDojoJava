package codingDojo.JAVA_OOP.Project_Class;

public class Project_Class {
    private String name;
    private String description;
    private double initialCost;

    public Project_Class(){


    }

    public Project_Class(String name) {
        this.name = name;

    }

    public Project_Class(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project_Class(String name, String description, double initialCost) {
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String elevatorPitch(){
        return "Project Name: "+this.name +"\n"+ "Project Description: "+this.description +"\n"+"Project Cost: "+this.initialCost;
    }

    public double getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(double initialCost) {
        this.initialCost = initialCost;
    }
}
