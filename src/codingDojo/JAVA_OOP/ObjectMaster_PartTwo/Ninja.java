package codingDojo.JAVA_OOP.ObjectMaster_PartTwo;


//The Ninja class should have a default stealth of 10; a method, steal, that takes health from another human by their
// stealth level, and a way to run away that decreases their health by 10.

public class Ninja extends Human {

    public Ninja(){
        this.stealth =10;
        this.name = "Ninja";
    }

    public void steal(Human human){
        human.health -= this.stealth;

        System.out.println("took "+human.stealth+" new health for "+human.name+" is "+human.health);
    }

    public void runaway(){
        this.health -= 10;
        System.out.println("Ninja ran away, new tired health "+this.health);
    }



}
