package codingDojo.JAVA_OOP.ObjectMaster_PartTwo;

public class Human {
    protected int health = 100;
    protected int strength = 3;
    protected int stealth = 3;
    protected int intelligence = 3;
    protected String name;

    public void attack(Human human){
        human.health = human.health-strength;
        System.out.println("Current health after attack: "+human.health);

    }

    public void showHealth(){
        System.out.println("health: "+this.health);
    }


}
