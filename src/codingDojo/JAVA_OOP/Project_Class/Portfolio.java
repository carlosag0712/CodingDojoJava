package codingDojo.JAVA_OOP.Project_Class;

import java.util.ArrayList;

public class Portfolio {
    ArrayList<Project_Class> projects = new ArrayList<>();

    public ArrayList<Project_Class> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project_Class> projects) {
        this.projects = projects;
    }


    public void addToPortfolio(Project_Class project){
        projects.add(project);
    }

    public double getPortfolioCost(){
        double TotalCost = 0.0;

        for(Project_Class project: projects){

            TotalCost += project.getInitialCost();


        }


        return TotalCost;
    }

    public void showPortfolio(){
        double TotalCost =0.0;

        System.out.println("=====================================");
        System.out.println("SHOW PORTFOLIO");
        for(Project_Class project : projects){
            System.out.println(project.elevatorPitch());
            TotalCost += project.getInitialCost();
        }

        System.out.println("Total Portfolio Cost: "+TotalCost);
    }
}
