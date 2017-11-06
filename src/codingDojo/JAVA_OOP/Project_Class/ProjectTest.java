package codingDojo.JAVA_OOP.Project_Class;

public class ProjectTest {
    public static void main(String[] args) {

        Project_Class project1 = new Project_Class();
        project1.setName("ATLAS");
        project1.setDescription("Search Engine");
        Project_Class project2 = new Project_Class("Auto Search");
        project2.setDescription("Search auto parts and tires");
        Project_Class project3 = new Project_Class("Sports Search", "search for sports subsidiary");

        project1.setInitialCost(20000);
        project2.setInitialCost(30000);
        project3.setInitialCost(50000);

        Portfolio portfolio = new Portfolio();
        portfolio.addToPortfolio(project1);
        portfolio.addToPortfolio(project2);
        portfolio.addToPortfolio(project3);



        System.out.println(project1.elevatorPitch());

        System.out.println(portfolio.getPortfolioCost());

        portfolio.showPortfolio();



    }
}
