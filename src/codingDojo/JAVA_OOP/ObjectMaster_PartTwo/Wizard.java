package codingDojo.JAVA_OOP.ObjectMaster_PartTwo;

/*

The Wizard class should have a default health of 50 and intelligence of 8; a method called heal that heals whomever
it was cast on for an amount equal to the wizard's intelligence; and a method called fireball that decreases the health
of whichever object it attacked by 3 * the wizard's intelligence.
 */

public class Wizard extends Human {

    public Wizard(){
        this.health = 50;
        this.intelligence = 8;
        this.name = "Wizard";
    }

    public void heal(Human human){
        human.health += this.intelligence;
        System.out.println(human.name+" was healed by Wizard and now has the following health "+human.health );

    }






}
